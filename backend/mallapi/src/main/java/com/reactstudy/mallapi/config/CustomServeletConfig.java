package com.reactstudy.mallapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.reactstudy.mallapi.controller.formatter.LocalDateFormatter;

@Configuration
public class CustomServeletConfig implements WebMvcConfigurer{
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new LocalDateFormatter());
    }
}
