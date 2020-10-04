package com.bookworld.bookapp.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages= "com.bookworld.bookapp.persistence.repository")
public class PersistenceConfig {

}
