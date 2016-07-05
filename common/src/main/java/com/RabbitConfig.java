package com;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	public static final String helloWorldQueueName = "hello.queue";
	
	
	@Bean
    public ConnectionFactory connectionFactory() {
        final URI ampqUrl;
        try {
            ampqUrl = new URI(Utils.getEnvOrThrow("CLOUDAMQP_URL"));
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

//	@Bean
//	public ConnectionFactory connectionFactory(){
//		return new CachingConnectionFactory("localhost");
//	}
	

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(RabbitConfig.helloWorldQueueName);
        template.setQueue(RabbitConfig.helloWorldQueueName);
        return template;
    }

    @Bean
    public Queue queue() {
        return new Queue(RabbitConfig.helloWorldQueueName);
    }
    
    @Bean
    public MessageConverter initMessageConverter(){
    	return new SimpleMessageConverter();
    }
}
