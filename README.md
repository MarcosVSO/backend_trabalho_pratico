# 🍽️ Garçom Eletrônico

Sistema de gerenciamento de restaurante desenvolvido como trabalho prático da disciplina de Backend da Residência em T.I do TJGO.

## 📋 Sobre o Projeto

O **Garçom Eletrônico** é uma API REST desenvolvida em Spring Boot que permite gerenciar clientes, mesas, pedidos, cardápio e contas de um restaurante. O sistema oferece funcionalidades como sorteio de clientes, identificação de aniversariantes, consulta de pedidos pendentes, cálculo de tempo médio de entrega e muito mais.

## 🛠️ Tecnologias Utilizadas

### Backend Framework
- **Spring Boot 3.5.7**: Framework Java que simplifica o desenvolvimento de aplicações, fornecendo configuração automática, servidor embutido e uma estrutura robusta para APIs REST.

### Persistência de Dados
- **Spring Data JPA**: Facilita o acesso a dados usando o padrão Repository, eliminando a necessidade de escrever código boilerplate para operações CRUD.
- **Hibernate**: Framework ORM (Object-Relational Mapping) que mapeia objetos Java para tabelas do banco de dados automaticamente.
- **H2 Database**: Banco de dados em memória (in-memory) que não requer instalação separada, ideal para desenvolvimento e testes.

### Utilitários
- **Lombok**: Biblioteca que reduz código repetitivo através de anotações, gerando automaticamente getters, setters, construtores, etc.
- **Maven**: Gerenciador de dependências e ferramenta de build do projeto.

### Linguagem
- **Java 21**: Versão mais recente do Java com recursos modernos como records, pattern matching e melhorias de performance.

## 📁 Estrutura do Projeto

```
backend_trabalho_pratico/
├── src/
│   ├── main/
│   │   ├── java/com/br/garcom_eletronico/
│   │   │   ├── modules/
│   │   │   │   ├── categoria/          # Módulo de categorias
│   │   │   │   ├── cliente/           # Módulo de clientes
│   │   │   │   ├── conta/             # Módulo de contas
│   │   │   │   ├── garcom/            # Módulo de garçons
│   │   │   │   ├── item_cardapio/     # Módulo de itens do cardápio
│   │   │   │   ├── item_pedido/       # Módulo de itens de pedido
│   │   │   │   ├── mesa/              # Módulo de mesas
│   │   │   │   ├── pagamento/         # Módulo de pagamentos
│   │   │   │   └── pedido/            # Módulo de pedidos
│   │   │   └── GarcomEletronicoApplication.java
│   │   └── resources/
│   │       └── application.properties  # Configurações da aplicação
│   └── test/                          # Testes unitários
├── pom.xml                            # Configuração Maven
└── test_data.sql                      # Script SQL com dados de teste
```

### Padrão de Arquitetura

O projeto segue o padrão **MVC (Model-View-Controller)** adaptado para APIs REST:

- **Model (Entity)**: Classes que representam as entidades do banco de dados
- **Repository**: Interfaces que abstraem o acesso aos dados
- **Service**: Camada de lógica de negócio
- **Controller**: Endpoints REST que recebem requisições HTTP
- **DTO (Data Transfer Object)**: Objetos para transferência de dados entre camadas
- **Mapper**: Classes responsáveis por converter entre Entity e DTO

## 🚀 Como Rodar o Projeto

### Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java 21** ou superior
- **Maven 3.6+** ou superior
- **IDE** (IntelliJ IDEA, Eclipse, VS Code) - opcional, mas recomendado

### Passo a Passo

1. **Clone o repositório** (se aplicável) ou navegue até a pasta do projeto:
   ```bash
   cd backend_trabalho_pratico
   ```

2. **Compile o projeto** usando Maven:
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação**:
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a aplicação**:
    - A API estará disponível em: `http://localhost:8080`
    - Console H2 Database: `http://localhost:8080/h2-console`

### Configuração do Banco de Dados H2

O projeto está configurado para usar o H2 Database em memória. Para acessar o console:

1. Acesse: `http://localhost:8080/h2-console`
2. Use as seguintes credenciais:
    - **JDBC URL**: `jdbc:h2:mem:garcomdb`
    - **User Name**: `sa`
    - **Password**: (deixe em branco)

### Inserindo Dados de Teste

Para popular o banco de dados com dados de exemplo:

1. Acesse o console H2: `http://localhost:8080/h2-console`
2. Conecte-se ao banco usando as credenciais acima
3. Abra o arquivo `test_data.sql` e copie todo o conteúdo
4. Cole e execute no console H2