package eg.edu.alexu.csd.datastructure.linkedList;
import java.lang.Math;
public class PolynomialSolver implements IPolynomialSolver {

    doubleLinkedList A = new doubleLinkedList();
    doubleLinkedList B = new doubleLinkedList();
    doubleLinkedList C = new doubleLinkedList();
    doubleLinkedList R = new doubleLinkedList();
    private int[][] noDoublicate(int array[][]){
        int [][]arr=new int [array.length][array[0].length];
        for (int i=0;i<array.length;i++){
            arr[i][0]=array[i][0];
            arr[i][1]=array[i][1];
        }
        int i=0,j=0;
        int numOfDublicate=0;
        for (i=0;i<arr.length;i++){
            for (j=0;j<arr.length;j++){
                if (arr[i][1]==arr[j][1]&i!=j){
                    numOfDublicate++;
                }
            }
        }
        numOfDublicate/=2;
        int[][] newArr=new int[arr.length-numOfDublicate][];
        i=0;
        j=0;
        for (i=0;i<arr.length;i++){
            for (j=0;j<arr.length;j++){
                if (arr[j]!=null&arr[i]!=null) {
                    if ((arr[i][1] == arr[j][1] & i != j)) {
                        arr[i][0] += arr[j][0];
                        arr[j] = null;
                    }
                }
            }
        }
        j=0;
        for (i=0;i<newArr.length;i++){
            if (arr[j]==null){
                j++;
                i--;
            }
            else {
                newArr[i] = arr[j];
                j++;
            }
        }
        return newArr;
    }
    private int[] maxAndLessThan(int arr[][],int m) {
        int max=0;
        int rowOfMax =0;
        int maximum[]=new int[2];
        boolean done = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] < m) {
                max = arr[i][1];
                rowOfMax=i;
                done = true;
                break;
            }
        }
        if (done == true) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][1] < m & arr[i][1] > max) {
                    max = arr[i][1];
                    rowOfMax=i;
                }
            }
        }
        else {
            maximum =null;//no element in the array is smaler than m
        }
        maximum[0]=max;
        maximum[1]=rowOfMax;
        return maximum;
    }
    private doubleLinkedList arrayToDoubleLinkedList(int array[][]){
        int[][]arr=noDoublicate(array);
        int numOfRows = arr.length;//number of nodes(terms)
        int numOfColumns=arr[0].length;//2:coefficint & exponent
        doubleLinkedList list = new doubleLinkedList();
        int i=0;
        int max=arr[0][1];
        int rowOfMax=0;
        for(i=0;i<arr.length;i++){
            if (arr[i][1]>max){
                max=arr[i][1];
                rowOfMax=i;
            }
        }
        list.add(arr[rowOfMax]);
        i=0;
        int [] temp= new int[2];
        while(i<numOfRows-1){
            temp=maxAndLessThan(arr,max);
            max=temp[0];
            rowOfMax=temp[1];
            if (temp!= null){
                list.add(arr[rowOfMax]);
            }
            i++;
        }
        return list;
    }
    private int[][] doubleLinkedListToArray(doubleLinkedList list){
        int numOfRows=list.size();
        int[][] arr = new int[numOfRows][2];
        int i=0;
        while (i<numOfRows){
            arr[i]= (int[]) list.get(i);
            i++;
        }
        return arr;
    }
    @Override
    public void  setPolynomial(char poly, int[][] terms){
        if (terms!=null&&terms.length>0) {
            if (poly == 'A') {
                A = arrayToDoubleLinkedList(terms);
            } else if (poly == 'B') {
                B = arrayToDoubleLinkedList(terms);
            } else if (poly == 'C') {
                C = arrayToDoubleLinkedList(terms);
            } else if (poly == 'R') {
                R = arrayToDoubleLinkedList(terms);
            }
            else{
                RuntimeException runtimeException = new RuntimeException();
                throw runtimeException;
            }
        }
        else {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
            throw arrayIndexOutOfBoundsException;
        }
    }
    private String fromLInkedList(doubleLinkedList list) {
        String output = "";
        if (list.size() > 0) {
            int numOfTerms = list.size();
            doubleLinkedList.doubleLinkedListNode temp = list.header;
            int i;
            for (i = 0; i < numOfTerms; i++) {
                temp = temp.getNext();
                if (temp.getPrev() != list.header) {
                    if (((int[]) temp.getElement())[1] == 1) {
                        if (((int[]) temp.getElement())[0] == 1) {
                            output += "+" + "x";
                        } else if (((int[]) temp.getElement())[0] == 0) {
                            output = output;
                        } else if (((int[]) temp.getElement())[0] > 1) {
                            output += "+" + ((int[]) temp.getElement())[0] + "*X";
                        } else {
                            output += "-" + (0 - ((int[]) temp.getElement())[0]) + "*X";
                        }
                    } else if (((int[]) temp.getElement())[1] == 0) {
                        if (((int[]) temp.getElement())[0] == 1) {
                            output += "+" + "1";
                        } else if (((int[]) temp.getElement())[0] == 0) {
                            output = output;
                        } else if (((int[]) temp.getElement())[0] > 1) {
                            output += "+" + ((int[]) temp.getElement())[0];
                        } else {
                            output += "-" + (0 - ((int[]) temp.getElement())[0]);
                        }
                    } else {
                        if (((int[]) temp.getElement())[0] == 1) {
                            output += "+" + "x^" + ((int[]) temp.getElement())[1];
                        } else if (((int[]) temp.getElement())[0] == 0) {
                            output = output;
                        } else if (((int[]) temp.getElement())[0] > 1) {
                            output += "+" + ((int[]) temp.getElement())[0] + "*X^" + ((int[]) temp.getElement())[1];
                        } else {
                            output += "-" + (0 - ((int[]) temp.getElement())[0]) + "*X^" + ((int[]) temp.getElement())[1];
                        }
                    }
                } else {
                    if (((int[]) temp.getElement())[1] == 1) {
                        if (((int[]) temp.getElement())[0] == 1) {
                            output += "x";
                        } else if (((int[]) temp.getElement())[0] == 0) {
                            output = output;
                        } else if (((int[]) temp.getElement())[0] > 1) {
                            output += ((int[]) temp.getElement())[0] + "*X";
                        } else {
                            output += ((int[]) temp.getElement())[0] + "*X";
                        }
                    } else if (((int[]) temp.getElement())[1] == 0) {
                        if (((int[]) temp.getElement())[0] == 1) {
                            output += "1";
                        } else if (((int[]) temp.getElement())[0] == 0) {
                            output = output;
                        } else if (((int[]) temp.getElement())[0] > 1) {
                            output += ((int[]) temp.getElement())[0];
                        } else {
                            output += ((int[]) temp.getElement())[0];
                        }
                    } else {
                        if (((int[]) temp.getElement())[0] == 1) {
                            output += "x^" + ((int[]) temp.getElement())[1];
                        } else if (((int[]) temp.getElement())[0] == 0) {
                            output = output;
                        } else if (((int[]) temp.getElement())[0] > 1) {
                            output += ((int[]) temp.getElement())[0] + "*X^" + ((int[]) temp.getElement())[1];
                        } else {
                            output += ((int[]) temp.getElement())[0] + "*X^" + ((int[]) temp.getElement())[1];
                        }
                    }
                }
            }
            if (output==""){
                output+='0';
            }
            return output;
        }
        else return output;
    }
    @Override
    public String print(char poly){
        String outPut="";
        if (poly=='A'){
            outPut=fromLInkedList(A);
        }
        else if(poly=='B'){
            outPut=fromLInkedList(B);
        }
        else if(poly=='C'){
            outPut=fromLInkedList(C);
        }
        else if(poly=='R'){
            outPut=fromLInkedList(R);
        }
        return outPut;
    }
    @Override
    public void clearPolynomial(char poly){
        if (poly=='A'){
            A.clear();
        }
        else if(poly=='B'){
            B.clear();
        }
        else if(poly=='C'){
            C.clear();
        }
        else if(poly=='R'){
            R.clear();
        }
    }    @Override
    public float evaluatePolynomial(char poly, float value) {
        doubleLinkedList list1 = new doubleLinkedList();
        if(poly == 'A')
            list1=A;
        else if(poly == 'B')
            list1=B;
        else if(poly == 'C')
            list1=C;
        float sum =0;
        for(int i=0;i<list1.size();i++) {
            sum+= Math.pow(value,((int[])list1.get(i))[1])*((int[])list1.get(i))[0];
        }
        return sum;
    }
    @Override
    public int[][] add(char poly1, char poly2) {
        doubleLinkedList list1 = new doubleLinkedList();
        doubleLinkedList list2 = new doubleLinkedList();

        if(poly1 == 'A')
            list1=A;
        else if(poly1 == 'B')
            list1=B;
        else if(poly1 == 'C')
            list1=C;

        if(poly2 == 'A')
            list2=A;
        else if(poly2 == 'B')
            list2=B;
        else if(poly2 == 'C')
            list2=C;

        int size1=list1.size();
        int size2=list2.size();

        R.clear();

        for(int i=0;i<size1;i++) {
            R.add(new int[] {((int[])list1.get(i))[0],((int[])list1.get(i))[1]});
        }
        for(int i=0;i<size2;i++) {
            R.add(new int[] {((int[])list2.get(i))[0],((int[])list2.get(i))[1]});
        }
        R.sort();
        R.dublicates();
        R.removeZeroes();
        if(R.isEmpty()) {
            R.add(new int[] {0,0});
        }

        PolynomialSolver x = new PolynomialSolver();
        int[][] arr = x.doubleLinkedListToArray(R);

        return arr;
    }
    @Override
    public int[][] subtract(char poly1, char poly2) {

        doubleLinkedList list1 = new doubleLinkedList();
        doubleLinkedList list2 = new doubleLinkedList();

        if(poly1 == 'A')
            list1=A;
        else if(poly1 == 'B')
            list1=B;
        else if(poly1 == 'C')
            list1=C;

        if(poly2 == 'A')
            list2=A;
        else if(poly2 == 'B')
            list2=B;
        else if(poly2 == 'C')
            list2=C;
        int size1=list1.size();
        int size2=list2.size();


        R.clear();

        for(int i=0;i<size1;i++) {
            R.add(new int[] {((int[])list1.get(i))[0],((int[])list1.get(i))[1]});
        }
        for(int i=0;i<size2;i++) {
            R.add(new int[] {-((int[])list2.get(i))[0],((int[])list2.get(i))[1]});
        }
        R.sort();
        R.dublicates();
        R.removeZeroes();
        if(R.isEmpty()) {
            R.add(new int[] {0,0});
        }

        PolynomialSolver x = new PolynomialSolver();
        int[][] arr = x.doubleLinkedListToArray(R);


        return arr;
    }
    @Override
    public int[][] multiply(char poly1, char poly2) {
        doubleLinkedList list1 = new doubleLinkedList();
        doubleLinkedList list2 = new doubleLinkedList();

        if(poly1 == 'A')
            list1=A;
        else if(poly1 == 'B')
            list1=B;
        else if(poly1 == 'C')
            list1=C;

        if(poly2 == 'A')
            list2=A;
        else if(poly2 == 'B')
            list2=B;
        else if(poly2 == 'C')
            list2=C;
        int size1=list1.size();
        int size2=list2.size();

        R.clear();


        for(int i=0;i<size1;i++) {
            for(int j=0;j<size2;j++) {
                int [] temp1= (int[]) list1.get(i);
                int [] temp2 =(int[]) list2.get(j);
                int [] temp3= {temp1[0]*temp2[0],temp1[1]+temp2[1]};
                R.add(temp3);

            }
        }

        R.sort();
        R.dublicates();
        R.removeZeroes();
        if(R.isEmpty()) {
            R.add(new int[] {0,0});
        }
        PolynomialSolver x = new PolynomialSolver();
        int[][] arr = x.doubleLinkedListToArray(R);

        return arr;
    }
}