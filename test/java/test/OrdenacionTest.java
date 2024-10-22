/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author estudante
 */
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;


public class OrdenacionTest {
    
    public OrdenacionTest() {
    }

    /**
     * Test of heapSort method, of class Ordenacion.
     */
    @Test
    public void testHeapSortVacio() {
        System.out.println("heapSort vacío");
        Integer[] elementos = {};
        Integer[] expResult = {};
        Ordenacion.heapSort(elementos);
        assertTrue(Arrays.equals(elementos, expResult));
    }
    @Test
    public void testHeapSort1() {
        System.out.println("heapSort 1 elemento");
        Integer[] elementos = {23};
        Integer[] expResult = {23};
        Ordenacion.heapSort(elementos);
        assertTrue(Arrays.equals(elementos, expResult));
    }
    @Test
    public void testHeapSort() {
        System.out.println("heapSort varios elementos");
        Integer[] elementos = {23,45,12,34,67,43,76,88,69,28,61};
        Integer[] expResult = {88,76,69,67,61,45,43,34,28,23,12};
        Ordenacion.heapSort(elementos);
        assertTrue(Arrays.equals(elementos, expResult));
    }
    
}