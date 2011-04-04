package com.dx9.example;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class MainNoSpring {

    public static void main(String[] args) {

        KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kBuilder.add(ResourceFactory.newFileResource("src/main/resources/rules-example.drl"), ResourceType.DRL);

        KnowledgeBaseConfiguration kBaseConfiguration = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();

        KnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase(kBaseConfiguration);
        kBase.addKnowledgePackages(kBuilder.getKnowledgePackages());

        StatefulKnowledgeSession kSession = kBase.newStatefulKnowledgeSession();

        insertFacts(kSession);
        
        kSession.dispose();
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
