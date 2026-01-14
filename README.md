# 🛒 API GraphQL de Productos (Spring Boot + GraphQL + H2)

Aplicación web construida con **Spring Boot** y **Spring for GraphQL** para consultar y modificar información de **productos** de forma **declarativa** usando **GraphQL**.  
La persistencia se realiza con **Spring Data JPA** y una base de datos **H2** (en memoria) y se puede visualizar en **H2 Console**.  
Las pruebas se pueden hacer desde **GraphiQL** o **Postman**.

---

## ✅ Objetivo de la actividad
- Integrar GraphQL en un framework web (Spring Boot).
- Configurar dependencias necesarias.
- Definir un **schema GraphQL** y exponer **Queries** y **Mutations**.
- Probar llamadas GraphQL desde **Postman**.

---

## 🧰 Tecnologías utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Spring for GraphQL**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database**
- **Maven Wrapper** (`mvnw`)

---

## 📁 Estructura del proyecto
src/main/java/co/edu/poli/examplegraphql
├── ExamplegraphqlApplication.java
├── controllers/ProductoGraphqlController.java
├── model/Producto.java
├── repositories/ProductoRepository.java
└── services/ProductoService.java

src/main/resources
├── application.properties
└── graphql/schema.graphqls


---

## ⚙️ Requisitos
- Tener instalado **Java 17**
- No necesitas Maven instalado: el proyecto usa **Maven Wrapper (`mvnw`)**

---


## 🌐 Endpoints / URLs útiles
GraphQL endpoint

http://localhost:8080/graphql

GraphiQL (interfaz web para pruebas)

http://localhost:8080/graphiql

H2 Console (ver la BD)

http://localhost:8080/h2-console

Credenciales recomendadas para H2 Console (según application.properties):

JDBC URL: jdbc:h2:mem:exampledb

User: sa

Password: (vacío)

## 🧾 Schema GraphQL (schema.graphqls)

Ubicación:
src/main/resources/graphql/schema.graphqls

type Query {
  productos: [Producto!]!
  productoPorId(id: ID!): Producto
}

type Mutation {
  crearProducto(input: ProductoInput!): Producto!
  actualizarProducto(id: ID!, input: ProductoInput!): Producto
  eliminarProducto(id: ID!): Boolean!
}

type Producto {
  id: ID!
  nombre: String!
  precio: Float!
  stock: Int!
}

input ProductoInput {
  nombre: String!
  precio: Float!
  stock: Int!
}

## ✅ Probar en GraphiQL (rápido)

Entra a: http://localhost:8080/graphiql

1) Listar productos
query {
  productos {
    id
    nombre
    precio
    stock
  }
}

2) Buscar producto por ID
query {
  productoPorId(id: 1) {
    id
    nombre
    precio
    stock
  }
}

3) Crear producto
mutation {
  crearProducto(input: { nombre: "Teclado Mecánico", precio: 199900, stock: 7 }) {
    id
    nombre
    precio
    stock
  }
}

4) Actualizar producto
mutation {
  actualizarProducto(id: 1, input: { nombre: "Teclado PRO", precio: 249900, stock: 10 }) {
    id
    nombre
    precio
    stock
  }
}

5) Eliminar producto
mutation {
  eliminarProducto(id: 1)
}

## 🧪 Probar en Postman (como en clase)
Configuración en Postman

Método: POST

URL: http://localhost:8080/graphql

Body: GraphQL

Pegar el query/mutation en la caja Query y enviar

Query: Listar productos
query {
  productos {
    id
    nombre
    precio
    stock
  }
}

Query: Buscar por ID
query {
  productoPorId(id: 1) {
    id
    nombre
    precio
    stock
  }
}

Mutation: Crear
mutation {
  crearProducto(input: { nombre: "Mouse Logitech", precio: 89900, stock: 12 }) {
    id
    nombre
    precio
    stock
  }
}

Mutation: Actualizar
mutation {
  actualizarProducto(id: 1, input: { nombre: "Mouse PRO", precio: 99900, stock: 30 }) {
    id
    nombre
    precio
    stock
  }
}

Mutation: Eliminar
mutation {
  eliminarProducto(id: 1)
}

## 🗄️ Insertar datos desde la base de datos (H2 Console)

Entra a: http://localhost:8080/h2-console y ejecuta:

Ver datos
SELECT * FROM PRODUCTOS;

Insertar registros
INSERT INTO PRODUCTOS (NOMBRE, PRECIO, STOCK) VALUES ('Mouse Logitech', 89900, 12);
INSERT INTO PRODUCTOS (NOMBRE, PRECIO, STOCK) VALUES ('Teclado Mecánico', 199900, 7);
INSERT INTO PRODUCTOS (NOMBRE, PRECIO, STOCK) VALUES ('Monitor 24', 649900, 5);

## ⚠️ Notas importantes (para evitar errores)

GraphQL se consume normalmente con POST hacia /graphql.

Si tu BD es mem, los datos se pierden al reiniciar la app.

Si te aparece productos: [] significa que la tabla está vacía o estás conectado a otra BD.

## 📌 Autor / Entrega

Proyecto académico: Implementación GraphQL en Spring Boot
Autor: Jairo Espejo 

---

## ▶️ Cómo ejecutar el proyecto

### Windows (PowerShell)
Ubícate en la carpeta donde está el `pom.xml` y ejecuta:

```bash
.\mvnw spring-boot:run

