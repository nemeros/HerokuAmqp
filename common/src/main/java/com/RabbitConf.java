package com;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {

	public static final String helloQueueName = "hello.queue";
	
	@Bean
	public ConnectionFactory connectionFactory() {
	    final URI ampqUrl;
	    try {
	        ampqUrl = new URI(getEnvOrThrow("CLOUDAMQP_URL"));
	    } catch (URISyntaxException e) {
	        throw new RuntimeException(e);
	    }
	
	    final CachingConnectionFactory factory = new CachingConnectionFactory();
	    factory.setUsername(ampqUrl.getUserInfo().split(":")[0]);
	    factory.setPassword(ampqUrl.getUserInfo().split(":")[1]);
	    factory.setHost(ampqUrl.getHost());
	    factory.setPort(ampqUrl.getPort());
	    factory.setVirtualHost(ampqUrl.getPath().substring(1));
	
	    return factory;
	}
	
	@Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
	}
	
	
	@Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(RabbitConf.helloQueueName);
        template.setQueue(RabbitConf.helloQueueName);
        return template;
	}
	
	
	@Bean
    public Queue queue() {
        return new Queue(RabbitConf.helloQueueName);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	 private static String getEnvOrThrow(String name) {
	        final String env = System.getenv(name);
	        
	        if (env == null) {
	            throw new IllegalStateException("Environment variable [" + name + "] is not set.");
	        }
	        
	        return env;
	}
}
