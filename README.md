# TrocaPuc

Este trabalho apresenta o desenvolvimento de um sistema digital voltado para a
troca de livros, eletrônicos e materiais universitários entre os alunos da PUC Minas,
dos campus de Belo Horizonte.

## Integrantes

* Felipe Luiz Parreiras Lima
* Gabriella Fernanda Silva Pinto
* Gabriel Pedrosa do Carmo Nonato
* Kayler de Freitas Moura
* Natália dos Reis Santos
* Pedro Henrique Silva Vargas

## Professor

* Aline Norberta de Brito
* Cleia Marcia Gomes Amaral
* Cristiano de Macêdo Neto

## Instruções de utilização

### **Instalação de Dependências**

### **1. Instalação do PostgreSQL**

#### **1.1. Baixe o PostgreSQL:**
Acesse o site oficial do [PostgreSQL](https://www.postgresql.org/download/) e baixe a versão adequada para seu sistema operacional.

#### **1.2. Instale o PostgreSQL:**
Siga os passos do instalador e anote o nome de usuário (default: postgres) e a senha que você definir durante a instalação.

#### **1.3. Inicie o PgAdmin:**
Após a instalação, abra o PgAdmin para gerenciar o banco de dados.

---

### **2. Configurar o Banco de Dados trocapuc**

#### **2.1. Crie um Banco de Dados:**
No PgAdmin, conecte-se ao servidor e crie um novo banco de dados chamado **trocapuc**.

#### **2.2. Verifique a Conexão:**
Certifique-se de que o banco de dados foi criado corretamente. Você pode rodar o seguinte comando SQL no PgAdmin: 
**CREATE DATABASE trocapuc;**
Se estiver tudo certo retornará: ERROR: database "trocapuc" already exists

---

### **3. Configurar application.properties no VSCode**
No VSCode, abra o arquivo application.properties dentro do diretório src/main/resources do projeto Spring Boot. Atualize o usuário, senha e nome do banco de dados conforme sua configuração:

**spring.datasource.username=seu_usuario_postgres**

**spring.datasource.password=sua_senha_postgres**

---

### **4. Rodar o Projeto Spring Boot**

#### **4.1. Abra a Classe TrocaPucApplication:**
No diretório src/main/java, localize a classe principal TrocaPucApplication.java.

#### **4.2. Execute o Projeto:**
Clique no botão de play (▶️) ou use o terminal para rodar o comando: **mvn spring-boot:run**

O Spring Boot iniciará o servidor na **porta padrão 8080**.

---

### **5. Acessar a Aplicação**
Abra o navegador e acesse: **http://localhost:8080**

## Histórico de versões

### Legenda:

**0.0.0 ->  (processo - tipos - versão)**

**Tipos: documentação (1) | Frontend (2) | Backend (3)**

---

### Processo 1 - Gerencimento de Usuário

| **Versão** | **Descrição das Alterações**                                           |
|------------|------------------------------------------------------------------------|
| **1.1.0**  | Diagrama do processo                                                   |
| **1.1.2**  | Modelagem da tabela de usuário                                         |
| **1.1.3**  | Modelagem de dados (tabelas e descrições)                              |
| **1.1.4**  | Correção do diagrama                                                   |
| **1.1.5**  | Correção da modelagem da tabela de usuário                             |
| **1.1.6**  | Correção da modelagem de dados (tabelas e descrições)                  |
| **1.2.0**  | Versão inicial do processo de gerenciamento de usuário.                |
| **1.2.1**  | Adicionada validação de e-mail e senha na criação de novos usuários.   |
| **1.2.2**  | Refatoração no JavaScript                                              |
| **1.2.3**  | Melhorias na interface de edição de perfil                             |
| **1.2.4**  | Versão inicial do processo de gerenciamento de usuário.                |
| **1.2.5**  | Adicionada funcionalidade de exclusão de conta.                        |
| **1.2.6**  | Refatoração no sistema de autenticação.                                |
| **1.2.7**  | Melhorias na interface de login.                                       |
| **1.2.8**  | Ajustes de segurança na criação de usuários.                           |
| **1.2.9**  | Otimização do carregamento dos dados de usuário.                       |
| **1.2.10** | Inclusão de logs de atividade do usuário.                              |
| **1.2.11** | Correção de bugs na edição de informações do perfil.                   |
| **1.3.0**  | Versão inicial do back-end para gerenciamento de usuário.              |
| **1.3.1**  | Adicionada criação e exclusão de usuários.                             |
| **1.3.2**  | Implementada validação de e-mail e senha no back-end.                  |
| **1.3.3**  | Refatoração das rotas de autenticação.                                 |
| **1.3.4**  | Melhorias no tratamento de erros e respostas.                          |
| **1.3.5**  | Otimização das consultas ao banco de dados.                            |

---

### Processo 2 - Gerenciamento de Item

| **Versão** | **Descrição das Alterações**                                           |
|------------|------------------------------------------------------------------------|
| **2.1.0**  | Criado o diagrama do processo de gerenciamento de itens.               |
| **2.1.2**  | Definida a modelagem da tabela de itens.                               |
| **2.1.3**  | Estruturada a modelagem de dados, com tabelas e suas descrições.       |
| **2.1.4**  | Ajustada a versão do diagrama de itens.                                |
| **2.1.5**  | Corrigida a modelagem da tabela de itens.                              |
| **2.1.6**  | Revisada a modelagem de dados (tabelas e descrições).                  |
| **2.2.0**  | Lançamento inicial do processo de gerenciamento de itens.              |
| **2.2.1**  | Implementada a validação de dados essenciais na criação de novos itens.|
| **2.2.2**  | Realizada a refatoração do código JavaScript responsável pelo processo.|
| **2.2.3**  | Aprimorada a interface de edição de itens.                             |
| **2.2.4**  | Introduzida a versão inicial do processo de gerenciamento de itens.    |
| **2.2.5**  | Implementada a funcionalidade para exclusão de itens.                  |
| **2.2.6**  | Refatorado o sistema de autenticação de itens.                         |
| **2.2.7**  | Melhorias na interface de login de gerenciamento de itens.             |
| **2.2.8**  | Otimizada a performance no carregamento dos dados de itens.            |
| **2.2.9** | Corrigidos erros na edição de informações dos itens.                    |
| **2.3.0**  | Criada a versão inicial do back-end para gerenciamento de itens.       |
| **2.3.1**  | Implementadas funcionalidades de criação e exclusão de itens.          |
| **2.3.2**  | Validação aprimorada de dados no back-end para itens.                  |
| **2.3.3**  | Refatoradas as rotas de autenticação de itens.                         |
| **2.3.4**  | Melhorias no tratamento de erros e respostas para gerenciamento de itens.|
| **2.3.5**  | Otimização das consultas ao banco de dados para itens.                 |

---

### Processo 3 - Busca e Solicitação de Item

| **Versão** | **Descrição das Alterações**                                           |
|------------|------------------------------------------------------------------------|
| **3.1.0**  | Elaborado o diagrama do processo de busca e solicitação de itens.      |
| **3.1.2**  | Definida a modelagem da tabela                                         |
| **3.1.3**  | Criada a estrutura de dados com tabelas e suas respectivas descrições. |
| **3.1.4**  | Atualização do diagrama de fluxo de solicitação de itens.              |
| **3.1.5**  | Corrigida a modelagem da tabela para itens solicitados.                |
| **3.1.6**  | Revisada a estrutura de dados e as descrições das tabelas de itens.    |
| **3.2.0**  | Lançada a versão inicial do processo de busca e solicitação de itens.  |
| **3.2.1**  | Implementada a validação de dados durante a solicitação de itens.      |
| **3.2.2**  | Refatoração do código JavaScript relacionado à busca de itens.         |
| **3.2.3**  | Melhorias na interface para facilitar a solicitação de itens.          |
| **3.2.4**  | Introduzida a versão inicial para a funcionalidade de busca de itens.  |
| **3.2.5**  | Adicionada a opção para enviar uma solicitação de item.                |
| **3.2.6**  | Aperfeiçoado o sistema de filtragem na busca de itens disponíveis.     |
| **3.2.7**  | Melhorias na interface de busca                                        |
| **3.2.8**  | Implementada a funcionalidade para confirmar solicitações de itens.    |
| **3.2.9**  | Melhorias na interface de busca                                        |
| **3.2.10** | Corrigidos erros nas solicitações de itens                             |
| **3.3.0**  | Implementada a versão inicial do back-end                              |
| **3.3.1**  | Refatorando Model e Controller                                         |
| **3.3.2**  | Realizada a validação de dados no back-end para solicitações de itens. |
| **3.3.3**  | Refatoradas as rotas de autenticação para solicitações de itens.       |
| **3.3.4**  | Melhorias no tratamento de erros e nas respostas durante a solicitação de itens. |
| **3.3.5**  | Otimizada a consulta aos dados de itens disponíveis para solicitação.  |

---

### Processo 4 - Proposta de Usuário

| **Versão** | **Descrição das Alterações**                                            |
|------------|-------------------------------------------------------------------------|
| **4.1.0**  | Criado o diagrama inicial do processo para a submissão de propostas de usuário.         |
| **4.1.1**  | Definida a modelagem da tabela de propostas de usuários.                                |
| **4.1.2**  | Estabelecida a estrutura de dados para as propostas e suas respectivas descrições.      |
| **4.1.3**  | Atualizado o diagrama de fluxo para o processo de submissão de propostas.               |
| **4.1.4**  | Corrigida a modelagem da tabela de propostas                                            |
| **4.1.5**  | Ajustada a estrutura de dados e os campos das tabelas relacionadas às propostas.        |
| **4.2.0**  | Lançada a versão inicial do processo de proposta de usuário.                            |
| **4.2.1**  | Implementada a validação de dados para o envio das propostas.                           |
| **4.2.2**  | Refatoração do código JavaScript para melhorar a submissão das propostas.               |
| **4.2.3**  | Melhorias no frontend                                                                   |
| **4.2.4**  | Introduzida a versão inicial para o gerenciamento de propostas de usuário.              |
| **4.2.5**  | Implementada a funcionalidade para aprovação de propostas.                              |
| **4.2.6** | Adicionada a funcionalidade de notificação para mudanças no status das propostas.        |
| **4.3.0**  | Versão inicial do back-end                                                              |
| **4.3.2**  | Implementada validação de dados para as propostas no back-end.                          |
| **4.3.3**  | Refatoração model e controller.                                                         |
| **1.3.6**  | Implementação dos Indicadores de desempenho.                                            |

