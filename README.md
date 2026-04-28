# 🎓 VITAL-CONSIOUS — API de Gestão Universitária

API REST desenvolvida como projeto universitário para gerenciamento de alunos e professores de uma instituição de ensino.

## 📋 Sobre o projeto

Sistema backend construído com Spring Boot e PostgreSQL, seguindo arquitetura em camadas (Controller → Service → Repository → Entity). O projeto inclui documentação de diagramas e PDS (Plano de Desenvolvimento de Software).

## ✨ Funcionalidades

**Alunos (`/aluno`)**
- `GET /aluno` — lista todos os alunos
- `GET /aluno/{id}` — busca aluno por ID
- `GET /aluno/nome/{nome}` — busca aluno por nome
- `POST /aluno` — cadastra novo aluno
- `PUT /aluno` — atualiza dados de um aluno
- `DELETE /aluno/{id}` — remove aluno
- `DELETE /aluno/inactive/{id}` — desativa aluno (soft delete)

## 🛠️ Tecnologias utilizadas

- Java 17
- Spring Boot 3.2.9
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## ⚙️ Como rodar localmente

### Pré-requisitos
- Java 17+
- PostgreSQL rodando localmente
- Maven

### Configuração do banco

Crie um banco de dados no PostgreSQL:
```sql
CREATE DATABASE esn320245;
```

### Configuração da aplicação

No arquivo `src/main/resources/application.properties`, ajuste as credenciais se necessário:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/esn320245
spring.datasource.username=postgres
spring.datasource.password=postgres
```

### Rodando o projeto

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`

## 📁 Estrutura do projeto

```
src/
└── main/java/com/example/universidadeESN3/
    ├── controller/     # Endpoints REST
    ├── entity/         # Entidades JPA (Aluno, Professor)
    ├── repository/     # Interfaces de acesso ao banco
    └── service/        # Regras de negócio
```

## 📄 Documentação

O repositório inclui:
- `Diagramas/` — diagramas do sistema
- `PDS/` — Plano de Desenvolvimento de Software

## 👨‍💻 Autor

Desenvolvido por **Miqueias Henrique** — Engenharia de Software, UNIFAN
