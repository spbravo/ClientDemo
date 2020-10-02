package com.example.resilience;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
@Component
public class SampleBean {
	 private final Counter counter;

	    public SampleBean(MeterRegistry registry) {
	        this.counter = registry.counter("received.messages");
	    }

	    public void handleMessage(String message) {
	        this.counter.increment();
	        System.out.println("El numero de peticiones es "+this.counter.count());
	        // handle message implementation
	    }

}
