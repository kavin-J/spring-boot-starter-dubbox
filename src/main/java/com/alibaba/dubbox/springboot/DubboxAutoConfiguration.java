package com.alibaba.dubbox.springboot;

import com.alibaba.dubbo.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jkevin
 * @create 2017-07-26
 **/
@Configuration
@EnableConfigurationProperties(DubboxProperties.class)
public class DubboxAutoConfiguration {

    @Autowired
    private DubboxProperties dubboxProperties;

    @Bean
    public ApplicationConfig requestApplicationConfig() {
        return dubboxProperties.getApplication();
    }

    @Bean
    public RegistryConfig requestRegistryConfig() {
        return dubboxProperties.getRegistry();
    }

    @Bean
    public ProtocolConfig requestProtocolConfig() {
        return dubboxProperties.getProtocol();
    }

    @Bean
    public ProviderConfig requestProviderConfig() {
        return dubboxProperties.getProvider();
    }

    @Bean
    public ConsumerConfig requestConsumerConfig() {
        return dubboxProperties.getConsumer();
    }

    @Bean
    public MonitorConfig requestMonitorConfig() {
        return dubboxProperties.getMonitor();
    }
}
