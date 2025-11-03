# ☎️ Agenda Telefónica en Java

Una aplicación de consola en **Java** que permite gestionar una **agenda telefónica** con funcionalidades completas de creación, búsqueda, modificación y eliminación de contactos.  
Ideal para practicar **POO (Programación Orientada a Objetos)**, uso de **colecciones (`List`)**, y manejo de **clases y servicios** en Java.  

---

## 🧠 Características principales

- 👤 **Contactos** definidos por:
  - Nombre
  - Apellido
  - Teléfono  
  *(Dos contactos se consideran iguales si tienen el mismo nombre y apellido, sin importar mayúsculas o minúsculas)*

- 📇 **Agenda configurable:**
  - Se puede crear con un tamaño máximo personalizado.
  - Tamaño por defecto: **10 contactos**.

- 🧰 **Operaciones disponibles:**
  | Funcionalidad | Descripción |
  |---------------|-------------|
  | ➕ `añadirContacto()` | Agrega un nuevo contacto (si hay espacio y no existe). |
  | 🔍 `existeContacto()` | Verifica si un contacto ya existe. |
  | 📋 `listarContactos()` | Muestra todos los contactos ordenados alfabéticamente. |
  | 📞 `buscaContacto()` | Busca un contacto por nombre y apellido. |
  | ❌ `eliminarContacto()` | Elimina un contacto existente. |
  | ✏️ `modificarTelefono()` | Permite actualizar el número de teléfono de un contacto. |
  | 🧱 `agendaLlena()` | Indica si la agenda está llena. |
  | 🧮 `espaciosLibres()` | Muestra cuántos contactos se pueden agregar. |

---


### 🧩 Clases principales

#### `Contact.java`
Define el modelo de un contacto y su lógica de igualdad (`equals` y `hashCode`).

#### `Agenda.java`
Contiene la lista de contactos y el tamaño máximo permitido.

#### `AgendaService.java`
Implementa la lógica de negocio: agregar, eliminar, buscar, listar y modificar contactos.

#### `Main.java`
Muestra un menú por consola para interactuar con la agenda.

---

## 💻 Ejemplo de uso

### 🏁 Al ejecutar el programa:
```bash
Bienvenido a la Agenda Telefónica
¿Deseas indicar un tamaño máximo? (s/n): s
Introduce el tamaño máximo de la agenda: 5

=== MENÚ PRINCIPAL ===
1. Agregar contacto
2. Buscar contacto
3. Eliminar contacto
4. Mostrar todos los contactos
5. Ver espacios disponibles
6. Modificar teléfono de un contacto
0. Salir
Elige una opción: 



