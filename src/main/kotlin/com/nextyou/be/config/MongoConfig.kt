package com.nextyou.be.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.MongoCredential
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate

@Configuration
class MongoConfig(
    private val mongoProperties: MongoProperties,
) : AbstractReactiveMongoConfiguration() {

    override fun reactiveMongoClient(): MongoClient {
        val credential = MongoCredential.createCredential(mongoProperties.username, mongoProperties.authenticationDatabase, mongoProperties.password)
        val connectionString = ConnectionString(mongoProperties.uri)

        return MongoClients.create(
            MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .credential(credential)
                .build()
        )
    }

    override fun getDatabaseName(): String {
        return mongoProperties.database;
    }

    @Bean
    fun reactiveMongoTemplate(): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(reactiveMongoClient(), databaseName)
    }

}