package com.performance.configuration;

import com.github.dandelion.core.web.DandelionFilter;
import com.github.dandelion.core.web.DandelionServlet;
import com.github.dandelion.datatables.thymeleaf.dialect.DataTablesDialect;
import com.github.dandelion.thymeleaf.dialect.DandelionDialect;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DandelionConfiguration {

    @Bean
    public DataTablesDialect dataTablesDialect() {
        return new DataTablesDialect();
    }

    @Bean
    public DandelionDialect dandelionDialect() {
        return new DandelionDialect();
    }

    @Bean
    public FilterRegistrationBean dandelionFilterRegistrationBean() {
        return new FilterRegistrationBean(new DandelionFilter());
    }

    @Bean
    public ServletRegistrationBean dandelionServletRegistrationBean() {
        return new ServletRegistrationBean(new DandelionServlet(), "/dandelion-assets/*");
    }
}