package huffmanFinal;
/**
 * @author: Alexander Narváez
 * @Practica 2: implementación del Algoritmo de Huffman -  
 */

public class NodoArbol {

	int dato; //número de repeticiones respectivas del caracter
	char letra; //caracter
	NodoArbol der;
	NodoArbol izq;

    public NodoArbol(char c,int d) {
    	dato=d;
    	letra=c;
    	der=null;
    	izq=null;
    }
}