package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        MessageService messageService = applicationContext.getBean("messageService", MessageService.class);
        MessageService additionalMessageService = applicationContext.getBean("messageService", MessageService.class);

        System.out.println(messageService.hashCode());
        System.out.println(additionalMessageService.hashCode());

        applicationContext.close();

        ClassPathXmlApplicationContext additionalApplicationContext = new ClassPathXmlApplicationContext("additionalApplicationContext.xml");

        MessageService secondMessageService = additionalApplicationContext.getBean("messageService", MessageService.class);
        MessageService secondAdditionalMessageService = additionalApplicationContext.getBean("additionalMessageService", MessageService.class);

        System.out.println(secondMessageService.getMessage());
        System.out.println(secondAdditionalMessageService.getMessage());

        additionalApplicationContext.close();
    }
}
