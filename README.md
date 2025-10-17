# 📌 Sistema de Gerenciamento de Chamados

## 📝 Descrição

Este projeto implementa um sistema completo de abertura e gestão de chamados técnicos desenvolvido em **Spring Boot** com testes robustos utilizando **JUnit 5** e **Mockito**. O sistema oferece uma **API RESTful** para criação, consulta, atualização e exclusão de chamados, com **autenticação JWT** e **cobertura completa de testes unitários**.

## 🏗️ Arquitetura do Projeto

O projeto segue uma arquitetura em camadas com separação clara de responsabilidades e foco em testabilidade:

### Controller Layer

- Expõe endpoints REST para operações de chamados
- Implementa autenticação JWT
- Validações de entrada e tratamento de erros

### Service Layer

- Contém a lógica de negócio
- Gerencia transações e regras de domínio
- Comunica com a camada de persistência

### Repository Layer

- Abstração do acesso a dados com Spring Data JPA
- Operações CRUD e consultas customizadas

### Test Layer

- Testes unitários com JUnit 5 e Mockito
- Testes de integração para endpoints REST
- Mocks para isolamento de dependências

## 🛠️ Tecnologias Utilizadas

### 🔹 Backend

- **Java 17**
- **Spring Boot 3.x** (Web, Data JPA, Security, Test)
- **JUnit 5** – Framework de testes
- **Mockito** – Mocking para testes unitários
- **JWT** – Autenticação stateless
- **H2 Database** – Banco em memória para desenvolvimento
- **Maven** – Gerenciamento de dependências

### 🔹 Testes

- **JUnit 5** – Estrutura principal de testes
- **Mockito** – Criação de mocks e verificação de comportamentos
- **Spring Test** – Suporte para testes de integração
- **MockMvc** – Testes de endpoints REST
- **Hamcrest** – Assertions expressivas

### 🔹 Segurança

- **Spring Security** – Autenticação e autorização
- **JWT Tokens** – Tokens de acesso stateless
- **BCrypt** – Criptografia de senhas

## 🚀 Como Executar o Projeto

### 🔹 Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- IDE (Eclipse, IntelliJ ou VS Code)

### 🔹 Passo 1: Clonar o Repositório

```
git clone https://github.com/seu-usuario/chamadosjdk.git
cd chamadosjdk
```

🔹 Passo 2: Compilar e Executar

# Compilar o projeto

```
mvn clean compile
```

# Executar a aplicação

```
mvn spring-boot:run
A aplicação estará disponível em: http://localhost:8081
```

🔹 Passo 3: Executar os Testes

# Executar todos os testes

```
mvn test
```

# Executar testes específicos

```
mvn test -Dtest=ChamadoServiceTest
mvn test -Dtest=ChamadoControllerTest
```

# Executar um teste específico por método

```
mvn test -Dtest=ChamadoServiceTest#deveAbrirChamadoComSucesso
```

🔹 Passo 4: Testar a API

🔐 Autenticação (Obter Token JWT)

```
curl -X POST http://localhost:8081/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"password"}'
```

➕ Criar um Chamado

```
curl -X POST http://localhost:8081/api/chamados \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer SEU_TOKEN_JWT" \
  -d '{
    "titulo": "Problema no sistema",
    "descricao": "Não consigo acessar o sistema principal",
    "solicitante": "João Silva"
  }'
```

📋 Listar Todos os Chamados

```
curl -X GET http://localhost:8081/api/chamados \
  -H "Authorization: Bearer SEU_TOKEN_JWT"
```

🔍 Buscar Chamado por ID

```
curl -X GET http://localhost:8081/api/chamados/1 \
  -H "Authorization: Bearer SEU_TOKEN_JWT"
```

🔄 Atualizar Status do Chamado

```
curl -X PUT "http://localhost:8081/api/chamados/1/status?status=EM_ANDAMENTO" \
  -H "Authorization: Bearer SEU_TOKEN_JWT"
```

🗑️ Deletar Chamado

```
curl -X DELETE http://localhost:8081/api/chamados/1 \
  -H "Authorization: Bearer SEU_TOKEN_JWT"
Substitua SEU_TOKEN_JWT pelo token retornado no passo de autenticação.
```

🧪 Estrutura de Testes
Testes de Service (ChamadoServiceTest)
Testes unitários puros com Mockito
Isolamento completo do banco de dados
Verificação de comportamentos com verify()
Testes de Controller (ChamadoControllerTest)
Testes de endpoints REST com MockMvc
Validação de status HTTP e respostas JSON
Configuração manual com standaloneSetup (sem contexto Spring completo)
Casos de Teste Implementados
Criação
deveAbrirChamadoComSucesso
Cria chamado com ID 10
Listagem
deveListarTodosChamados
Retorna lista de chamados
Busca
deveBuscarChamadoPorIdExistente
Busca por ID válido
Erro 404
deveRetornar404ParaChamadoNaoEncontrado
ID inexistente
Atualização
deveAtualizarStatusChamado
Altera status do chamado
Exclusão
deveDeletarChamadoExistente
Remove chamado com sucesso

📊 Resultados dos Testes
✅ Service Layer: 100% dos métodos principais
✅ Controller Layer: Todos endpoints REST cobertos
✅ Business Logic: Regras de negócio validadas
✅ Error Handling: Cenários de erro cobertos

Padrões de Teste
Arrange-Act-Assert (AAA)
Behavior Verification
Exception Testing
Independent Tests

🔧 Configurações
Banco de Dados H2
Console: http://localhost:8081/h2-console
JDBC URL: jdbc:h2:mem:testdb
Usuário: sa
Senha: (vazia)
JWT Configuration
Secret: mySecretKey12345678901234567890123456789012
Expiration: 86400000 (24 horas)

🎯 Funcionalidades Principais
✅ CRUD completo de chamados
✅ Autenticação JWT
✅ Testes unitários com JUnit 5 e Mockito
✅ Validações de entrada
✅ Tratamento de erros
✅ Documentação de API via exemplos
✅ Configuração para desenvolvimento e testes

📁 Estrutura do Projeto

```
src/
├── main/java/com/api/chamadosjdk/
│   ├── controller/    # Endpoints REST
│   ├── service/       # Lógica de negócio
│   ├── repository/    # Acesso a dados
│   ├── model/         # Entidades JPA
│   └── config/        # Configurações Spring (incluindo JWT)
└── test/java/com/api/chamadosjdk/
    ├── service/       # Testes unitários (Mockito)
    └── controller/    # Testes de controller (MockMvc + JWT)
```
