package com.alibaba.dubbox.springboot;

import com.alibaba.dubbo.config.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Jkevin
 * @create 2017-07-26
 **/
@ConfigurationProperties(prefix = "spring.dubbo")
public class DubboxProperties {

    private String scan;

    private ApplicationConfig application;

    private RegistryConfig registry;

    private ProtocolConfig protocol;

    private ProviderConfig provider;

    private ConsumerConfig consumer;

    private MonitorConfig monitor;

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

    public ApplicationConfig getApplication() {
        application = setDefault(ApplicationConfig.class, application);
        return application;
    }

    public void setApplication(ApplicationConfig application) {
        this.application = application;
    }

    public RegistryConfig getRegistry() {
        registry = setDefault(RegistryConfig.class, registry);
        return registry;
    }

    public void setRegistry(RegistryConfig registry) {
        this.registry = registry;
    }

    public ProtocolConfig getProtocol() {
        protocol = setDefault(ProtocolConfig.class, protocol);
        return protocol;
    }

    public void setProtocol(ProtocolConfig protocol) {
        this.protocol = protocol;
    }

    public ProviderConfig getProvider() {
        provider = setDefault(ProviderConfig.class, provider);
        return provider;
    }

    public void setProvider(ProviderConfig provider) {
        this.provider = provider;
    }

    public ConsumerConfig getConsumer() {
        consumer = setDefault(ConsumerConfig.class, consumer);
        return consumer;
    }

    public void setConsumer(ConsumerConfig consumer) {
        this.consumer = consumer;
    }

    public MonitorConfig getMonitor() {
        monitor = setDefault(MonitorConfig.class, monitor);
        return monitor;
    }

    public void setMonitor(MonitorConfig monitor) {
        this.monitor = monitor;
    }

    private static <T> T setDefault(Class<T> clazz, T cfg) {
        if (null == cfg) {
            try {
                cfg = clazz.newInstance();
                Field field = clazz.getDeclaredField("isDefault");
                Method fieldSetMet = clazz.getMethod("setDefault",
                        field.getType());
                fieldSetMet.invoke(cfg, true);
                return cfg;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cfg;
    }
}
