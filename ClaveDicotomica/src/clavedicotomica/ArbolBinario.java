/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clavedicotomica;

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

    // Insertar nodos manualmente
    public void insertar(String dato, String respuestaPadre, boolean esHijoIzquierdo) {
        Nodo nuevoNodo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevoNodo;
            return;
        }
        Nodo padre = buscarNodo(raiz, respuestaPadre);
        if (padre != null) {
            if (esHijoIzquierdo) {
                padre.setIzquierdoTrue(nuevoNodo);
            } else {
                padre.setDerechoFalse(nuevoNodo);
            }
        }
    }

    // Buscar un nodo por su dato (recorrido preorden)
    private Nodo buscarNodo(Nodo actual, String dato) {
        if (actual == null) return null;
        if (actual.getPregunta().equals(dato)) return actual;
        Nodo encontradoIzq = buscarNodo(actual.getIzquierdoTrue(), dato);
        return (encontradoIzq != null) ? encontradoIzq : buscarNodo(actual.getDerechoFalse(), dato);
    }

    // Recorrer el árbol (Preorden)
    public void recorrerPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.getPregunta());
            recorrerPreorden(nodo.getIzquierdoTrue());
            recorrerPreorden(nodo.getDerechoFalse());
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
