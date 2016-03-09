package com.performance;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@WebAppConfiguration
@Retention(RetentionPolicy.RUNTIME)
@SpringApplicationConfiguration(classes = DandelionPerformanceTestApplication.class)
public @interface IntegrationTest {
}