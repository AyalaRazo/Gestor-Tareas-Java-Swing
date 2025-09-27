# ✅ Task Manager with Priority / Gestor de Tareas con Prioridad - Java Swing

---

## English

This project implements a **Java desktop application** using **Swing**, designed to manage tasks with **priority levels (1-5)**.  
It allows **sorting by creation date** using the **Insertion Sort** algorithm and managing tasks with different data structures.

### ✨ Main Features

- **Add Tasks**  
  - Each task includes: description, priority (1-5), creation date, and status (pending/completed).  
  - Automatically assigns a unique ID.

- **Search Tasks**  
  - Search by matching text in the description.

- **Mark as Completed**  
  - Updates task status and records the completion date.

- **Sort by Creation Date**  
  - Implemented with **Insertion Sort**.

- **Show by Priority**  
  - Uses a `PriorityQueue` to organize tasks by priority (descending).

- **Graphical Interface with Swing**  
  - Form to create tasks and a panel to manage them.  
  - Dynamic list (`JList`) updated according to actions performed.

### 🧑‍💻 Main Classes

- `Tarea`  
  Represents a task with:  
  - `id` (int, auto-increment)  
  - `descripcion` (String)  
  - `fechaCreacion` (Date)  
  - `fechaCompletada` (Date, optional)  
  - `prioridad` (int, from 1 to 5)  
  - `completada` (boolean)  
  Implements `Comparable` to sort by priority and date.

- `GestorTareasApp`  
  Main class extending `JFrame` that implements the GUI.  
  Manages tasks using multiple data structures:  
  - `PriorityQueue<Tarea>` → to prioritize tasks.  
  - `LinkedList<Tarea>` → to maintain all tasks.  
  - `HashSet<Tarea>` → to avoid duplicates.  
  Contains actions to add, search, mark as completed, sort, and display tasks.

### 📊 Algorithms and Data Structures

- **Data Structures Used**  
  - `PriorityQueue`: to handle task priority.  
  - `LinkedList`: to store and iterate through all tasks.  
  - `HashSet`: to ensure uniqueness of tasks.

- **Sorting Algorithm**  
  - **Insertion Sort (`insertionSortPorFecha`)**  
    Applied to the task list to sort tasks by **creation date** in ascending order.

### ▶️ How to Run

Compile and execute:

```bash
javac GestorTareasApp.java
java GestorTareasApp
```

<a href="#"><img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif"></a>

## Español

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
```

## Images

<div align=center>
  <img align=center width="1318" height="881" alt="image" src="https://github.com/user-attachments/assets/719ce88c-cfe4-4ccb-be3e-af33ce03234d" />

  ---
  
  <img align=center width="1321" height="889" alt="image" src="https://github.com/user-attachments/assets/2619c80e-c7c2-4027-b8eb-053c4b0c9e65" />

  ---
  
  <img align=center width="1325" height="889" alt="image" src="https://github.com/user-attachments/assets/2d1b3ca4-9ba6-4ac7-a1ab-ebe0a5385db9" />

  ---
  
  <img align=center width="1328" height="892" alt="image" src="https://github.com/user-attachments/assets/d91fe5b0-44bf-4bfb-85cc-1a5d426feae6" />
</div>




