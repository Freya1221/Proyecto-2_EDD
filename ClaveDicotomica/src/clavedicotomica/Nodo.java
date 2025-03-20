/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clavedicotomica;

/**
 *
 * @author Freya Blanca, Jesús Schneider, Marcelo Pineiro
 */
public class Nodo {
    private String dato;       // Almacena la pregunta o valor
    private Nodo izquierdo;    // Hijo izquierdo
    private Nodo derecho;      // Hijo derecho
    
    // Constructor
    public Nodo(String dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    // Getters y setters
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
    
    
}
