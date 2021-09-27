package com.yamman.xml.validator.config;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;

@Configuration
public class TestDataSourceConfig {

    @Bean
    public DataSource getEmbeddedDataSource() throws IOException {
        return EmbeddedPostgres.start().getPostgresDatabase();
    }

}
