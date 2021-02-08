package com.microee.ipserver.rmi;

import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.microee.plugin.context.AppContext;
import feign.RequestInterceptor;

/**
 * 配置头部参数
 */
@Configuration
public class IPServerDiscoverClientConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(IPServerDiscoverClientConfiguration.class);

    @Value("${micro.services.ipserver-discover.listOfServers}")
    private String listOfServers;

    @Bean
    public RequestInterceptor feignRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(feign.RequestTemplate template) {
                AppContext.putFeignTimestamp(Instant.now().toEpochMilli());
                LOGGER.info("feign request prepared: serviceName={} url={}{}", "ipserver-discover", listOfServers, template.request().url());
            }
        };
    }
}
