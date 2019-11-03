 package com.laboratoire.checklist.configuration;

 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
 import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

 import javax.persistence.EntityManager;

 @Configuration
 public class DatabaseConfig implements RepositoryRestConfigurer {

     private Logger logger = LoggerFactory.getLogger(DatabaseConfig.class.getName());

     @Autowired
     private EntityManager entityManager;

     @Override
     public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
 //        this.logger.info("Appelle bien la configuration");
     }
 }
