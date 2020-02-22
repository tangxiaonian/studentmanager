package com.tang.studentmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Classname CoreConfig
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 10:21
 * @Created by ASUS
 */
@Configuration
public class CoreConfig {

    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 允许发送cookie
        corsConfiguration.setAllowCredentials(true);

        corsConfiguration.addAllowedOrigin("http://localhost:8080");

        corsConfiguration.addAllowedMethod("*");

        corsConfiguration.addAllowedHeader("*");

        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);

        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}