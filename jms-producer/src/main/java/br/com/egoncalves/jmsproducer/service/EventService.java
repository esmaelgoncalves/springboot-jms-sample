package br.com.egoncalves.jmsproducer.service;

import br.com.egoncalves.jmsproducer.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;

@Service
public class EventService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms-producer.activemq.queue.events}")
    private String eventQueue;

    public void sendEvent(Event event){
        System.out.println(">>> Enviando mensagem >>> " + event);
        jmsTemplate.convertAndSend(eventQueue, event, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setBooleanProperty("event", true);
                message.setStringProperty("company", event.getCompany());
                return message;
            }
        });
    }

}
