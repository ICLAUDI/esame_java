# Registro Elettronico - Scuola Privata
  
# Linguaggio utilizzato 
  java spring boot

# Run dell'app
  cd demo
  mvn spring-boot:run

# Comandi per interagire con postman
1 User-
  esempio post: URL:http://localhost:8080/api/users/register + body:{
  "email": "luca23@example.com",
  "password": "password12345",
  "role": "USER"
}

  esempio get:http://localhost:8080/api/users/findByEmail?email=luca23@example.com

