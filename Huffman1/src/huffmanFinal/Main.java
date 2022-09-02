package huffmanFinal;
/**
  * @author: Alexander Narváez:
 * @Practica 2: implementación del Algoritmo de Huffman -  
 */
import javax.swing.*;
import java.io.*;

public class Main {
static double ratio; static int original; static int comprimido;
    public static void main (String args[]) {

    	//Pedimos la cadena a convertir
    	String cadena= JOptionPane.showInputDialog(null, "Escribe la cadena de texto:");

    	//Buscamos caracteres repetidos
    	ListaArbol caracteres= new ListaArbol(); //creamos la lista que almacenará los caracteres de la cadena
		caracteres.agregaCadena(cadena); //descomponemos la cadena de texto en caracteres
		caracteres.recorrer(); //vemos los caracteres de la cadena ingresada

		//unimos todos los árboles y generamos el árbol que nos ayudará a encontrar el código Huffman
		caracteres.generarArbol();

		//recorremos el árbol generado que nos ayudará a encontrar el código Huffman
		caracteres.recorrer();

		//Obtenemos el árbol que nos ayudará a encontrar el código Huffman
		Arbol arbol=caracteres.retornaPosicion(1);

		//Buscamos los caminos de cada caracter en el árbol
		arbol.camino("", arbol.raiz);

		//Imprimimos los caminos
		Lista caminos= arbol.getCaminos();
		caminos.recorrer();

		//Cambiamos cada caracter de la frase por el camino que lo representa
		String cambio=arbol.fraseAcaminos(cadena, caminos);
		System.out.println(cambio);
                
                 original=cadena.length()*8;
                comprimido=cadena.length();
                ratio=original/comprimido;
                System.out.println("ratio: " + ratio);
    }
}