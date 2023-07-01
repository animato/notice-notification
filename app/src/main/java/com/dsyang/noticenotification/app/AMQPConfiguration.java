package com.dsyang.noticenotification.app;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfiguration {
    static final String topicExchangeName = "notification-exchange";

    static final String queueSlack = "queue-slack";
    static final String queueTelegram = "queue-telegram";

    @Bean(name = "queueSlack")
    Queue queueSlack() {
        return new Queue(queueSlack, false);
    }

    @Bean(name = "queueTelegram")
    Queue queueTelegram() {
        return new Queue(queueTelegram, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding bindingSlackQueue(Queue queueSlack, TopicExchange exchange) {
        return BindingBuilder.bind(queueSlack).to(exchange).with("queueSlack");
    }

    @Bean
    Binding bindingTelegramQueue(Queue queueTelegram, TopicExchange exchange) {
        return BindingBuilder.bind(queueTelegram).to(exchange).with("queueTelegram");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }


    @Bean
    public RabbitAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
}
