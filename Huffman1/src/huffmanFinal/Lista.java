package huffmanFinal;
/**
 * @author: Alexander Narváez
 * @Practica 2: implementación del Algoritmo de Huffman - 
 */
import java.util.Date;
import javax.swing.JOptionPane;

public class Lista {
	public Nodo inicio;

    public Lista() {
    	inicio = null;
    }

    public void recorrer(){
    	Nodo aux= inicio;
    	System.out.print("(Caracter, camino): ");
    	while (aux != null){
    		System.out.print("("+aux.letra+", "+aux.dato+"), ");
    		aux = aux.sig;
    	}
    	System.out.println("");
    }

    public int buscaElemento(char c){
    	Nodo aux= inicio;
    	int posicion=0;
    	int contador=1;

    	while (aux != null && posicion==0){
    		if (aux.letra==c){
    			posicion=contador;
    		} else {
    			aux = aux.sig;
    			contador++;
    		}
    	}
    	return posicion;
    }

    public Nodo retornaPosicion(int v){ //Retorna 0 cuando la lista está vacía, retorna 1 si se busca un elemento con una posición inexistente
    	Nodo aux= inicio;
    	Nodo elemento=null; //lista vacía
    	int contador=1;

    	while (aux != null && elemento==null){
    		if (contador==v){
    			elemento=aux;
    		} else {
    			aux = aux.sig;
    			contador++;
    		}
    	}
		return elemento;
    }

   public void insertaFinal(char c, String d){
    	Nodo nuevo = new Nodo(c, d);
    	if (inicio==null){
    		inicio=nuevo;
    	} else {
    		Nodo aux=inicio;
    		while (aux.sig!= null){
    			aux=aux.sig;
    		}

    		aux.sig=nuevo;
    	}
    }
}