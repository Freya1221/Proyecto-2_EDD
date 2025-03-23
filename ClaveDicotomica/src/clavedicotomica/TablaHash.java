/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clavedicotomica;

/**
 *
 * @author Freya Blanca, Jesús Schneider, Marcelo Pineiro
 */
public class TablaHash {
    private static final int TAMANO_INICIAL = 101; // Tamaño primo para reducir colisiones
    private ListaEnlazada[] tabla;

    // Constructor
    public TablaHash() {
        tabla = new ListaEnlazada[TAMANO_INICIAL];
        for (int i = 0; i < TAMANO_INICIAL; i++) {
            tabla[i] = new ListaEnlazada();
        }
    }
    
    // Función hash (suma de caracteres módulo tamaño)
    private int hash(String clave) {
        int suma = 0;
        for (char c : clave.toCharArray()) {
            suma += c;
        }
        return suma % TAMANO_INICIAL;
    }

    // Insertar clave-valor
    public void insertar(String clave, Nodo valor) {
        int indice = hash(clave);
        tabla[indice].insertar(clave, valor);
    }

    // Buscar por clave
    public Nodo buscar(String clave) {
        int indice = hash(clave);
        return tabla[indice].buscar(clave);
    }
    
}
