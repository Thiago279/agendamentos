# 🩺 Agendamento Médico API

API REST desenvolvida com **Java** e **Spring Boot** para gerenciamento de pacientes, usuários e consultas médicas.

O projeto foi criado com o objetivo de aplicar boas práticas de desenvolvimento backend utilizando o ecossistema Spring, incluindo arquitetura em camadas, validação de dados, documentação da API e tratamento centralizado de exceções.

---

## 🚀 Tecnologias

- Java 21
- Spring Boot 3.4.4
- Spring Web
- Spring Data JPA
- Spring Validation
- PostgreSQL
- H2 Database
- Springdoc OpenAPI (Swagger)
- Maven

---

## 📂 Arquitetura

O projeto segue uma arquitetura em camadas para manter o código organizado e facilitar sua manutenção.

```
src/main/java
│
├── config
├── controller
├── controller/common
├── dto
├── entity
├── exceptions
├── repository
├── service
│   ├── impl
│   └── interfaces
└── validator
```

Cada camada possui uma responsabilidade específica:

| Camada | Responsabilidade |
|---------|-----------------|
| Controller | Recebe as requisições HTTP |
| Service | Implementa as regras de negócio |
| Repository | Comunicação com o banco de dados |
| Entity | Representação das tabelas |
| DTO | Entrada e saída de dados da API |
| Validator | Validações personalizadas |
| Exception | Tratamento de erros da aplicação |

---

# Funcionalidades

Atualmente a API possui funcionalidades para:

- Cadastro de pacientes
- Atualização de pacientes
- Exclusão de pacientes
- Consulta de pacientes
- Cadastro de usuários
- Gerenciamento de agendamentos
- Validação de dados
- Tratamento padronizado de exceções
- Documentação automática com Swagger

---

# Tecnologias utilizadas

| Tecnologia | Finalidade |
|------------|------------|
| Spring Web | Construção da API REST |
| Spring Data JPA | Persistência de dados |
| PostgreSQL | Banco principal |
| H2 | Banco em memória para desenvolvimento |
| Spring Validation | Validação dos dados |
| OpenAPI | Documentação da API |

---

# Como executar

## Pré-requisitos

- Java 21+
- Maven 3.9+
- PostgreSQL (opcional)

Clone o projeto:

```bash
git clone https://github.com/seu-usuario/agendamento-medico.git
```

Entre na pasta:

```bash
cd backend-agendamento
```

Execute:

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

---

# Documentação da API

Após iniciar a aplicação, a documentação poderá ser acessada em:

```
http://localhost:8080/swagger-ui/index.html
```

---

# Estrutura da API

A aplicação disponibiliza endpoints relacionados a:

- Pacientes
- Usuários
- Agendamentos

Todos seguem o padrão REST.

---

# Tratamento de exceções

A API possui tratamento global de erros utilizando `@RestControllerAdvice`, retornando respostas padronizadas para situações como:

- Registro não encontrado
- Registro duplicado
- Dados inválidos
- Operações não permitidas

---

# Validação

As entradas da API são validadas utilizando Bean Validation (`Jakarta Validation`), garantindo maior consistência dos dados antes da persistência.

---
## Banco de dados com Docker

O banco PostgreSQL utilizado durante o desenvolvimento foi executado em um container Docker criado manualmente via linha de comando.

Atualmente o projeto utiliza um container PostgreSQL criado manualmente via Docker CLI, conforme realizado durante seu desenvolvimento. Em uma evolução futura, a configuração poderá ser migrada para Docker Compose para facilitar a configuração do ambiente.

Exemplo de criação do container:

```bash
docker run -d \
  --name agendamento-postgres \
  -e POSTGRES_DB=agendamento_medico \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  postgres:15
```

Para iniciar um container já criado:

```bash
docker start agendamento-postgres
```

Caso prefira, também é possível utilizar uma instância local do PostgreSQL ajustando as configurações em `application.properties`.

# Próximas melhorias

- Autenticação JWT
- Controle de permissões
- Testes unitários
- Testes de integração
- CI/CD
- Cobertura de testes
- Deploy em nuvem

---

# Aprendizados

Durante o desenvolvimento deste projeto foram praticados conceitos como:

- Arquitetura em camadas
- REST APIs
- DTO Pattern
- Repository Pattern
- Tratamento global de exceções
- Boas práticas com Spring Boot
- Persistência com JPA/Hibernate
- Validação de dados
- Organização de projetos Maven

---

## 👨‍💻 Autor

**Thiago Toma**

Backend Java Developer

- LinkedIn: https://www.linkedin.com/in/thiago-t-843819346
- GitHub: https://github.com/Thiago279