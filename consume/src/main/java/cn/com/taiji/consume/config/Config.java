package cn.com.taiji.consume.config;

import cn.com.taiji.consume.bean.MDCScopeManager;
import io.opentracing.contrib.java.spring.jaeger.starter.TracerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public TracerBuilderCustomizer mdcBuilderCustomizer() {
        return builder -> builder.withScopeManager(new MDCScopeManager());
    }
}
