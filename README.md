# comments_microservices
Demo spring boot project using microservices,JWT,eureka,cloud gateway and kafka

Servers Available:
1)User Service- Used to register a user to the system.
2)Comment Service- Used to add/update/get comments. Added at/modified at details are provided.
3)Cloud gateway- Used as a gateway to access user/comments service. Fallback handling is also done for the services.
4)Eureka Discory Server: It is used for service registry. User, cloud gateway and comment services are registered here and accessed via their registered names. 

DB used:
Postgres

Authentication:
Authentication is done using JWT generated using HS512.Password is encrypted using BCrypt.

Kafka Usage:
User service adds messages to topic users with username and encrypted password.
Comment service consumes the users details to verify logged in user trying to generate a JWT.

