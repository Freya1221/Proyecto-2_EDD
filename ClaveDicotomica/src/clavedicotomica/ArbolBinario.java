/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clavedicotomica;

import javax.swing.JOptionPane;

/**
 *
 * @author Freya Blanca, Jesús Schneider, Marcelo Pineiro
 */
public class ArbolBinario {
    private Nodo raiz;  // Raíz del árbol

    // Constructor
    public ArbolBinario() {
        this.raiz = null;
    }
    
    public boolean existeNodo(String dato) {
        return buscar(raiz, dato) != null;
    }

    // Insertar nodos manualmente
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

    //Buscar un nodo por su dato (recorrido preorden)
    private Nodo buscarNodo(Nodo actual, String dato) {
        if (actual == null) return null;
        if (actual.getPregunta().equals(dato)) return actual;
        Nodo encontradoIzq = buscarNodo(actual.getIzquierdoTrue(), dato);
        return (encontradoIzq != null) ? encontradoIzq : buscarNodo(actual.getDerechoFalse(), dato);
    }
    
    
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

    // Recorrer el árbol (Preorden)
    public void recorrerPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.getPregunta());
            recorrerPreorden(nodo.getIzquierdoTrue());
            recorrerPreorden(nodo.getDerechoFalse());
        }
    }
    
    public void preguntar(Inicio pantalla, Nodo nodo, String historial){
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
    
    
    // Getters y setters
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    
}
