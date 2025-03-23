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

    /**
     * Construye una nueva tabla hash vacía\
     * Inicializa cada posición de la tabla con una lista enlazada vacía
     * 
     */
    public TablaHash() {
        tabla = new ListaEnlazada[TAMANO_INICIAL];
        for (int i = 0; i < TAMANO_INICIAL; i++) {
            tabla[i] = new ListaEnlazada();
        }
    }
    
    /**
     * Función hash que calcula la posición en la tabla
     * 
     * @param clave Cadena de texto para calcular su hash
     * @return Índice en la tabla (entre 0 y TAMANO_INICIAL-1)
     */
    private int hash(String clave) {
        int suma = 0;
        for (char c : clave.toCharArray()) {
            suma += c;
        }
        return suma % TAMANO_INICIAL;
    }

     /**
     * Inserta un nuevo par clave-valor en la tabla
     * 
     * @param clave Nombre de la especie (clave de búsqueda)
     * @param valor Nodo del árbol binario asociado a la especie
     */
    public void insertar(String clave, Nodo valor) {
        int indice = hash(clave);
        tabla[indice].insertar(clave, valor);
    }

    /**
     * Busca un valor en la tabla por su clave
     * 
     * @param clave Nombre de la especie a buscar
     * @return Nodo asociado a la especie o null si no se encuentra
     */
    public Nodo buscar(String clave) {
        int indice = hash(clave);
        return tabla[indice].buscar(clave);
    }
    
}
