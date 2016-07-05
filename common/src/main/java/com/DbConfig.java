package com;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

	private final static String DB_ENV_VAR = "JDBC_DATABASE_URL";
	
	@Bean
	public DataSource getDataSource() {
		
		final String pgUrl = Utils.getEnvOrThrow(DbConfig.DB_ENV_VAR);

		return DataSourceBuilder.create()
				.url(pgUrl)
				.driverClassName("org.postgresql.Driver")
				.build();
	}
}
