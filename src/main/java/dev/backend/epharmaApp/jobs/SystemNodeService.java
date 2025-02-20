package dev.backend.epharmaApp.jobs;

import com.google.gson.Gson;
import dev.backend.epharmaApp.factory.RedisEnum;
import dev.backend.epharmaApp.factory.RedisFactory;
import dev.backend.epharmaApp.factory.RedisValue;
import dev.backend.epharmaApp.utils.ParamConfig;
import dev.backend.epharmaApp.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class SystemNodeService {

	@Autowired
	private RedisFactory redisFactory;
	@Autowired
	private Node nodeObject;

	@Autowired
	private ParamConfig paramConfig;

	private RedisValue<NodeDto> redisValue;

	private List<String> list_of_ip;

	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@PostConstruct
	public void init() {
		// Initialisation de la liste des IP après l'injection des dépendances
		list_of_ip = Arrays.asList(paramConfig.getRedisHost());
	}

	/**
	 * create (if not exist) a node in redis server update lastPing value of a node
	 *
	 * @param node
	 */
	public void pingNode(NodeDto node, boolean isDelay) {
		redisValue = redisFactory.get(RedisEnum.NODE.name());
		if (redisValue == null) {
			return;
		}
		final NodeDto nodeDto = (NodeDto) redisValue.get(node.getName());
		if (nodeDto == null) {
			this.createNode(node, isDelay);
			return;
		}
		nodeDto.setLastPing(simpleDateFormat.format(new Date()));
		updateNode(nodeDto, isDelay);
	}

	private void createNode(NodeDto node, boolean isDelay) {
		if (list_of_ip.stream().anyMatch(s -> node.getName().split("-")[2].contains(s))) {
			node.setLeader(Boolean.FALSE);
			node.setCreatedAt(simpleDateFormat.format(new Date()));
			redisValue.save(node.getName(), node, isDelay);
		}
	}

	public void updateNode(NodeDto node, boolean isDelay) {
		if (list_of_ip.stream().anyMatch(s -> node.getName().split("-")[2].contains(s))) {
			redisValue.save(node.getName(), node, isDelay);
		}
	}

	public void electLeader(NodeDto nodeDto, boolean isDelay) {
		System.out.println("electLeader en cours");

		System.out.println("noeud executant : " + new Gson().toJson(nodeDto));
		redisValue = redisFactory.get(RedisEnum.NODE.name());
		if (redisValue == null) {
			return;
		}
		String pattern = this.getNodePattern(nodeDto);
		List<NodeDto> activeNodes = nodeObject.getClusterNodes(pattern);
		NodeDto leader = findLeader(activeNodes);

		if (leader != null && !leader.isDown()) {
			activeNodes.forEach(node -> {
				if (list_of_ip.stream().anyMatch(s -> node.getName().split("-")[2].contains(s))) {
					node.setLeader(false);
					if (leader.getName().equals(node.getName())) {
						node.setLeader(true);
					}
					this.redisValue.save(node.getName(), node, isDelay);
					System.out.println("noeud updated : " + new Gson().toJson(node));
				} else {
					System.out.println("don't save noeud : " + node.getName().split("-")[2]);
				}
			});
		} else {
			activeNodes.forEach(node -> {
				if (list_of_ip.stream().anyMatch(s -> node.getName().split("-")[2].contains(s))) {
					node.setLeader(false);
					if (node.getName().equals(nodeDto.getName())) {
						node.setLeader(true);
					}
					this.redisValue.save(node.getName(), node, isDelay);
					System.out.println("noeud updated : " + new Gson().toJson(node));
				} else {
					System.out.println("don't save noeud : " + node.getName().split("-")[2]);
				}
			});
		}

		List<NodeDto> nodesSaved = nodeObject.getClusterNodes(pattern);
		NodeDto nodeLeader = nodesSaved.stream().filter(n -> n.isLeader()).findFirst().orElse(null);
		if (Objects.nonNull(nodeLeader)) {
			System.out.println("noeud leader : " + new Gson().toJson(nodeLeader));
		}
	}

	public void shutdownNode(NodeDto nodeDto, boolean isDelay) {
		System.out.println("shutdown inactives nodes process");
		System.out.println("noeud executant : " + new Gson().toJson(nodeDto));
		redisValue = redisFactory.get(RedisEnum.NODE.name());
		if (redisValue == null) {
			return;
		}
		String pattern = this.getNodePattern(nodeDto);
		List<NodeDto> activeNodes = nodeObject.getClusterNodes(pattern);

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		final Date currentDate = new Date();
		if (Utilities.isNotEmpty(activeNodes)) {
			activeNodes.forEach(node -> {
				try {
					if (node.getLastPing() != null) {
						Date lastPingDate = format.parse(node.getLastPing());
						long diff = currentDate.getTime() - lastPingDate.getTime();
						long diffMinutes = diff / (60 * 1000) % 60;
						System.out.println("diffMinutes (temps d'inactivite): " + diffMinutes);
						if (diffMinutes >= 10 && !Objects.equals(nodeDto.getName(), node.getName())) {
							if (list_of_ip.stream().anyMatch(s -> node.getName().split("-")[2].contains(s))) {
								node.setDown(true);
								this.redisValue.save(node.getName(), node, isDelay);
								System.out.println("noeud down : " + new Gson().toJson(node));
							} else {
								System.out.println("don't save noeud : " + node.getName().split("-")[2]);
							}
						} else {
							if (list_of_ip.stream().anyMatch(s -> node.getName().split("-")[2].contains(s))) {
								node.setDown(false);
								this.redisValue.save(node.getName(), node, isDelay);
								System.out.println("noeud actif : " + new Gson().toJson(node));
							} else {
								System.out.println("don't save noeud : " + node.getName().split("-")[2]);
							}
						}
					} else {
						if (list_of_ip.stream().anyMatch(s -> node.getName().split("-")[2].contains(s))) {
							node.setDown(true);
							this.redisValue.save(node.getName(), node, isDelay);
							System.out.println("noeud down : " + new Gson().toJson(node));
						} else {
							System.out.println("don't save noeud : " + node.getName().split("-")[2]);
						}
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			});
		}

		System.out.println("end shutdown process");
	}

	public NodeDto getNodeDto(NodeDto nodeDto) {
		redisValue = redisFactory.get(RedisEnum.NODE.name());
		if (redisValue == null) {
			return null;
		}
		return (NodeDto) redisValue.get(nodeDto.getName());
	}

	public boolean isLeader(NodeDto nodeDto) {
		return nodeDto.isLeader();
	}

	private String getNodePattern(NodeDto nodeDto) {
		return nodeDto.getName().substring(0, nodeDto.getName().lastIndexOf("-"));
	}

	private NodeDto findLeader(List<NodeDto> nodes) {
		return nodes.stream().filter(NodeDto::isLeader).findFirst().orElse(null);
	}
}
