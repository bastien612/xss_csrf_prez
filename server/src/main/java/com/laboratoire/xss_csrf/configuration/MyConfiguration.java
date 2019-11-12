package com.laboratoire.xss_csrf.configuration;

import com.laboratoire.xss_csrf.dto.mapper.RecipeMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class MyConfiguration {

    @Bean
    public RecipeMapper getRecipeMapper() {
        return new RecipeMapper();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}