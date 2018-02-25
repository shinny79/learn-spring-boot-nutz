package com.demo.springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(SqlManager.class)
@EnableConfigurationProperties(SqlManagerProperties.class)
public class SqlManagerAutoConfiguration {
}
