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

    /**
     * Construye un nuevo nodo para la tabla hash
     * 
     * @param clave Identificador único de la especie
     * @param valor Nodo del árbol binario asociado a la especie
     */
    public NodoHash(String clave, Nodo valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }
}
