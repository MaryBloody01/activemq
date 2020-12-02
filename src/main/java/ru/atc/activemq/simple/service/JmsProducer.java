package ru.atc.activemq.simple.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class JmsProducer {

    private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(JmsProducer.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("{active-mq.topic}")
    private String topic;

    public void sendMessage(String message) {
        try{
            LOGGER.info("Attempting Send message to Topic: "+ topic);
            jmsTemplate.convertAndSend(topic, message);
        } catch(Exception e){
           // LOGGER.("Recieved Exception during send Message: ", e);
        }
    }
}
