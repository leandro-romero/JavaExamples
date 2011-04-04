package com.dx9.example;

import org.drools.runtime.StatefulKnowledgeSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"/drools-spring.xml"});
        StatefulKnowledgeSession session = (StatefulKnowledgeSession)context.getBean("kSession");

        insertFacts(session);
        session.dispose();
    }

    private static void insertFacts(StatefulKnowledgeSession kSession) {

        Car expensiveCar = new Car("Expensive", "red", 100000);
        Car expensivePinkCar = new Car("ExpensivePink", "pink", 80000);
        Car commonCar = new Car("Common", "black", 30000);

        kSession.insert(expensiveCar);
        kSession.fireAllRules();

        kSession.insert(expensivePinkCar);
        kSession.fireAllRules();

        kSession.insert(commonCar);
        kSession.fireAllRules();
    }

}
