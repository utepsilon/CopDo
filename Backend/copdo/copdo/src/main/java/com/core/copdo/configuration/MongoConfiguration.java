package com.core.copdo.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableReactiveMongoRepositories(basePackages ="com.core.copdo.repository")
public class MongoConfiguration  extends AbstractReactiveMongoConfiguration {



    @Bean
    public MongoClient mongoClient() {
        final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/copdo");
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected String getDatabaseName() {
        return "copdo";
    }
    @Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.core.copdo");
    }
}
