package huffmanFinal;
/**
 * @author: Alexander Narváez
 * @Practica 2: implementación del Algoritmo de Huffman -  
 */

public class Nodo {

	public String dato;
	public char letra;
	public Nodo sig;

    public Nodo(char c, String d) {
    	sig = null;
    	letra=c;
    	dato = d;
    }
}