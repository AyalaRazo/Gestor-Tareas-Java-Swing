/*
 */
package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

class Tarea implements Comparable<Tarea> {
    private static int nextId = 1;
    private final int id;
    private String descripcion;
    private final Date fechaCreacion;
    private Date fechaCompletada;
    private int prioridad; // 1-5, donde 5 es máxima prioridad
    private boolean completada;

    public Tarea(String descripcion, int prioridad) {
        this.id = nextId++;
        this.descripcion = descripcion;
        this.fechaCreacion = new Date();
        this.prioridad = prioridad;
        this.completada = false;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public Date getFechaCreacion() { return fechaCreacion; }
    public Date getFechaCompletada() { return fechaCompletada; }
    public int getPrioridad() { return prioridad; }
    public boolean isCompletada() { return completada; }
    
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrioridad(int prioridad) { this.prioridad = prioridad; }
    
    public void marcarCompletada() {
        this.completada = true;
        this.fechaCompletada = new Date();
    }

    @Override
    public int compareTo(Tarea otra) {
        // Ordenar por prioridad (descendente) y luego por fecha (ascendente)
        if (this.prioridad != otra.prioridad) {
            return Integer.compare(otra.prioridad, this.prioridad);
        }
        return this.fechaCreacion.compareTo(otra.fechaCreacion);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (Prioridad: %d, Creada: %tF%s)",
                completada ? "X" : " ",
                descripcion,
                prioridad,
                fechaCreacion,
                completada ? ", Completada: " + String.format("%tF", fechaCompletada) : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return id == tarea.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class GestorTareasApp extends JFrame {
    private PriorityQueue<Tarea> tareasPrioritarias;
    private LinkedList<Tarea> todasLasTareas;
    private HashSet<Tarea> conjuntoTareas;
    private DefaultListModel<String> listModel;

    public GestorTareasApp() {
        // Inicializar estructuras de datos
        tareasPrioritarias = new PriorityQueue<>();
        todasLasTareas = new LinkedList<>();
        conjuntoTareas = new HashSet<>();
        listModel = new DefaultListModel<>();

        // Configurar la interfaz gráfica
        setTitle("Gestor de Tareas con Prioridad");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de controles
        JPanel controlPanel = new JPanel(new GridLayout(2, 1));
        
        // Panel superior para agregar tareas
        JPanel addPanel = new JPanel(new FlowLayout());
        JTextField descripcionField = new JTextField(20);
        JComboBox<Integer> prioridadCombo = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        JButton addButton = new JButton("Agregar Tarea");
        
        addPanel.add(new JLabel("Descripción:"));
        addPanel.add(descripcionField);
        addPanel.add(new JLabel("Prioridad (1-5):"));
        addPanel.add(prioridadCombo);
        addPanel.add(addButton);
        
        // Panel de búsqueda y acciones
        JPanel actionPanel = new JPanel(new FlowLayout());
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Buscar Tarea");
        JButton completeButton = new JButton("Marcar como Completada");
        JButton sortDateButton = new JButton("Ordenar por Fecha");
        JButton showPriorityButton = new JButton("Mostrar por Prioridad");
        
        actionPanel.add(new JLabel("Buscar:"));
        actionPanel.add(searchField);
        actionPanel.add(searchButton);
        actionPanel.add(completeButton);
        actionPanel.add(sortDateButton);
        actionPanel.add(showPriorityButton);
        
        controlPanel.add(addPanel);
        controlPanel.add(actionPanel);
        
        // Lista de tareas
        JList<String> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        
        // Agregar componentes al frame
        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Manejadores de eventos
        addButton.addActionListener(e -> {
            String descripcion = descripcionField.getText().trim();
            if (!descripcion.isEmpty()) {
                int prioridad = (int) prioridadCombo.getSelectedItem();
                Tarea nuevaTarea = new Tarea(descripcion, prioridad);
                
                tareasPrioritarias.add(nuevaTarea);
                todasLasTareas.add(nuevaTarea);
                conjuntoTareas.add(nuevaTarea);
                actualizarLista(todasLasTareas);
                
                descripcionField.setText("");
            }
        });
        
        searchButton.addActionListener(e -> {
            String busqueda = searchField.getText().toLowerCase();
            if (!busqueda.isEmpty()) {
                LinkedList<Tarea> resultados = new LinkedList<>();
                for (Tarea tarea : todasLasTareas) {
                    if (tarea.getDescripcion().toLowerCase().contains(busqueda)) {
                        resultados.add(tarea);
                    }
                }
                actualizarLista(resultados);
            }
        });
        
        completeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                Tarea tarea = todasLasTareas.get(selectedIndex);
                tarea.marcarCompletada();
                tareasPrioritarias.remove(tarea);
                actualizarLista(todasLasTareas);
            }
        });
        
        sortDateButton.addActionListener(e -> {
            insertionSortPorFecha(todasLasTareas);
            actualizarLista(todasLasTareas);
        });
        
        showPriorityButton.addActionListener(e -> {
            LinkedList<Tarea> ordenadas = new LinkedList<>(tareasPrioritarias);
            actualizarLista(ordenadas);
        });
    }
    
    private void actualizarLista(List<Tarea> tareas) {
        listModel.clear();
        for (Tarea tarea : tareas) {
            listModel.addElement(tarea.toString());
        }
    }
    
    // Insertion Sort para ordenar por fecha
    private void insertionSortPorFecha(List<Tarea> tareas) {
        for (int i = 1; i < tareas.size(); i++) {
            Tarea key = tareas.get(i);
            int j = i - 1;
            
            while (j >= 0 && tareas.get(j).getFechaCreacion().after(key.getFechaCreacion())) {
                tareas.set(j + 1, tareas.get(j));
                j--;
            }
            tareas.set(j + 1, key);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestorTareasApp app = new GestorTareasApp();
            app.setVisible(true);
        });
    }
}