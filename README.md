# ✅ Gestor de Tareas con Prioridad - Java Swing

Este proyecto implementa una **aplicación de escritorio en Java**, utilizando **Swing**, para gestionar tareas con niveles de **prioridad (1 a 5)**.  
Incluye la posibilidad de **ordenar por fecha de creación** mediante el algoritmo **Insertion Sort** y gestionar tareas con diferentes estructuras de datos.

---

## ✨ Funcionalidades principales

- **Agregar tareas**
  - Cada tarea tiene: descripción, prioridad (1-5), fecha de creación y estado (pendiente/completada).
  - Se asigna un identificador único automáticamente.

- **Buscar tareas**
  - Búsqueda por coincidencia en la descripción.

- **Marcar como completadas**
  - Actualiza el estado de la tarea y registra la fecha de finalización.

- **Ordenar por fecha de creación**
  - Implementado con el algoritmo **Insertion Sort**.

- **Mostrar por prioridad**
  - Uso de una `PriorityQueue` para organizar las tareas según su prioridad (descendente).

- **Interfaz gráfica con Swing**
  - Formulario para crear tareas y panel para gestionarlas.
  - Lista dinámica (`JList`) que se actualiza según las acciones realizadas.

---

## 🧑‍💻 Clases principales

### `Tarea`
- Representa una tarea con:
  - `id` (int, autoincremental)
  - `descripcion` (String)
  - `fechaCreacion` (Date)
  - `fechaCompletada` (Date, opcional)
  - `prioridad` (int, de 1 a 5)
  - `completada` (boolean)
- Implementa `Comparable` para ordenar por prioridad y fecha.

### `GestorTareasApp`
- Clase principal que extiende `JFrame` e implementa la interfaz gráfica.
- Gestiona las tareas con varias estructuras de datos:
  - `PriorityQueue<Tarea>` → para priorizar tareas.
  - `LinkedList<Tarea>` → para mantener todas las tareas.
  - `HashSet<Tarea>` → para evitar duplicados.
- Contiene las acciones de agregar, buscar, marcar como completada, ordenar y mostrar.

---

## 📊 Algoritmos y estructuras de datos en el proyecto

- **Estructuras usadas**
  - `PriorityQueue`: para manejar la prioridad de las tareas.
  - `LinkedList`: para almacenar y recorrer todas las tareas.
  - `HashSet`: para garantizar unicidad de las tareas.

- **Algoritmo de ordenamiento**
  - **Insertion Sort (`insertionSortPorFecha`)**  
    Se aplica sobre la lista de tareas para ordenarlas por **fecha de creación** de forma ascendente.

---

## ▶️ Ejecución

Compilar y ejecutar con:

```bash
javac GestorTareasApp.java
java GestorTareasApp
