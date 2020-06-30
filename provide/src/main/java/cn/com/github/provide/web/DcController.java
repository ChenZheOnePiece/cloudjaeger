package cn.com.github.provide.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * ClassName: DcController
 * @Description: TODO
 * @CreatDate 2020.1.6
 */
@RestController
public class DcController {
	@Autowired
	DiscoveryClient discoveryClient;
	/**
	 * 
	 * @Description 实现/dc请求处理接口，通过DiscoveryClient对象，在日志中打印出服务实例的相关内容
	 */
	//使用slf4j的Logger类记录日志，此条日志相关的追踪信息会由Sleuth自动生成并记录。
	private static Logger log=LoggerFactory.getLogger(DcController.class);

	@GetMapping("/dc")
	public String dc() throws InterruptedException {
	    String services = "Services: " + discoveryClient.getServices();
        //此处进行日志追踪
        log.info(services);
		return services;
	}
}
