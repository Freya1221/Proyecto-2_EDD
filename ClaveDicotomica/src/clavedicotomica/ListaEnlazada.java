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

    public void insertar(String clave, Nodo valor) {
        NodoHash nuevo = new NodoHash(clave, valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

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
