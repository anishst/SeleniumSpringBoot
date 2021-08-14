# Selenium with Spring Boot

[![example workflow](https://github.com/anishst/SeleniumSpringBoot/actions/workflows/main.yml/badge.svg)](https://github.com/anishst/SeleniumSpringBoot/actions)

Spring boot framework with Selenium automation testing tool to perform UI automation and test Microservices based application using different toolings and techniques.

## Features
- [x] Selenium Page Class with Spring Boot
    - leverages dependency injection and Bean webdriver usage
- [x] TestNG based tests
  - these follow spring boot injection methods and usage of Webdriver as Bean; currenly only Chrome is supported
  - location of main test: ```src/test/java/com/example/JavaSpringBoot/googletests/GoogleTest.java```
  - location of source code: ```src/main/java/com/example/JavaSpringBoot/page```
- [x] Integration with GitHub Actions
  - tests will run on push to master in GitHub servers
  
## Tests

Running using maven from command line
- to run using 
  - chrome```mvn clean test -Dbrowser=chrome```
  - edge ```mvn clean test -Dbrowser=edge```
  - ```mvn clean test``` will run using default browser in properties file