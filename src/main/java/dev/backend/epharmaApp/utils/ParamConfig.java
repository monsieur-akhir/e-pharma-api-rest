package dev.backend.epharmaApp.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ParamConfig {
	// les parametres de SMTP
	@Value("#{'${redis.nodes}'.split(',')}")
	private List<String> nodes;

	@Value("${redis.clusterName}")
	private String clusterName;

	@Value("${redis.host}")
	private String redisHost;

	@Value("${redis.port}")
	private Integer redisPort;

	@Value("${redis.password}")
	private String redisPassword;

}
