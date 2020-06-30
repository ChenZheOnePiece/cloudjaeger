package cn.com.github.consume.feign;

import cn.com.github.consume.feign.fallback.DcClientServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * ClassName: DcClient
 * @Description: 消费provide 用于生产jaeger日志
 * @Author chenzhe
 * @CreatDate 2020年1月2日
 */

@FeignClient(value = "provide",fallback = DcClientServiceImpl.class)
public interface DcClientService {
	@GetMapping("/dc")
	String consumer();
}
