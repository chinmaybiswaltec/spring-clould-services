package com.chinmaybiswaltec.limitservice.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("limit-service")
@Component
public class Configuration {
	private int min;
	private int max;
}
