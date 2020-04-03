package eg.edu.alexu.csd.datastructure.linkedList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    private static boolean checkBracketFrom(String input,int index){
        int count=0;
        int i=0;
        for (i=index;i<input.length();i++){
            if (!Character.isWhitespace(input.charAt(i))) {
                if (input.charAt(i)=='('){
                    if (input.charAt(i)==')'){
                        i++;
                        break;
                    }
                    else if (isNumber(Character.toString(input.charAt(i)))){
                        count++;
                    }
                }
            }
        }
        if (count==2) {
            return checkBracketFrom(input, i);
        }
        else return false;
    }
    private static boolean isNumber(String s)
    {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                if (Character.isDigit(s.charAt(i)) == false)
                    return false;
            }
        }

        return true;
    }
    private static void printMinue() {
        System.out.println("Please choose an action ");
        System.out.println("----------------------");
        System.out.println("1- Set a polynomial variable");
        System.out.println("2- Print the value of a polynomial variable");
        System.out.println("3- Add two polynomials");
        System.out.println("4- Subtract two polynomials");
        System.out.println("5- Multiply two polynomials");
        System.out.println("6- Evaluate a polynomial at some point");
        System.out.println("7- Clear a polynomial variable");
        System.out.println("8- exit");
        System.out.println("====================================================================");
    }
    private static char[] poly1_poly2(PolynomialSolver p){
        boolean theFirstIsSet=false;
        boolean theSecondIsSet=false;
        char poly1=0;
        char poly2=0;
        while (theFirstIsSet==false) {
            System.out.println("Insert first operand variable name: A, B or C ");
            Scanner scanner = new Scanner(System.in);
            poly1 = scanner.next().charAt(0);
            while (poly1 != 'A' & poly1 != 'B' & poly1 != 'C') {
                System.out.println("invalid Character");
                poly1 = scanner.next().charAt(0);
            }
            if (poly1 == 'A') {
                if (p.A.isEmpty()==true) {
                    System.out.println("Variable not set");
                } else theFirstIsSet = true;
            } else if (poly1 == 'B') {
                if (p.B.isEmpty()==true) {
                    System.out.println("Variable not set");
                } else theFirstIsSet = true;
            } else if (poly1 == 'C') {
                if (p.C.isEmpty()==true) {
                    System.out.println("Variable not set");
                } else theFirstIsSet = true;
            } else if (poly1 == 'R') {
                if (p.R.isEmpty()==true) {
                    System.out.println("Variable not set");
                } else theFirstIsSet = true;
            }
        }
        while (theSecondIsSet==false) {
            System.out.println("Insert second operand variable name: A, B or C ");
            Scanner scanner = new Scanner(System.in);
            poly2 = scanner.next().charAt(0);
            while (poly2 != 'A' & poly2 != 'B' & poly2 != 'C') {
                System.out.println("invalid Character");
                poly2 = scanner.next().charAt(0);
            }
            if (poly2 == 'A') {
                if (p.A.isEmpty()==true) {
                    System.out.println("Variable not set");
                } else theSecondIsSet = true;
            } else if (poly2 == 'B') {
                if (p.B.isEmpty()==true) {
                    System.out.println("Variable not set");
                } else theSecondIsSet = true;
            } else if (poly2 == 'C') {
                if (p.C.isEmpty()==true) {
                    System.out.println("Variable not set");
                } else theSecondIsSet = true;
            } else if (poly2 == 'R') {
                if (p.R.isEmpty()==true) {
                    System.out.println("Variable not set");
                } else theSecondIsSet = true;
            }
        }
        char[] polys=new char[2];
        polys[0]=poly1;
        polys[1]=poly2;
        return polys;
    }
    private static void applyChoice(PolynomialSolver p , int choice){
        if (choice==1){
            boolean error=true;
            while (error) {
                error=false;
                System.out.println("Insert the variable name: A, B or C");
                Scanner scanner = new Scanner(System.in);
                char poly = scanner.next().charAt(0);
                while (poly != 'A' & poly != 'B' & poly != 'C') {
                    System.out.println("invalid Character");
                    System.out.println("Insert the variable name: A, B or C");
                    poly = scanner.next().charAt(0);
                }
                System.out.println("Insert the polynomial terms in the form: ");
                System.out.println("(coeff1, exponent1), (coeff2, exponent2), .. ");
                scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                String[] splitted = input.split("[(,) ]");
                int count = 0;
                for (String split : splitted) {
                    if (!split.isEmpty()) {
                        count++;
                    }
                }
                if (count%2!=0){
                    System.out.println("the terms is not true!");
                    error=true;
                    continue;
                }
                /*if (!checkBracketFrom(input,0)){
                    System.out.println("the terms is not true!");
                    error=true;
                    continue;
                }*/
                int numOfTerms = count / 2;
                int[][] terms = new int[numOfTerms][2];
                int i = 0, j = 0;
                for (String split : splitted) {
                    if (!split.isEmpty()) {
                        if (isNumber(split)) {
                            if (j == 0) {
                                terms[i][j] = Integer.parseInt(split);
                                j++;
                            } else if (j == 1) {
                                terms[i][j] = Integer.parseInt(split);
                                j = 0;
                                i++;
                            }
                        }
                        else {
                            error = true;
                        }
                    }
                }
                if(error==false) {
                    p.setPolynomial(poly, terms);
                    System.out.println("Polynomial " + poly + "is set");
                    printMinue();
                }
                else System.out.println("the input is not valid!");
            }
        }
        else if (choice==2){
            boolean found = false;
            while (found==false) {
                System.out.println("Insert the variable name: A, B,C ,or R");
                Scanner scanner = new Scanner(System.in);
                char poly = scanner.next().charAt(0);
                while (poly != 'A' & poly != 'B' & poly != 'C'& poly != 'R') {
                    System.out.println("invalid Character");
                    poly = scanner.next().charAt(0);
                }
                if (poly == 'A') {
                    if (p.A.size() == 0) {
                        System.out.println("the polynomial is empty");
                    }
                    else {
                        System.out.println("R Value in " + poly + ":" + p.print(poly));
                        found=true;
                        printMinue();
                    }
                }
                if (poly == 'B') {
                    if (p.B.size() == 0) {
                        System.out.println("the polynomial is empty");
                    }
                    else {
                        System.out.println("R Value in " + poly + ":" + p.print(poly));
                        found=true;
                        printMinue();
                    }
                }
                if (poly == 'C') {
                    if (p.C.size() == 0) {
                        System.out.println("the polynomial is empty");
                    } else {
                        System.out.println("R Value in " + poly + ":" + p.print(poly));
                        found=true;
                        printMinue();
                    }
                }
                else if (poly == 'R') {
                    if (p.R.size() == 0) {
                        System.out.println("the polynomial is empty");
                    }
                    else {
                        System.out.println("R Value in " + poly + ":" + p.print(poly));
                        found=true;
                        printMinue();
                    }
                }
            }
        }
        else if (choice==3){
            char[] polynomials =poly1_poly2(p);
            System.out.println("Result set in R: "+ Arrays.deepToString(p.add(polynomials[0],polynomials[1])));
            printMinue();
        }
        else if (choice==4){
            char[] polynomials =poly1_poly2(p);
            System.out.println("Result set in R: "+ Arrays.deepToString(p.subtract(polynomials[0],polynomials[1])));
            printMinue();
        }
        else if (choice==5){
            char[] polynomials =poly1_poly2(p);
            System.out.println("Result set in R: "+ Arrays.deepToString(p.multiply(polynomials[0],polynomials[1])));
            printMinue();
        }
        else if (choice==6){
            System.out.println("Insert the variable name: A, B or C");
            Scanner scanner=new Scanner(System.in);
            char poly=scanner.next().charAt(0);
            boolean found=false;
            while (found==false) {
                while (poly != 'A' & poly != 'B' & poly != 'C') {
                    System.out.println("invalid Character");
                    System.out.println("Insert the variable name: A, B or C");
                    scanner=new Scanner(System.in);
                    poly = scanner.next().charAt(0);
                }
                if (poly == 'A') {
                    if (p.A.isEmpty() == true) {
                        System.out.println("Variable not set");
                        System.out.println("Insert the variable name: A, B or C");
                        scanner=new Scanner(System.in);
                        poly = scanner.next().charAt(0);
                    }
                    else found=true;
                }
                else if (poly == 'B') {
                    if (p.B.isEmpty() == true) {
                        System.out.println("Variable not set");
                        System.out.println("Insert the variable name: A, B or C");
                        scanner=new Scanner(System.in);
                        poly = scanner.next().charAt(0);
                    }
                    else found=true;
                }
                else if (poly == 'C') {
                    if (p.C.isEmpty() == true) {
                        System.out.println("Variable not set");
                        System.out.println("Insert the variable name: A, B or C");
                        scanner=new Scanner(System.in);
                        poly = scanner.next().charAt(0);
                    }
                    else found=true;
                }
                else if (poly == 'R') {
                    if (p.R.isEmpty() == true) {
                        System.out.println("Variable not set");
                        System.out.println("Insert the variable name: A, B or C");
                        scanner=new Scanner(System.in);
                        poly = scanner.next().charAt(0);
                    }
                    else found=true;
                }
            }
            scanner=new Scanner(System.in);
            System.out.println("Insert the value");
            int val= Integer.parseInt(scanner.nextLine());
            System.out.println("the evaluation of the polynomial is:"+p.evaluatePolynomial(poly,val));
            printMinue();
        }
        else if (choice==7){
            System.out.println("Insert the variable name: A, B or C");
            Scanner scanner=new Scanner(System.in);
            char poly=scanner.next().charAt(0);
            boolean found=false;
            while (found==false) {
                while (poly != 'A' & poly != 'B' & poly != 'C') {
                    System.out.println("invalid Character");
                    System.out.println("Insert the variable name: A, B or C");
                    scanner=new Scanner(System.in);
                    poly = scanner.next().charAt(0);
                }
                if (poly == 'A') {
                    if (p.A.isEmpty() == true) {
                        System.out.println("Variable is already not set");
                        System.out.println("Insert the variable name: A, B or C");
                        scanner=new Scanner(System.in);
                        poly = scanner.next().charAt(0);
                    }
                    else found=true;
                }
                else if (poly == 'B') {
                    if (p.B.isEmpty() == true) {
                        System.out.println("Variable is already not set");
                        System.out.println("Insert the variable name: A, B or C");
                        scanner=new Scanner(System.in);
                        poly = scanner.next().charAt(0);
                    }
                    else found=true;
                }
                else if (poly == 'C') {
                    if (p.C.isEmpty() == true) {
                        System.out.println("Variable is already not set");
                        System.out.println("Insert the variable name: A, B or C");
                        scanner=new Scanner(System.in);
                        poly = scanner.next().charAt(0);
                    }
                    else found=true;
                }
                else if (poly == 'R') {
                    if (p.R.isEmpty() == true) {
                        System.out.println("Variable is already not set");
                        System.out.println("Insert the variable name: A, B or C");
                        scanner=new Scanner(System.in);
                        poly = scanner.next().charAt(0);
                    }
                    else found=true;
                }
            }
            p.clearPolynomial(poly);
            System.out.println("Polynomial :"+poly+"is cleaned.");
            printMinue();
        }
        else if(choice == 8) {
        	System.out.println("END");
        	System.exit(0);
        }
    }
    public static void main(String[] args){
        printMinue();
        PolynomialSolver p = new PolynomialSolver();
        while (true) {
            int choice = 0;
            Scanner scanner=new Scanner(System.in);
            boolean taken = false;
            while (taken==false){
                scanner=new Scanner(System.in);
                choice = Integer.parseInt(scanner.nextLine());
                if (choice>0&&choice<9) {
                    taken = true;
                }
                else {
                	System.out.println("not in the menu");
                	printMinue();
                }
            }
            applyChoice(p, choice);
        }
    }
}
