package br.com.egoncalves.jmsconsumer.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class EventMessageListener {

    @JmsListener(destination = "${jms-consumer.activemq.queue.events}", containerFactory="jmsFactory", selector = "company = 'A'")
    public void onMessageListenerCompanyA(String message) {
        System.out.println("<<< Received Message Company A <<< : " + message);
    }

    @JmsListener(destination = "${jms-consumer.activemq.queue.events}", containerFactory="jmsFactory", selector = "company = 'B'")
    public void onMessageListenerCompanyB(String message) {
        System.out.println("<<< Received Message Company B <<< : " + message);
    }

    @JmsListener(destination = "${jms-consumer.activemq.queue.events}", containerFactory="jmsFactory", selector = "company is null OR company not in ('A', 'B')")
    public void onMessageListenerCompanyOthers(String message) {
        System.out.println("<<< Received Message Others Companies  <<< : " + message);
    }


}
