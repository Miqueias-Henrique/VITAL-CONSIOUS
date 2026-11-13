# VITAL-CONSIOUS

Repositório acadêmico da disciplina de Engenharia de Software (UNIFAN, turma ESNB-3), reunindo a documentação do projeto (diagramas e Plano de Desenvolvimento de Software) e a API REST em Spring Boot para cadastro e gestão de alunos e professores.

## Stack

- Java 17
- Spring Boot 3.2.9
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven Wrapper

## Estrutura

```
.
├── Diagramas/                  # Diagramas do sistema (PDF)
├── PDS/                        # Plano de Desenvolvimento de Software (PDF)
└── Vital Consious (Breno)/     # Aplicação Spring Boot (universidadeESN3)
    └── src/main/java/com/example/universidadeESN3/
        ├── controller/         # Endpoints REST (/aluno e /professor)
        ├── entity/             # Entidades JPA (Aluno, Professor, Genero)
        ├── repository/         # Repositórios Spring Data JPA
        └── service/            # Regras de negócio e interfaces de serviço
```

## Endpoints

### Alunos (`/aluno`)

| Método | Rota | Descrição |
| --- | --- | --- |
| `GET` | `/aluno` | Lista todos os alunos |
| `GET` | `/aluno/{id}` | Busca aluno por ID |
| `GET` | `/aluno/nome/{nome}` | Busca alunos cujo nome inicia com o termo informado (case-insensitive) |
| `POST` | `/aluno` | Cadastra um novo aluno (`201 Created`) |
| `PUT` | `/aluno` | Atualiza os dados de um aluno existente |
| `DELETE` | `/aluno/{id}` | Remove um aluno por ID (`204 No Content`) |
| `DELETE` | `/aluno/inactive/{id}` | Desativa um aluno via soft delete (`active = false`) |

### Professores (`/professor`)

| Método | Rota | Descrição |
| --- | --- | --- |
| `GET` | `/professor` | Lista todos os professores |
| `GET` | `/professor/{id}` | Busca professor por ID |
| `GET` | `/professor/nome/{nome}` | Busca professores cujo nome inicia com o termo informado (case-insensitive) |
| `POST` | `/professor` | Cadastra um novo professor (`201 Created`) |
| `PUT` | `/professor` | Atualiza os dados de um professor existente |
| `DELETE` | `/professor/{id}` | Remove um professor por ID (`204 No Content`) |
| `DELETE` | `/professor/inactive/{id}` | Desativa um professor via soft delete (`active = false`) |

## Como executar

Pré-requisitos: Java 17+ e PostgreSQL em execução.

1. Crie o banco no PostgreSQL:

```sql
CREATE DATABASE esn320245;
```

2. Opcionalmente, defina as variáveis de ambiente (valores padrão em `Vital Consious (Breno)/src/main/resources/application.properties`):

```bash
export DB_URL=jdbc:postgresql://localhost:5432/esn320245
export DB_USERNAME=postgres
export DB_PASSWORD=postgres
```

3. Acesse o diretório da aplicação e execute pelo Maven Wrapper:

```bash
cd "Vital Consious (Breno)"
./mvnw spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.
