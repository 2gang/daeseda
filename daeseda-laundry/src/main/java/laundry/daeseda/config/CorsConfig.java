package laundry.daeseda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/users/**", config);
        source.registerCorsConfiguration("/category/**", config);
        source.registerCorsConfiguration("/clothes/**", config);
        source.registerCorsConfiguration("/notice/**",config);
        source.registerCorsConfiguration("/board/**",config);
        source.registerCorsConfiguration("/reply/**",config);
        source.registerCorsConfiguration("/image/**",config);
        source.registerCorsConfiguration("/review/**",config);
        source.registerCorsConfiguration("/review-category/**",config);
        return new CorsFilter(source);
    }
}
