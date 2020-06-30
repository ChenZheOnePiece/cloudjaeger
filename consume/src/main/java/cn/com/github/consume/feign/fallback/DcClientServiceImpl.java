package cn.com.github.consume.feign.fallback;

import cn.com.github.consume.feign.DcClientService;
import org.springframework.stereotype.Service;

/**
 * 
 * ClassName: DcClientServiceImpl
 * @Description: Hystrix服务降级回调的方法
 * @Author wanghw
 * @CreatDate 2018年7月24日
 */
@Service
public class DcClientServiceImpl implements DcClientService {

	@Override
	public String consumer() {
        return "服务器开小差啦";
	}

}
