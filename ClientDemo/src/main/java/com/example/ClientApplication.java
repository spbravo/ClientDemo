package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.MeterRegistry;
import io.prometheus.client.CollectorRegistry;
@EnableFeignClients
@SpringBootApplication
public class ClientApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(ClientApplication.class, args);

        System.out.println("Updateando :");
        

	}
	@Bean
	public CollectorRegistry collectorRegistry() {
	    return CollectorRegistry.defaultRegistry;
	}
	@Bean
	MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
	    return registry -> registry.config().commonTags("region", "eu-central-1");
	}
}
