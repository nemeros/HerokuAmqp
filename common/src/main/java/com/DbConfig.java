package com;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

	private final static String DB_ENV_VAR = "DATABASE_URL";
	
	@Bean
	public DataSource getDataSource() throws URISyntaxException {
		
		final URI pgUrl = new URI(Utils.getEnvOrThrow(DbConfig.DB_ENV_VAR));

		return DataSourceBuilder.create()
				.url("jdbc:postgresql://" + pgUrl.getHost() + ':' + pgUrl.getPort() + pgUrl.getPath())
				.username(pgUrl.getUserInfo().split(":")[0])
				.password(pgUrl.getUserInfo().split(":")[1])
				.driverClassName("org.postgresql.Driver")
				.build();
	}
}
