package dev.backend.epharmaApp.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import redis.clients.jedis.exceptions.JedisConnectionException;
import dev.backend.epharmaApp.utils.dto.UsersDto;

@Component
public class RedisUser implements RedisValue<UsersDto> {

	private static final Logger logger = LoggerFactory.getLogger(RedisUser.class);

	@Autowired
	private RedisTemplate<String, UsersDto> redisUserTemplate;

	@Override
	public UsersDto get(String key) {
		try {
			UsersDto user = redisUserTemplate.opsForValue().get(key);
			if (user != null) {
				renewSession(key); // Renouvelle la session uniquement si l'utilisateur est trouvé
			}
			return user;
		} catch (RedisConnectionFailureException | JedisConnectionException e) {
			logger.error("Erreur de connexion à Redis lors de la récupération de l'utilisateur avec la clé : {}");
			return null;
		} catch (DataAccessException e) {
			logger.error("Erreur d'accès aux données lors de la récupération de l'utilisateur avec la clé : {}");
			return null;
		}
	}

	@Override
	public boolean save(String key, UsersDto user, boolean isDelay) {
		try {
			if (isDelay) {
				redisUserTemplate.opsForValue().set(key, user, 40, TimeUnit.MINUTES);
			} else {
				redisUserTemplate.opsForValue().set(key, user);
			}
			renewSession(key); // Renouvelle la session à chaque sauvegarde
			return true;
		} catch (RedisConnectionFailureException | JedisConnectionException e) {
			logger.error("Erreur de connexion à Redis lors de l'enregistrement de l'utilisateur avec la clé : {}");
			return false;
		} catch (DataAccessException e) {
			logger.error("Erreur d'accès aux données lors de l'enregistrement de l'utilisateur avec la clé : {}");
			return false;
		}
	}

	public Set<String> getKeys(String pattern) {
		try {
			return redisUserTemplate.keys(pattern + "*");
		} catch (RedisConnectionFailureException | JedisConnectionException e) {
			logger.error("Erreur de connexion à Redis lors de la récupération des clés avec le pattern : {}", pattern,
					e);
			return null;
		} catch (DataAccessException e) {
			logger.error("Erreur d'accès aux données lors de la récupération des clés avec le pattern : {}", pattern,
					e);
			return null;
		}
	}

	public List<String> getKeys() {
		List<String> keysList = new ArrayList<>();
		try {
			Set<String> keys = redisUserTemplate.keys("*");
			if (keys != null) {
				keysList.addAll(keys);
			}
		} catch (RedisConnectionFailureException | JedisConnectionException e) {
			logger.error("Erreur de connexion à Redis lors de la récupération des clés", e);
		} catch (DataAccessException e) {
			logger.error("Erreur d'accès aux données lors de la récupération des clés", e);
		}
		return keysList;
	}

	public List<UsersDto> getClusterUser(String pattern) {
		try {
			Set<String> keys = this.getKeys(pattern);
			if (keys != null && !keys.isEmpty()) {
				return redisUserTemplate.opsForValue().multiGet(keys);
			}
		} catch (RedisConnectionFailureException | JedisConnectionException e) {
			logger.error(
					"Erreur de connexion à Redis lors de la récupération des utilisateurs du cluster avec le pattern : {}",
					pattern, e);
		} catch (DataAccessException e) {
			logger.error(
					"Erreur d'accès aux données lors de la récupération des utilisateurs du cluster avec le pattern : {}",
					pattern, e);
		}
		return null;
	}

	public Long getTTL(String key) {
		try {
			return redisUserTemplate.getExpire(key);
		} catch (RedisConnectionFailureException | JedisConnectionException e) {
			logger.error("Erreur de connexion à Redis lors de la récupération du TTL pour la clé : {}", key, e);
			return null;
		} catch (DataAccessException e) {
			logger.error("Erreur d'accès aux données lors de la récupération du TTL pour la clé : {}", key, e);
			return null;
		}
	}

	@Override
	public boolean supports(String s) {
		return RedisEnum.USER.name().equals(s);
	}

	@Override
	public void delete(String key) {
		try {
			redisUserTemplate.delete(key);
		} catch (RedisConnectionFailureException | JedisConnectionException e) {
			logger.error("Erreur de connexion à Redis lors de la suppression de la clé : {}", key, e);
		} catch (DataAccessException e) {
			logger.error("Erreur d'accès aux données lors de la suppression de la clé : {}", key, e);
		}
	}

	public void renewSession(String key) {
		try {
			Long ttl = redisUserTemplate.getExpire(key);
			if (ttl != null && ttl < TimeUnit.MINUTES.toSeconds(5)) {
				// Prolonge le TTL uniquement si le TTL restant est inférieur à 5 minutes
				redisUserTemplate.expire(key, 40, TimeUnit.MINUTES);
				// logger.info("Session renouvelée pour la clé : {}", key);
			}
		} catch (RedisConnectionFailureException | JedisConnectionException e) {
			logger.error("Erreur de connexion à Redis lors du renouvellement de la session pour la clé : {}", key, e);
		} catch (DataAccessException e) {
			logger.error("Erreur d'accès aux données lors du renouvellement de la session pour la clé : {}", key, e);
		}
	}

	@Override
	public void Re() {
		// Méthode vide à implémenter si nécessaire
	}
}
