package huffmanFinal;
/**
 * @author: Alexander Narváez
 * @Practica 2: implementación del Algoritmo de Huffman - 
 */
import java.util.Date;
import javax.swing.JOptionPane;

public class ListaArbol {
	public Arbol inicio;
	public int cont;

    public ListaArbol() {
    	inicio = null;
    	cont=0;
    }

    public boolean eliminaPosicion(int posicion){
    	Arbol aux= inicio;
    	Arbol ant=null;
    	boolean eliminado=false;
    	if(aux!=null){
    		int contador=0;
    		while (aux!=null){
    			contador++;

    			if (contador==posicion){
    				if (ant==null){
    					inicio=aux.sig;
    					aux.sig=null;
    					aux=null;
    				} else {
    					ant.sig=aux.sig;
    					aux.sig=null;
    					aux=null;
    				}
    				eliminado=true;
    				cont--;
    			} else {
    				ant=aux;
    				aux=aux.sig;
    			}

    		}
    	}
    	return eliminado;
    }


    public void recorrer(){ //Recorre la lista de árboles
    	Arbol aux= inicio;
    	int contador=1;
    	System.out.print("Lista: \n");
    	while (aux != null){
    		System.out.print("Nodo: "+String.valueOf(contador));
    		aux.preorden(aux.raiz);
    		aux = aux.sig;
    		contador++;
    	}
    	System.out.println("");
    }

    public void insertarOrdenada (Arbol nuevo){ //inserta ordenadamente un árbol en función del número número de repeticiones de la letra que contiene
    	if (inicio==null){ //Si no hay ningún elemento, se inserta en la raíz
    		inicio=nuevo;
    	} else {
    		Arbol aux=inicio;
    		Arbol anterior= null;
    		while ((aux!=null)&&(nuevo.raiz.dato>=aux.raiz.dato)){ //mientras no se llegue al final y el valor nuevo sea menor al valor de aux
    			anterior=aux;
    			aux=aux.sig;
    		}
    		if (anterior==null){ //si estamos en la raíz
    			nuevo.sig=inicio;
    			inicio=nuevo;
    		} else {
    			anterior.sig=nuevo;
    			nuevo.sig=aux;
    		}
    	}
    	cont++;
    }


	public void generarArbol(){
		while (getTamanio()>1){//mientras haya al menos 2 árboles, es posible hacer un solo árbol
			Arbol union= unir(retornaPosicion(1), retornaPosicion(2)); //Unimos los dos primeros árboles, que son los de menor tamaño
			insertarOrdenada(union); //insertamos ordenadamente la unión de los árboles tomados
			eliminaPosicion(1); //eliminamos el primer árbol
			if(getTamanio()!=1){ //si hay más de un árbol, lo eliminamos el primero (que es el segundo tomado, ya que ya se eliminó el primero)
				eliminaPosicion(1);
			}
		}
	}

	public int getTamanio(){ //obtenemos el número de árboles almacenados en la lista
		return cont;
	}

    public Arbol unir(Arbol uno, Arbol dos){ //unimos dos árboles
    	Arbol union= new Arbol('\u0000', uno.raiz.dato+dos.raiz.dato); //'\u0000' es caracter nulo
    	union.raiz.izq=uno.raiz; //apuntamos a la izquierda del árbol nuevo al primer árbol
    	union.raiz.der=dos.raiz; //apuntamos por derecha del árbol nuevo al segundo árbol
    	System.out.print("Ramas: "); //Señalamos que se imprimirá una unión
    	union.preorden(union.raiz); //imprimimos la unión creada
    	System.out.println("");

    	return union;
    }


    public int buscaElemento(char c){ //Retorna la posición del caracter a buscar en la lista de árboles
    	Arbol aux= inicio;
    	int posicion=0;
    	int contador=1;

    	while (aux != null && posicion==0){ //mientras no se llegue al final de la lista y no se haya encontrado el elemento, seguimos buscando
    		if (aux.raiz.letra==c){ //si encontramos la letra en la lista
    			posicion=contador; //guardamos la posición en la que se encuentra la letra
    		} else {
    			aux = aux.sig;
    			contador++;
    		}
    	}
    	return posicion;
    }

    public void agregaCadena(String cadena){ //Función que agrega cada caracter de una cadena de texto a un árbol nuevo
    	System.out.println("Cadena original: "+cadena);
    	for(int i=0; i<cadena.length(); i++){ //buscamos caracter por caracter en la cadena
			if(buscaElemento(cadena.charAt(i))==0){//Si no está el elemento en la lista es nuevo y se debe agregar
				int contador=0;
				for (int j=0; j<cadena.length(); j++){
					if(cadena.charAt(j)==cadena.charAt(i)){ //se repite el caracter
						contador++; //contamos el número de repeticiones del caracter
					}
				}
				Arbol nuevo= new Arbol(cadena.charAt(i), contador);
				insertarOrdenada(nuevo); //insertamos el árbol nuevo a la lista
			}
    	}
    }

    public Arbol retornaPosicion(int v){ //Retorna 0 cuando la lista está vacía, retorna 1 si se busca un elemento con una posición inexistente
    	Arbol aux= inicio;
    	Arbol elemento=null; //lista vacía
    	int contador=1;

    	while (aux != null && elemento==null){ //mientras no se llegue al final de la lista y no se haya encontrado el elemento
    		if (contador==v){ //si encontramos la posición
    			elemento=aux;
    		} else { //si no encontramos la posición señalada, seguimos buscando
    			aux = aux.sig;
    			contador++;
    		}
    	}
		return elemento;
    }
}