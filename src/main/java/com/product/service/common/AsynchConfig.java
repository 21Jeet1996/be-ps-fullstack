package com.product.service.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsynchConfig  {
	
	@Value("${executor.corePoolSize}")
	private int corePoolSize;
	
	@Value("${executor.maxPoolSize}")
	private int maxPoolSize;
	
	@Value("${executor.queueCapacity}")
	private int queueCapacity;
	
	@Value("${executor.threadNamePrefix}")
	private String threadNamePrefix;
	
	@Bean(name="taskExecutor")
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor  executor=new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueCapacity);
		executor.setThreadNamePrefix(threadNamePrefix);
		executor.initialize();
		return executor;
	}
}
