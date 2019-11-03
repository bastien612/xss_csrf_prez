 package com.laboratoire.checklist.configuration;

 import org.springframework.context.annotation.Configuration;
 import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
 import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

 @Configuration
 public class SpringDataRestConfig implements RepositoryRestConfigurer {

     @Override
     public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
         System.out.println("call cors config");
         config.getCorsRegistry().addMapping("/**");
     }
 }
