# 🚚 API - UrbanSwift (Back-End Logística)

Este projeto foi desenvolvido como **segundo módulo do curso de Back-End no SENAI**.  
O objetivo foi construir uma API REST para gerenciamento de operações logísticas, contemplando **usuários, tipos de usuários, veículos, endereços e entregas** — tudo protegido com **autenticação e autorização utilizando JWT**.

---

## 🛠 Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|-----------|--------|-----------|
| Java | **24** | Linguagem principal do projeto |
| Spring Boot | 3.2 | Framework para desenvolvimento da API |
| Spring Security | 6.3 | Controle de autenticação e autorização |
| JWT (JSON Web Token) | - | Segurança baseada em token |
| PostgreSQL | 15 | Banco de dados relacional |
| Swagger / OpenAPI | - | Documentação interativa da API |

---

## 🔐 Segurança com JWT

Toda requisição aos endpoints (exceto login) exige um **token JWT** válido.

### Fluxo de Autenticação
1. Enviar **e-mail** e **senha** para o endpoint de login.
2. Receber um **JWT** gerado automaticamente.
3. Adicionar o token no header das requisições:

```
Authorization: Bearer SEU_TOKEN_AQUI
```

Sem o token → **acesso negado** ✅

---

## 📦 Endpoints da API

### **Usuário**
| Método | Endpoint | Descrição |
|-------|----------|-----------|
| GET | `/api/Usuario/{id}` | Buscar usuário por ID |
| GET | `/api/Usuario` | Listar todos os usuários |
| POST | `/api/Usuario` | Criar um novo usuário |
| PUT | `/api/Usuario/{id}` | Editar um usuário |
| DELETE | `/api/Usuario/{id}` | Deletar usuário |

---

### **Tipo de Usuário**
| Método | Endpoint | Descrição |
|-------|----------|-----------|
| GET | `/api/UserType/{id}` | Buscar Tipo de Usuário por ID |
| GET | `/api/UserType` | Listar todos os Tipos de Usuário |
| POST | `/api/UserType` | Criar Tipo de Usuário |
| PUT | `/api/UserType/{id}` | Editar Tipo de Usuário |
| DELETE | `/api/UserType/{id}` | Deletar Tipo de Usuário |

---

### **Endereços**
| Método | Endpoint | Descrição |
|-------|----------|-----------|
| GET | `/api/Endereco/{id}` | Buscar endereço por ID |
| GET | `/api/Endereco` | Listar todos os endereços |
| POST | `/api/Endereco` | Criar endereço |
| PUT | `/api/Endereco/{id}` | Editar endereço |
| DELETE | `/api/Endereco/{id}` | Excluir endereço |

---

### **Veículos**
| Método | Endpoint | Descrição |
|-------|----------|-----------|
| GET | `/api/Veiculo/{id}` | Buscar veículo |
| GET | `/api/Veiculo` | Listar veículos |
| POST | `/api/Veiculo` | Cadastrar veículo |
| PUT | `/api/Veiculo/{id}` | Editar veículo |
| DELETE | `/api/Veiculo/{id}` | Deletar veículo |

---

### **Entregas**
| Método | Endpoint | Descrição |
|-------|----------|-----------|
| GET | `/api/Entrega/{id}` | Buscar entrega |
| GET | `/api/Entrega` | Listar entregas |
| POST | `/api/Entrega` | Registrar entrega |
| PUT | `/api/Entrega/{id}` | Editar entrega |
| DELETE | `/api/Entrega/{id}` | Deletar entrega |

---

## 📄 Documentação Swagger

Após rodar o projeto, acessar:

```
http://localhost:8080/swagger-ui/index.html
```
<img width="1264" height="856" alt="Captura de tela 2025-11-03 221551" src="https://github.com/user-attachments/assets/e0ab2b23-3899-4c1c-ae6c-1719bc3eb363" />
---

## 🚀 Como Executar

```bash
git clone https://github.com/raphaelz3/API-SENAI-BACKEND-LOGISTICA.git
cd API-SENAI-BACKEND-LOGISTICA
./mvnw spring-boot:run
```

Configurar o `application.properties` com credenciais do PostgreSQL antes de iniciar.

---

## 🏁 Resultado

Este projeto demonstra:

- Arquitetura em camadas (Model → Repository → Service → Controller)
- CRUD completo para múltiplas entidades
- **Segurança avançada com JWT**
- Banco PostgreSQL integrado
- Documentação automática com Swagger

---

## ✨ Autor

**Raphael Nascimento**  
Desenvolvedor Back-End • SENAI  
LinkedIn: https://www.linkedin.com/in/raphaelnascimento91





