# Resumen de Implementación - Backend Evaluación 2

## Requisitos Completados

### 1. Servicio de Usuarios - CRUD Completo

**Archivos creados:**
- Service: [UsuarioService.java](src/main/java/com/duoc/trabajo22/service/UsuarioService.java)
- Controller: [UsuarioController.java](src/main/java/com/duoc/trabajo22/controller/UsuarioController.java)
- Repository: [UsuarioRepository.java](src/main/java/com/duoc/trabajo22/repository/UsuarioRepository.java)

**Endpoints disponibles:**
- `GET /api/usuarios` - Obtener todos los usuarios
- `GET /api/usuarios/{id}` - Obtener usuario por ID
- `POST /api/usuarios` - Crear nuevo usuario
- `PUT /api/usuarios/{id}` - Actualizar usuario
- `DELETE /api/usuarios/{id}` - Eliminar usuario
- `PATCH /api/usuarios/{id}/inactivar` - Inactivar usuario

**Campos del modelo:**
- id (auto-generado)
- nombre
- apellidos
- email
- password (encriptada en modelo, sin encriptar en implementación básica)
- tipoUsuario (rol: cliente, vendedor, super-admin)
- activo (estado: 1 activo, 0 inactivo)
- fechaRegistro (generado por sistema)

**Validaciones:**
- Jakarta Validation (@NotNull, @Size, @Email)
- Validación en controlador con @Valid

---

### 2. Servicio de Inventario/Productos - CRUD Completo

**Archivos creados:**
- Service: [MangaService.java](src/main/java/com/duoc/trabajo22/service/MangaService.java)
- Controller: [MangaController.java](src/main/java/com/duoc/trabajo22/controller/MangaController.java)
- Repository: [MangaRepository.java](src/main/java/com/duoc/trabajo22/repository/MangaRepository.java)

**Endpoints disponibles:**
- `GET /api/productos` - Obtener todos los productos
- `GET /api/productos/{id}` - Obtener producto por ID
- `POST /api/productos` - Crear nuevo producto
- `PUT /api/productos/{id}` - Actualizar producto
- `DELETE /api/productos/{id}` - Eliminar producto
- `PATCH /api/productos/{id}/inactivar` - Inactivar producto
- `PATCH /api/productos/{id}/stock?cantidad={cantidad}` - Actualizar stock

**Campos del modelo:**
- id (auto-generado)
- codigo
- titulo (nombre del producto)
- descripcion
- precio
- stock (cantidad disponible)
- categorias (relación ManyToMany)
- imagenPortada (URL de imagen)
- activo (estado: 1 activo, 0 inactivo)
- fechaCreacion (generado por sistema)
- fechaActualizacion (actualizado por sistema)

**Control de stock:**
- Método `actualizarStock(id, cantidad)` permite incrementar/decrementar stock
- Validación para evitar stock negativo

---

### 3. Autenticación Simple

**Archivos creados:**
- Controller: [AuthController.java](src/main/java/com/duoc/trabajo22/controller/AuthController.java)
- DTOs:
  - [LoginRequest.java](src/main/java/com/duoc/trabajo22/dto/LoginRequest.java)
  - [LoginResponse.java](src/main/java/com/duoc/trabajo22/dto/LoginResponse.java)

**Endpoints disponibles:**
- `POST /api/auth/login` - Login de usuario
  - Body: `{ "email": "string", "password": "string" }`
  - Respuesta: Información del usuario autenticado
- `GET /api/auth/validar-admin/{id}` - Validar si usuario es administrador

**Validaciones:**
- Verifica que el usuario exista por email
- Valida contraseña
- Verifica que el usuario esté activo
- Retorna información del usuario (sin JWT en esta etapa)

**Validación de rol:**
- El endpoint `validar-admin` retorna `true` si el usuario es super-admin o vendedor

---

### 4. Base de Datos y Poblamiento Inicial

**Script SQL creado:** [data.sql](src/main/resources/data.sql)

**Datos incluidos:**

**Usuario administrador por defecto:**
```
Email: admin@mangastore.com
Password: admin123
Tipo: super-admin
```

**Categorías (7):**
1. Shonen
2. Seinen
3. Shojo
4. Kodomo
5. Isekai
6. Acción
7. Romance

**Editoriales (3):**
- Shueisha (Japón)
- Kodansha (Japón)
- Panini Comics (Chile)

**Productos (15 mangas):**
1. One Piece Vol. 1 - $9,990
2. Naruto Vol. 1 - $8,990
3. Attack on Titan Vol. 1 - $10,990
4. Death Note Vol. 1 - $9,990
5. My Hero Academia Vol. 1 - $8,990
6. Demon Slayer Vol. 1 - $9,990
7. Tokyo Ghoul Vol. 1 - $10,990
8. Fullmetal Alchemist Vol. 1 - $9,990
9. Jujutsu Kaisen Vol. 1 - $8,990
10. Chainsaw Man Vol. 1 - $10,990
11. Spy x Family Vol. 1 - $9,990
12. Bleach Vol. 1 - $8,990
13. One Punch Man Vol. 1 - $9,990
14. Dragon Ball Vol. 1 - $7,990
15. Hunter x Hunter Vol. 1 - $9,990

**Cómo poblar la base de datos:**
1. Abre phpMyAdmin o tu cliente MySQL
2. Selecciona la base de datos `mangaStore`
3. Ejecuta el script completo de [src/main/resources/data.sql](src/main/resources/data.sql)

---

### 5. Tests con Mockito

**Archivos creados:**
- [MangaServiceTest.java](src/test/java/com/duoc/trabajo22/service/MangaServiceTest.java) - 4 tests
- [UsuarioServiceTest.java](src/test/java/com/duoc/trabajo22/service/UsuarioServiceTest.java) - 3 tests

**Tests de MangaService (4 tests):**
1. `testFindAll()` - Verifica que se obtienen todos los mangas
2. `testSave()` - Verifica que se guarda un manga correctamente
3. `testActualizarStock_Success()` - Verifica actualización de stock exitosa
4. `testActualizarStock_StockInsuficiente()` - Verifica validación de stock negativo

**Tests de UsuarioService (3 tests):**
1. `testSave()` - Verifica que se guarda un usuario correctamente
2. `testInactivar()` - Verifica que se inactiva un usuario
3. `testFindByEmail()` - Verifica búsqueda por email

**Ejecución de tests:**
```bash
mvn test
```

**Resultado:** ✅ Todos los tests pasaron exitosamente

---

### 6. Documentación con Swagger

**Configuración:**
- Dependencia: `springdoc-openapi-starter-webmvc-ui` v2.5.0
- Anotaciones en controllers: `@Tag`, `@Operation`

**Acceso a Swagger UI:**
```
http://localhost:8080/swagger-ui.html
```

**Tags documentados:**
- Usuarios - Gestión de usuarios
- Productos - Gestión de productos (mangas)
- Autenticación - Endpoints de autenticación

---

## Configuración del Proyecto

**Base de datos:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mangaStore
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

**Puerto:**
```
http://localhost:8080
```

---

## Cómo Ejecutar el Proyecto

1. **Iniciar XAMPP** (Apache y MySQL)

2. **Crear la base de datos:**
   - Abre phpMyAdmin
   - Crea una base de datos llamada `mangaStore`
   - Ejecuta el script SQL de [src/main/resources/data.sql](src/main/resources/data.sql)

3. **Compilar y ejecutar:**
```bash
mvn clean install
mvn spring-boot:run
```

4. **Acceder a Swagger:**
   - Abre tu navegador en `http://localhost:8080/swagger-ui.html`

5. **Probar login:**
```bash
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "email": "admin@mangastore.com",
  "password": "admin123"
}
```

---

## Estructura del Proyecto

```
src/main/java/com/duoc/trabajo22/
├── controller/
│   ├── AuthController.java
│   ├── UsuarioController.java
│   └── MangaController.java
├── service/
│   ├── UsuarioService.java
│   └── MangaService.java
├── repository/
│   ├── UsuarioRepository.java
│   └── MangaRepository.java
├── model/
│   ├── Usuario.java
│   ├── Manga.java
│   └── Categoria.java
├── dto/
│   ├── LoginRequest.java
│   └── LoginResponse.java
└── Application.java

src/test/java/com/duoc/trabajo22/service/
├── MangaServiceTest.java
└── UsuarioServiceTest.java

src/main/resources/
├── application.properties
└── data.sql
```

---

## Notas Importantes

1. **Seguridad:** La contraseña NO está encriptada en esta implementación básica. Para producción, se debe agregar BCryptPasswordEncoder.

2. **JWT:** No se implementó JWT en esta etapa según requisitos. El login solo valida credenciales y retorna información del usuario.

3. **CORS:** Si necesitas conectar con un frontend en otro puerto, agrega configuración CORS.

4. **Validaciones:** Se implementaron validaciones básicas. Pueden extenderse según necesidades.

5. **Script SQL:** Debe ejecutarse manualmente en MySQL. Spring Boot no ejecuta automáticamente `data.sql` con `ddl-auto=update`.
