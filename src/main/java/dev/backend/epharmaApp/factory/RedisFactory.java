package dev.backend.epharmaApp.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisFactory {

	private final List<RedisValue> serviceList;

	@Autowired
	public RedisFactory(List<RedisValue> serviceList) {
		this.serviceList = serviceList;
	}

	public RedisValue get(String s) {
		return serviceList.stream().filter(service -> service.supports(s)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
