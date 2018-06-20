package eu.bambz.fwc18simplebetsystem.infrastructure.rest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfig {

    @Bean
    ResponseResolver responseResolver() {
        return new ResponseResolver();
    }

}
