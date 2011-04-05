Java Examples
=============

A variety of java projects:

* smartgwt-example: How to create a CRUD application using SmartGwt.

In order to execute it, run:

	mvn clean install
	mvn gwt:run

* spring-example: How to create a basic Drools application using Spring.

In order to execute the spring version, run:

	mvn clean compile
	mvn exec:java -Dexec.mainClass="com.dx9.example.MainSpring"

In order to execute the plain java version, run:

	mvn clean compile
	mvn exec:java -Dexec.mainClass="com.dx9.example.MainNoSpring"