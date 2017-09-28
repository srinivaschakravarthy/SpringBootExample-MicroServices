package com.example.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class SimpleServiceConfiguration {

	@Autowired
	public IClientConfig ribbonClientConfig;
	
	
	/*
	 * This method is going to define how your client will ping instances that
	 * Ribbon will be load balancing to make sure they are available
	 */
	@Bean
	public IPing ping(IClientConfig config)
	{
		return new PingUrl(); //PingUrl is implementation of IPing
	}
	
	/*
	 * This method defines load balancing strategy.
	 * such as basic Round robbin
	 */
	@Bean
	public IRule rule(IClientConfig config)
	{
		return new AvailabilityFilteringRule(); // this is going to filter client based on the criteria found in the AvailabilityFilteringRule.
		
	}
}
