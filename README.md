#  Sistema de Gerenciamento de Chamados

## 📝 Descrição
Sistema de abertura e gestão de chamados técnicos desenvolvido em Spring Boot com testes robustos utilizando JUnit 5 e Mockito. O sistema oferece uma API RESTful para criação, consulta, atualização e exclusão de chamados, com autenticação JWT e cobertura completa de testes unitários.

##  Arquitetura do Projeto
O projeto segue uma arquitetura em camadas com separação clara de responsabilidades e foco em testabilidade:

Controller Layer
- Expõe endpoints REST para operações de chamados
- Implementa autenticação JWT
- Validações de entrada e tratamento de erros

Service Layer
- Contém a lógica de negócio
- Gerencia transações e regras de domínio
- Comunica com a camada de persistência

Repository Layer
- Abstração do acesso a dados com Spring Data JPA
- Operações CRUD e consultas customizadas

Test Layer
- Testes unitários com JUnit 5 e Mockito
- Testes de integração para endpoints REST
- Mocks para isolamento de dependências
 
