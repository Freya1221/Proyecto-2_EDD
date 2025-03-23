/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clavedicotomica;

import javax.swing.JOptionPane;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

/**
 *
 * @author Freya Blanca, Jesús Schneider, Marcelo Pineiro
 */
public class ArbolBinario {
    
    
    /**
     * Construye un árbol binario vacío
     * Inicializa la raíz como nula y crea una nueva tabla hash para especies
     * 
     */
    private Nodo raiz;  // Raíz del árbol
    private TablaHash tablaEspecies;

    // Constructor
    public ArbolBinario() {
        this.raiz = null;
        this.tablaEspecies = new TablaHash();
    }
    
    
    public boolean existeNodo(String dato) {
        return buscar(raiz, dato) != null;
    }

    /**
     * Inserta un nuevo nodo en el árbol
     * 
     * @param dato Contenido del nodo a insertar
     * @param respuestaPadre Pregunta del nodo padre para ubicación
     * @param esHijoIzquierdo true para hijo izquierdo (True), false para derecho (False)
     */
    public void insertar(String dato, String respuestaPadre, boolean esHijoIzquierdo) {
        // Verificar si el nodo ya existe
        if (existeNodo(dato)) {
            //System.out.println("El nodo ya existe: " + dato);
            return;
        }
        
        Nodo nuevoNodo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevoNodo; // Si el árbol está vacío, el nuevo nodo es la raíz
            return;
        }

        // Buscar el nodo padre
        Nodo padre = buscar(raiz, respuestaPadre);
        if (padre != null) {
            if (esHijoIzquierdo) {
                padre.setIzquierdoTrue(nuevoNodo); // Insertar como hijo izquierdo
            } else {
                padre.setDerechoFalse(nuevoNodo); // Insertar como hijo derecho
            }
        } else {
            System.out.println("No se encontró el nodo padre: " + respuestaPadre);
        }
    }

    
    /**
     * Búsqueda recursiva con registro de historial
     * 
     * @param actual Nodo actual en la búsqueda
     * @param dato Valor a buscar
     * @param historial Arreglo para almacenar el camino de búsqueda
     * @return Nodo encontrado o null
     */
    public Nodo buscarNodo(Nodo actual, String dato, String[] historial) {
        if (actual == null) {
            return null; // Nodo no encontrado
        }

        // Si encontramos el nodo, retornamos el nodo
        if (actual.getPregunta().equals(dato)) {
            return actual;
        }

        // Buscar en el subárbol izquierdo (True)
        Nodo encontradoIzq = buscarNodo(actual.getIzquierdoTrue(), dato, historial);
        if (encontradoIzq != null) {
            historial[0] += actual.getPregunta() + ": True\n"; // Añadir pregunta y respuesta al historial
            return encontradoIzq;
        }

        // Buscar en el subárbol derecho (False)
        Nodo encontradoDer = buscarNodo(actual.getDerechoFalse(), dato, historial);
        if (encontradoDer != null) {
            historial[0] += actual.getPregunta() + ": False\n"; // Añadir pregunta y respuesta al historial
            return encontradoDer;
        }

        return null;
    }
    
    /**
     * Búsqueda recursiva simple en preorden
     * 
     * @param actual Nodo actual en la búsqueda
     * @param dato Valor a buscar
     * @return Nodo encontrado o null
     */
    public Nodo buscar(Nodo actual, String dato) {
        if (actual == null) {
            return null;
        }
        if (actual.getPregunta().equals(dato)) {
            return actual;
        }
        // Buscar en el subárbol izquierdo
        Nodo encontradoIzq = buscar(actual.getIzquierdoTrue(), dato);
        if (encontradoIzq != null) {
            return encontradoIzq; // Si se encontró en el subárbol izquierdo, retornarlo
        }
        // Buscar en el subárbol derecho
        return buscar(actual.getDerechoFalse(), dato);
    }

    /**
     * Recorrer el árbol (Preorden)
     * 
     * @param nodo Nodo actual en el cuestionario
     */
    public void recorrerPreorden(Nodo nodo) {
        if (nodo != null) {
            //System.out.println(nodo.getPregunta());
            recorrerPreorden(nodo.getIzquierdoTrue());
            recorrerPreorden(nodo.getDerechoFalse());
        }
    }
    
    /**
     * Proceso interactivo de determinación de especies
     * 
     * @param pantalla Referencia a la ventana principal
     * @param nodo Nodo actual en el cuestionario
     * @param historial Registro acumulado de preguntas/respuestas
     */
    public void preguntar(Inicio pantalla, Nodo nodo, String historial){
        if (nodo == null){
            JOptionPane.showMessageDialog(pantalla, "No hay conicidencia con tu descripcion");
        }else{
            
        
            if (nodo.getDerechoFalse() == null && nodo.getIzquierdoTrue() == null){
                String encontrado = nodo.getPregunta();
                encontrado = "Arbol encontrado:\n" + encontrado + "\n\nPreguntas:" + historial;
                JOptionPane.showMessageDialog(pantalla, encontrado);
            } else{

                String encontrado = nodo.getPregunta();
                int respuesta = JOptionPane.showConfirmDialog(
                    pantalla,
                    encontrado,
                    "Clave Dicotómica",
                    JOptionPane.YES_NO_OPTION
                );


                if (respuesta == JOptionPane.YES_OPTION) {
                    historial = historial + "\n" + encontrado + ": True";
                    nodo = nodo.getIzquierdoTrue();
                    preguntar(pantalla, nodo, historial);
                } else if (respuesta == JOptionPane.NO_OPTION) {
                    historial = historial + "\n" + encontrado + ": False";
                    nodo = nodo.getDerechoFalse();
                    preguntar(pantalla, nodo, historial);
                }
            }
        }
    }
    
    
    public static void construirGrafo(Nodo nodo, Graph grafo, String id) {
        if (nodo == null) return;

        // Crear nodo actual con su pregunta
        Node nodoGrafico = grafo.addNode(id);
        nodoGrafico.setAttribute("ui.label", nodo.getPregunta());

        // Hijo izquierdo (True)
        if (nodo.getIzquierdoTrue() != null) {
            String nuevoId = id + "T";
            construirGrafo(nodo.getIzquierdoTrue(), grafo, nuevoId); 
            grafo.addEdge(id + "-" + nuevoId, id, nuevoId);          
        }

        // Hijo derecho (False)
        if (nodo.getDerechoFalse() != null) {
            String nuevoId = id + "F";
            construirGrafo(nodo.getDerechoFalse(), grafo, nuevoId);
            grafo.addEdge(id + "-" + nuevoId, id, nuevoId);       
        }
    }
    
    
    public void agregarEspecieATabla(String nombre, Nodo nodo) {
        tablaEspecies.insertar(nombre, nodo);
    }
    
    public Nodo buscarPorHash(String nombre) {
        return tablaEspecies.buscar(nombre);
    }
    
    
    // Getters y setters
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    
}
