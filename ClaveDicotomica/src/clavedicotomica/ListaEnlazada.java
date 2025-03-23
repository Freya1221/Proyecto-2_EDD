/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clavedicotomica;

/**
 *
 * @author Freya Blanca, Jesús Schneider, Marcelo Pineiro
 */
public class ListaEnlazada {
    NodoHash cabeza;

    /**
     * Inserta un nuevo par clave-valor al inicio de la lista
     * 
     * @param clave Nombre de la especie (clave de búsqueda)
     * @param valor Nodo del árbol binario asociado a la especie
     */
    public void insertar(String clave, Nodo valor) {
        NodoHash nuevo = new NodoHash(clave, valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    /**
     * Busca un valor en la lista mediante su clave
     * 
     * @param clave Nombre de la especie a buscar
     * @return Nodo del árbol binario asociado a la clave, o null si no se encuentra
     */
    public Nodo buscar(String clave) {
        NodoHash actual = cabeza;
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return null;
    }
}
