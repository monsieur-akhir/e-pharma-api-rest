package dev.backend.epharmaApp.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import dev.backend.epharmaApp.factory.RedisEnum;
import dev.backend.epharmaApp.factory.RedisValue;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;



@Component
public class Node implements RedisValue<NodeDto> {

	@Autowired
	private RedisTemplate<String, NodeDto> nodeTemplate;

	@Override
	public NodeDto get(String key) {
		try {
			return nodeTemplate.opsForValue().get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Set<String> getKeys(String pattern) {
		try {
			return nodeTemplate.keys(pattern + "*");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<NodeDto> getClusterNodes(String pattern) {
		try {
			return nodeTemplate.opsForValue().multiGet(this.getKeys(pattern));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supports(String s) {
		return RedisEnum.NODE.name().equals(s);
	}

	@Override
	public void delete(String key) {
		nodeTemplate.delete(key);
	}

	@Override
	public void Re() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean save(String key, NodeDto value, boolean isDelay) {
		try {
			if (isDelay) {
				nodeTemplate.opsForValue().set(key, (NodeDto) value, 5, TimeUnit.MINUTES);
				return true;
			}else {
				nodeTemplate.opsForValue().set(key, value);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
