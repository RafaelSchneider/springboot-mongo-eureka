package com.schneider.demo.repository;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.schneider.demo.repository"}, considerNestedRepositories = true)
public class DbConfiguration extends AbstractMongoConfiguration {
    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception
    {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getDatabaseName()
    {
        return "test";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost" , 27017 );
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), "test");
    }
}
