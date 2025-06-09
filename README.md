# Reeduc 🧠📚

**Reeduc** é uma aplicação web desenvolvida no 4º período do curso de **Sistemas de Informação**, como projeto da disciplina de **Programação Orientada a Objetos (POO)**. O sistema permite gerenciar estudantes e professores de forma simples, com foco em prática de conceitos de backend em Java com Spring e frontend com Thymeleaf.

## 🚀 Funcionalidades

- Autenticação de usuários  
- Cadastro, edição e listagem de estudantes  
- Cadastro, edição e listagem de professores  
- Interface web com páginas HTML estilizadas  
- Navegação com barra superior reutilizável (Thymeleaf fragments)  

## 🛠️ Tecnologias e Ferramentas

Java 17+  
Spring Boot  
Spring Security  
Thymeleaf  
HTML5 & CSS3  
PostgreSQL  
Flyway  
Maven  

## 📁 Estrutura Principal

```
src/
├── main/
│   ├── java/com/reeduc/ReeducSistema
│   │   ├── controller/         # Lógica de navegação e controle de fluxo
│   │   ├── model/              # Entidades: Student, Teacher, User, Post
│   │   ├── repository/         # Interfaces JPA para acesso ao banco
│   │   ├── service/            # Regras de negócio
│   │   └── config/             # Configurações de segurança
│   └── resources/
│       ├── templates/          # Páginas HTML com Thymeleaf
│       ├── static/css/         # Estilo da aplicação
│       └── db/migration/       # Script Flyway: criação das tabelas
```

## 🧪 Como Executar Localmente

### Pré-requisitos  
Java 17+  
PostgreSQL  
Maven  

### Passos

Clone o repositório:  
```bash
git clone https://github.com/dvlns/reeduc.git
cd reeduc
```

Configure o banco de dados PostgreSQL:  
Crie um banco com o nome desejado e atualize o arquivo `src/main/resources/application.properties` com suas credenciais.  

Exemplo:  
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/reeduc
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
```

Execute a aplicação:  
```bash
./mvnw spring-boot:run
```

Acesse no navegador:  
[http://localhost:8080](http://localhost:8080)

## 🧠 Aprendizados

Este projeto reforça conceitos como:  
- Modelagem de entidades orientadas a objetos  
- Segurança com Spring Security  
- Padrão MVC com Spring Boot  
- Integração com banco de dados PostgreSQL usando JPA  
- Separação de responsabilidades (Controller-Service-Repository)  

