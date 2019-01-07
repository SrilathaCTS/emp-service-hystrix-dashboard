# emp-service-hystrix-dashboard
spring boot application with hystrix dashboard

This spring boot services helps in understanding how to use the Circuit Breaker Hystrix plugin and helps in monitoring hystrix fallback in a hystrix dashboard.
Prerequisite : This application needs the employee service microservice to test whether the circuit is open or closed.
employee-service : https://github.com/SrilathaCTS/emp-micro-service.git

This application runs on : 8092 

start employee service and hit this url http://localhost:8092/rest/emp/reliable
will receive response as  "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)"

stop the employee service server and hit the same url will receive "Cloud Native Java (O'Reilly)". Even server is down it calls fallback method.