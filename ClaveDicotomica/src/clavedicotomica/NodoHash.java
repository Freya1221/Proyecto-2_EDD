/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clavedicotomica;

/**
 *
 * @author Freya Blanca, Jesús Schneider, Marcelo Pineiro
 */
public class NodoHash {
    String clave;
    Nodo valor;
    NodoHash siguiente;

    public NodoHash(String clave, Nodo valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }
}
