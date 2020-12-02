package ru.atc.activemq.simple.service;

import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.logging.Logger;

public class JmsConsumer implements MessageListener {
    private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(JmsConsumer.class);

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            String message = objectMessage.getObject();
            //do additional processing
            log.info("Received Message: "+ employee.toString());
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }
    }
}
