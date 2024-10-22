/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heapbinario;

/**
 *
 * @author Sergio
 */
public class HeapVacioException extends RuntimeException {
    
    public HeapVacioException(){
        super();
    }
    public HeapVacioException(String mensaje){
        super(mensaje);
    }
    
}
