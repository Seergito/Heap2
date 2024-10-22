/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.heapbinario;

import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class HeapBinario<E extends Comparable<E>> implements Heap<E>{
    
    private static final int CAPACIDAD= 50;
    private E [] arrayHeap;
    private E [] arrayTemp;
    private int numElemn;
    
    public HeapBinario(){
        this(CAPACIDAD);
        
    }
    public HeapBinario(int capacidad){
        if(capacidad < 0){
            throw new IllegalArgumentException("Capacidad superada");
        }
        arrayHeap = (E[]) new Comparable[capacidad +1];
        numElemn = 0;
    }
    
    

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @Override
    public boolean esVacio() {
        if(numElemn == 0){
            return true;
        }else{
            return false;
        }
    }
    
  

    @Override
    public E recuperarMax() throws HeapVacioException {
        
        if(esVacio()){
            throw new HeapVacioException();
        }
        return arrayHeap[1];
    }

    @Override
    public E suprimirMax() throws HeapVacioException {
     
        if(esVacio()){
            throw new HeapVacioException("Error");
        }
        
        E e = arrayHeap[1];
        arrayHeap[1]= arrayHeap[numElemn];
        arrayHeap[numElemn] = null;
        numElemn--;
        hundir(1);
        return e;
    }
    
 private void hundir(int hueco) {
    int hijo = hueco * 2;
    E temp = arrayHeap[hueco];
    boolean fin =false;

    if (numElemn == arrayHeap.length - 1) {
      //  duplicarVector();
    }

    hueco = numElemn++;
    while (hueco / 2 >= 1 && arrayHeap[hueco / 2].compareTo(temp) < 0) {
        arrayHeap[hueco] = arrayHeap[hueco / 2];
        hueco /= 2;
    }

    while (hijo <= numElemn && !fin) {
        if (hijo + 1 <= numElemn && arrayHeap[hijo + 1].compareTo(arrayHeap[hijo]) > 0) {
            hijo++;
        }
        if (arrayHeap[hijo].compareTo(temp) > 0) {
            arrayHeap[hueco] = arrayHeap[hijo];
            arrayHeap[hijo] = temp;
            hueco = hijo;
            hijo = hijo * 2;
        } else {
            fin=true;
        }
    }
}


      /*
    COMPARE TO: obj1.compareTo(obj2)
    RETURN -1 = obj1<obj2
    return 0 = obj1=obj2
    return 1 = obj1 >obj2
    */
    
    @Override
    public void insertar(E e) throws NullPointerException {
        
        if(numElemn == CAPACIDAD){
            duplicar();
            //DUPLICAMOS EL ARRAY
        }else{
            
            insercion(e);
            
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void duplicar(){
        arrayTemp = (E[]) new Comparable[CAPACIDAD *2];
        
        for (int i = 1; i < arrayHeap.length; i++) {
            arrayTemp[i]= arrayHeap[i];
        }
        arrayHeap = arrayTemp;
        
    }
    
    private void insercion(E e) {
        
        int pos= ++numElemn;
        arrayHeap[pos] = e; //Inserta en la ultima pos
        
        
        //REORDENACION
        
        while( pos>1 && arrayHeap[pos/2].compareTo(e) >0 ){ //Comparamos constantemente el padre en la posición con el elemento a insertar
        arrayHeap[pos] = arrayHeap[pos/2]; //Subirmos al padre
        pos/=2; //Modificamos índice para apuntar el padre
        
            
        }
        arrayHeap[pos]=e; //Insertamos al salir del bucle
        
     //MIENTRAS EL PADRE SEA MAYOR
        
    }

    @Override
    public void anular() {
        if(esVacio()){
            throw new HeapVacioException();
        }
        int n=1;
        while(n<numElemn){
            arrayHeap[n]=null;
            n++;
        }
        numElemn=0;
        
    }
    
    
    public void introducir(E e){
        if(e ==null ){
            throw new NullPointerException();
        }else{
            //duplicarVector();
        }
        if(numElemn==arrayHeap.length-1){
            //duplicarVector();
        }
        
        int hueco= ++numElemn;
        arrayHeap[hueco]= e;
    }
    
    public void arreglarHeap(){
        for (int i = numElemn/2; i > 0; i--) {
            hundir(i);
        }
    }
    
    public static void heapSort(int[] elementos){
        Heap<Integer> heap=new HeapBinario();
        for (int i = 0; i < elementos.length ; i++) {
            heap.introducir(elementos[i]);
        }
        heap.arreglarHeap();
        for (int i = 0; i < elementos.length; i++) {
            elementos[i]= heap.suprimirMax();
        }
    }

}
