/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.heapbinario;

/**
 *
 * @author Sergio
 * @param <E>
 */
public interface Heap<E extends Comparable<E>> {
    public boolean esVacio();
    public E recuperarMax() throws HeapVacioException;
    public E suprimirMax() throws HeapVacioException;
    public void insertar(E e) throws NullPointerException;
    public void anular();
    public void introducir(E e) throws NullPointerException;
    public void arreglarHeap();
    
    
}
