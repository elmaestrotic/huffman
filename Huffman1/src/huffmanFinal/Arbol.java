package huffmanFinal;
/**
 * @author: Alexander Narváez
 * @Practica 2: implementación del Algoritmo de Huffman - 
 */
//import java.lang.Math;

public class Arbol {

	public NodoArbol raiz;
	public Arbol sig;
	public String re; //Variable auxiliar que nos ayuda a encontrar el camino de cada caracter
	public Lista camino; //lista que almacena los caminos de cada caracter

    public Arbol(char c, int v) { //Constructor que define la raíz del árbol
    	raiz=new NodoArbol(c, v);
    	sig=null;
    	re="";
    	camino= new Lista();
    }

	public String eliminarUltimo(String re){ //elimina el último caracter de una cadena
		String cadena="";
		for (int i=0; i<re.length()-1; i++){
	    	cadena+=re.charAt(i);
	    }
	    return cadena;
	}

 	public void camino(String c, NodoArbol r){//como parámetro se envía la raíz
 		re+=c;
    	if (r!=null){
    		if(r.letra!='\u0000'){ //si es una letra
    			camino.insertaFinal(r.letra, re); //almacenamos la letra con su respectivo camino
    		}
    		camino("0", r.izq); //anotamos que se está recorriendo hacia la izquierda
			if(r.izq!=null){ //si no es un nodo hoja
				re=eliminarUltimo(re); //eliminamos el último camino por el que se pasó
			}
    		camino("1", r.der); //anotamos que se está recorriendo hacia la derecha
    		if(r.der!=null){ //si no es un nodo hoja
	    		re=eliminarUltimo(re);  //eliminamos el último camino por el que se pasó
			}
    	} else {
    		re=eliminarUltimo(re); //eliminamos el último camino por el que se pasó
    	}
    }

    public Lista getCaminos(){ //retornamos la lista que contiene los caminos de cada caracter
    	return camino;
    }


    public String fraseAcaminos(String frase, Lista caminos){ //Método que sustituye los caminos de cada caracter en la frase
    	String cadena="";
    	for(int i=0; i<frase.length(); i++){ //recorremos cada caracter de la frase
    		Nodo nodo= caminos.retornaPosicion(caminos.buscaElemento(frase.charAt(i))); //almacenamos en un nodo el camino que corresponde según la cadena
			cadena+=nodo.dato+""; //concatenamos los caminos de acuerdo a la cadena
    	}
    	return cadena;
    }


    public void preorden(NodoArbol r){//como parámetro se envía la raíz
    	if (r!=null){
    		System.out.print("("+r.letra+", "+r.dato+"),");
    		preorden(r.izq);
    		preorden(r.der);
    	}
  
    
        
    }
}