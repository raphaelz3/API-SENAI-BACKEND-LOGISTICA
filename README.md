# 🚚 API de Logística - SENAI (com Segurança JWT)

Projeto desenvolvido durante o curso de Backend no SENAI, simulando operações de logística e controle de entregas.  
Nesta versão, foi implementada **autenticação e autorização com JWT**, garantindo acesso seguro aos endpoints.

---

## 🛠 Tecnologias Utilizadas
- Java 24
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Spring Security + JWT
- Swagger (OpenAPI)
- Maven

---

## 🔐 Segurança (JWT)
A API utiliza **Token JWT** para autenticação.  
Fluxo básico:
1. Usuário realiza login  
2. API retorna o token de autenticação  
3. O token deve ser enviado no header `Authorization: Bearer <token>` em cada requisição protegida  

Endpoints de login/registro ficam públicos. CRUDs são protegidos por roles.

---

## 📦 Endpoints (Principais Grupos)
| Recurso | Descrição |
|--------|-----------|
| `/api/Usuario` | Usuários do sistema |
| `/api/UserType` | Tipos de usuário (roles/permissões) |
| `/api/Entrega` | Registro de entregas |
| `/api/Veiculo` | Gestão de veículos |
| `/api/Endereco` | Endereços associados |


