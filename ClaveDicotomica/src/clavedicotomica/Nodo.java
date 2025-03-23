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
    private String pregunta;       // Almacena la pregunta
    private Nodo izquierdoTrue;    // Hijo izquierdo
    private Nodo derechoFalse;      // Hijo derecho
    private String especie; // Solo en nodos hoja
    
    /**
     * Construye un nuevo nodo con una pregunta/característica
     * 
     * @param pregunta Texto de la pregunta o característica biológica. Para nodos hoja, puede ser el nombre de una especie.
     *                 
     */
    public Nodo(String pregunta) {
        this.pregunta = pregunta;
        this.izquierdoTrue = null;
        this.derechoFalse = null;
        this.especie = null;
    }
    
    // Getters y setters
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Nodo getIzquierdoTrue() {
        return izquierdoTrue;
    }

    public void setIzquierdoTrue(Nodo izquierdoTrue) {
        this.izquierdoTrue = izquierdoTrue;
    }

    public Nodo getDerechoFalse() {
        return derechoFalse;
    }

    public void setDerechoFalse(Nodo derechoFalse) {
        this.derechoFalse = derechoFalse;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    /**
     * Determina si el nodo es una hoja (nodo terminal)
     * 
     * @return true si es un nodo hoja, false en caso contrario
     */
    public boolean esHoja() {
        return (izquierdoTrue == null && derechoFalse == null) || especie != null;
    }
    
    
    
}
