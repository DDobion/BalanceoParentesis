package pilas;

import java.util.Scanner;
import java.util.Stack;

public class BalanceoParentesis {

    public static boolean verificarBalance(String cadena) {
        Stack<Character> pila = new Stack<>();

        
        for (char simbolo : cadena.toCharArray()) {
            
            if (esApertura(simbolo)) {
                pila.push(simbolo);
                System.out.println("Se agrego: " + simbolo);
                System.out.println("Pila actual: " + pila);
            } 
            
            else if (esCierre(simbolo)) {
                
                if (pila.isEmpty()) {
                    System.out.println("Error: no hay elementos en la pila para emparejar con " + simbolo);
                    return false;
                }
                char elementoSuperior = pila.pop();
                System.out.println("Verificando correspondencia: " + elementoSuperior + " con " + simbolo);
                
                
                if (!esParCorrecto(elementoSuperior, simbolo)) {
                    System.out.println("Error: " + elementoSuperior + " no corresponde con " + simbolo);
                    return false;
                }
                System.out.println("Correcto: " + elementoSuperior + " y " + simbolo + " coinciden.");
                System.out.println("Pila actual luego de eliminar: " + pila);
            }
        }

        
        if (pila.isEmpty()) {
            System.out.println("Pila vacia al finalizar, la expresion esta correctamente balanceada.");
        } else {
            System.out.println("Pila no vacia al finalizar: " + pila);
        }

        return pila.isEmpty();
    }

   
    private static boolean esApertura(char simbolo) {
        return simbolo == '(' || simbolo == '{' || simbolo == '[';
    }

    
    private static boolean esCierre(char simbolo) {
        return simbolo == ')' || simbolo == '}' || simbolo == ']';
    }

    
    private static boolean esParCorrecto(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '{' && cierre == '}') ||
               (apertura == '[' && cierre == ']');
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        
        System.out.println("Por favor, ingrese una cadena con parentesis para verificar: ");
        String cadena = entrada.nextLine();

        
        if (verificarBalance(cadena)) {
            System.out.println("La expresion ingresada esta balanceada.");
        } else {
            System.out.println("La expresion ingresada no esta balanceada.");
        }

        entrada.close();
    }
}
