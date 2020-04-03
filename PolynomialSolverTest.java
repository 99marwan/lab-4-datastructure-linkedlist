package eg.edu.alexu.csd.datastructure.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PolynomialSolverTest {
    @Test
    void setPolynomialTestZero() {
        //arr terms element is null
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr = null;
        assertThrows(ArrayIndexOutOfBoundsException.class,()->e.setPolynomial('A',arr));
        assertThrows(ArrayIndexOutOfBoundsException.class,()->e.setPolynomial('B',arr));
        assertThrows(ArrayIndexOutOfBoundsException.class,()->e.setPolynomial('C',arr));
        assertThrows(ArrayIndexOutOfBoundsException.class,()->e.setPolynomial('R',arr));
    }
    @Test
    void setPolynomialTestOne() {
        //arr terms element is empty
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr = new int[][]{};
        assertThrows(ArrayIndexOutOfBoundsException.class,()->e.setPolynomial('A',arr));
        assertThrows(ArrayIndexOutOfBoundsException.class,()->e.setPolynomial('B',arr));
        assertThrows(ArrayIndexOutOfBoundsException.class,()->e.setPolynomial('C',arr));
        assertThrows(ArrayIndexOutOfBoundsException.class,()->e.setPolynomial('R',arr));
    }
    @Test
    void setPolynomialTestTwo() {
        //arr terms have single element
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr = new int[][]{{2,2}};
        e.setPolynomial('A',arr);
        e.setPolynomial('B',arr);
        e.setPolynomial('C',arr);
        for (int i=0;i<e.A.size();i++){
            assertArrayEquals((int[])e.A.get(i),(int[])e.B.get(i));
        }
        for (int i=0;i<e.A.size();i++){
            assertArrayEquals((int[])e.A.get(i),(int[])e.C.get(i));
        }
        for (int i=0;i<e.B.size();i++){
            assertArrayEquals((int[])e.B.get(i),(int[])e.C.get(i));
        }
    }
    @Test
    void setPolynomialTestThere() {
        //arr terms NOT empty
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{2,2},{3,3},{1,1},{2,3},{4,2},{5,0},{5,-1}};
        e.setPolynomial('A',arr);
        e.setPolynomial('B',arr);
        e.setPolynomial('C',arr);
        for (int i=0;i<e.A.size();i++){
            assertArrayEquals((int[])e.A.get(i),(int[])e.B.get(i));
        }
        for (int i=0;i<e.A.size();i++){
            assertArrayEquals((int[])e.A.get(i),(int[])e.C.get(i));
        }
        for (int i=0;i<e.B.size();i++){
            assertArrayEquals((int[])e.B.get(i),(int[])e.C.get(i));
        }
    }
    @Test
    void printTestOne() {
        //A isnot empty
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{2,2},{3,3},{1,1},{2,3},{4,2},{5,0},{5,-1}};
        e.setPolynomial('A',arr);
        assertEquals("5*X^3+6*X^2+x+5+5*X^-1",e.print('A'));
    }
    @Test
    void printTestTwo() {
        //character is null is empty
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{2,2},{3,3},{1,1},{2,3},{4,2},{5,0},{5,-1}};
        e.setPolynomial('A',arr);
        Character m =null;
        assertThrows(NullPointerException.class,()->e.print(m));
    }
    @Test
    void printTestThere() {
        //terms is empty
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{};
        assertThrows(ArrayIndexOutOfBoundsException.class,()->e.setPolynomial('A',arr));
        assertEquals("",e.print('A'));
    }

    @Test
    void clearPolynomialTestZero() {
        //arr terms element is null A,B,C,R will be emprt (cleaned)
        PolynomialSolver e = new PolynomialSolver();
        doubleLinkedList testA = e.A;
        e.clearPolynomial('A');
        assertEquals(testA,e.A);
        doubleLinkedList testB = e.B;
        e.clearPolynomial('B');
        assertEquals(testB,e.B);
        doubleLinkedList testC = e.C;
        e.clearPolynomial('C');
        assertEquals(testC,e.C);
        doubleLinkedList testR = e.R;
        e.clearPolynomial('R');
        assertEquals(testR,e.R);
    }
    @Test
    void clearPolynomialTestOne() {
        //arr terms element is empty A,B,C,R will be emprt (cleaned)
        PolynomialSolver e = new PolynomialSolver();
        doubleLinkedList testA = e.A;
        e.clearPolynomial('A');
        assertEquals(testA,e.A);
        doubleLinkedList testB = e.B;
        e.clearPolynomial('B');
        assertEquals(testB,e.B);
        doubleLinkedList testC = e.C;
        e.clearPolynomial('C');
        assertEquals(testC,e.C);
        doubleLinkedList testR = e.R;
        e.clearPolynomial('R');
        assertEquals(testR,e.R);
    }
    @Test
    void clearPolynomialTestTwo() {
        //arr terms have single element
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr = new int[][]{{2,2}};
        e.setPolynomial('A',arr);
        e.setPolynomial('B',arr);
        e.setPolynomial('C',arr);
        e.clearPolynomial('A');
        int ACleanSize=e.A.size();
        assertEquals(0,ACleanSize);
        e.clearPolynomial('B');
        int BCleanSize=e.B.size();
        assertEquals(0,BCleanSize);
        e.clearPolynomial('C');
        int CCleanSize=e.C.size();
        assertEquals(0,CCleanSize);
        e.clearPolynomial('R');
        int RCleanSize=e.R.size();
        assertEquals(0,RCleanSize);
    }
    @Test
    void clearPolynomialTestThere() {
        //arr terms NOT empty
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{2,2},{3,3},{1,1},{2,3},{4,2},{5,0},{5,-1}};
        e.setPolynomial('A',arr);
        e.setPolynomial('B',arr);
        e.setPolynomial('C',arr);
        e.clearPolynomial('A');
        int ACleanSize=e.A.size();
        assertEquals(0,ACleanSize);
        e.clearPolynomial('B');
        int BCleanSize=e.B.size();
        assertEquals(0,BCleanSize);
        e.clearPolynomial('C');
        int CCleanSize=e.C.size();
        assertEquals(0,CCleanSize);
        e.clearPolynomial('R');
        int RCleanSize=e.R.size();
        assertEquals(0,RCleanSize);
    }
    @Test
    void evaluatePolynomialTest1() {
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{1,1},{1,0}};
        e.setPolynomial('A', arr);
        e.setPolynomial('B',arr);
        e.setPolynomial('C',arr);
        assertEquals(2.0,e.evaluatePolynomial('A', 1));
        assertEquals(2.0,e.evaluatePolynomial('B', 1));
        assertEquals(2.0,e.evaluatePolynomial('C', 1));
        assertEquals(3.0,e.evaluatePolynomial('A', 2));
        assertEquals(3.0,e.evaluatePolynomial('B', 2));
        assertEquals(3.0,e.evaluatePolynomial('C', 2));
    }

    @Test
    void evaluatePolynomialTest2() {
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{1,2},{2,1},{1,0},{1,2},{2,1},{1,0}};
        e.setPolynomial('A', arr);
        e.setPolynomial('B',arr);
        e.setPolynomial('C',arr);
        assertEquals(8.0,e.evaluatePolynomial('A', 1));
        assertEquals(8.0,e.evaluatePolynomial('B', 1));
        assertEquals(8.0,e.evaluatePolynomial('C', 1));
        assertEquals(18.0,e.evaluatePolynomial('A', 2));
        assertEquals(18.0,e.evaluatePolynomial('B', 2));
        assertEquals(18.0,e.evaluatePolynomial('C', 2));
    }
    @Test
    void evaluatePolynomialTest3() {
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{2,3},{1,2},{2,1},{1,0}};
        e.setPolynomial('A', arr);
        e.setPolynomial('B',arr);
        //C is not set so the list is null so any evaluate equals zero
        assertEquals(6.0,e.evaluatePolynomial('A', 1));
        assertEquals(6.0,e.evaluatePolynomial('B', 1));
        assertEquals(0.0,e.evaluatePolynomial('C', 1));
        assertEquals(25.0,e.evaluatePolynomial('A', 2));
        assertEquals(25.0,e.evaluatePolynomial('B', 2));
        assertEquals(0.0,e.evaluatePolynomial('C', 2));
    }

    @Test
    void addTest1() {
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{1,2},{2,1},{1,0},{1,2},{2,1},{1,0}};
        e.setPolynomial('A', arr);
        e.setPolynomial('B',arr);
        //C is not set so the list is null so any evaluate equals zero
        int [][] array ={{4,2},{8,1},{4,0}};
        assertArrayEquals(array, e.add('A','B'));

        int [][] array1 ={{2,2},{4,1},{2,0}};
        //here the result will be B as C equals zero
        assertArrayEquals(array1, e.add('C','B'));
    }

    @Test
    void addTest2() {
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{1,1},{1,0}};
        int[][] arr2=new int[][]{{1,1},{-1,0}};
        e.setPolynomial('A', arr);
        e.setPolynomial('B',arr2);
        //C is not set so the list is null so any evaluate equals zero
        int [][] array ={{2,1}};
        assertArrayEquals(array, e.add('A','B'));

        int [][] array1 ={{1,1},{-1,0}};
        //here the result will be B as C equals zero
        assertArrayEquals(array1, e.add('C','B'));
    }

    @Test
    void subtractTest1() {
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{1,2},{2,1},{1,0},{1,2},{2,1},{1,0}};
        e.setPolynomial('A', arr);
        e.setPolynomial('B',arr);
        //C is not set so the list is null so any evaluate equals zero
        int [][] array ={{0,0}};
        assertArrayEquals(array, e.subtract('A','B'));

        int [][] array1 ={{-2,2},{-4,1},{-2,0}};
        //here the result will be -B as C equals zero "0-B"
        assertArrayEquals(array1, e.subtract('C','B'));
    }

    @Test
    void subtractTest2() {
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{1,1},{1,0}};
        int[][] arr2=new int[][]{{1,1},{-1,0}};
        e.setPolynomial('A', arr);
        e.setPolynomial('B',arr2);
        //C is not set so the list is null so any evaluate equals zero
        int [][] array ={{2,0}};
        assertArrayEquals(array, e.subtract('A','B'));

        int [][] array1 ={{-1,1},{1,0}};
        //here the result will be B as C equals zero
        assertArrayEquals(array1, e.subtract('C','B'));
    }
    @Test
    void multiplyTest1() {
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{1,2},{2,1},{1,0},{1,2},{2,1},{1,0}};
        e.setPolynomial('A', arr);
        e.setPolynomial('B',arr);
        //C is not set so the list is null so any evaluate equals zero
        int [][] array ={{4,4},{16,3},{24,2},{16,1},{4,0}};
        assertArrayEquals(array, e.multiply('A','B'));

        int [][] array1 ={{0,0}};
        //here the result will be -B as C equals zero "null*b" will return empty array not "null" but
        //we make a condition if R is Empty return{0,0}
        assertArrayEquals(array1, e.multiply('C','B'));
    }

    @Test
    void multiplyTest2() {
        PolynomialSolver e = new PolynomialSolver();
        int[][] arr=new int[][]{{1,1},{1,0}};
        int[][] arr2=new int[][]{{1,1},{-1,0}};
        e.setPolynomial('A', arr);
        e.setPolynomial('B',arr2);
        //C is not set so the list is null so any evaluate equals zero
        int [][] array ={{1,2},{-1,0}};
        assertArrayEquals(array, e.multiply('A','B'));

        int [][] array1 = {{0,0}};
        //here the result will be -B as C equals zero "null*b" will return empty array not "null" but
        //we make a condition if R is Empty return{0,0}
        assertArrayEquals(array1, e.multiply('C','B'));
    }
}