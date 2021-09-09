package grilla;

import java.util.ArrayList;
import java.util.Iterator;

import fueraLuces.modelo.Iluminable;

/**
 * Este tipo de dato representa una grilla (filas y columnas) cuyas celdas c
 * ontienen valores de un mismo tipo. La grilla es cuadrada(misma cantidad de
 * columnas o que filas).
 * 
 * @author ignacio
 * @param <T1> El valor o tipo de dato a resguardar en cada celda
 */
public class Grilla<T1> implements Iterable<T1> {

	protected ArrayList<ArrayList<T1>> celdas;
	protected int tamanio;
	protected int cantTotalDeGrillas;

	/**
	 * Constructor del TAD grilla.
	 * 
	 * @param tamanio       Cantidad de filas y/o de columnas
	 * @param valorDefecto El valor nulo o vacío, o por defecto que deberá tener la
	 *                     grilla, luego podrá ser cambiado (por ej, para valores
	 *                     numéricos el vacío es 0, para cadenas "", etc).
	 */
	public Grilla(int tamanio, T1 valorDefecto) {

		this.celdas = new ArrayList<ArrayList<T1>>();
		this.tamanio = tamanio;
		this.cantTotalDeGrillas = tamanio * tamanio;
		

		for (int fil = 0; fil < tamanio; fil++) {

			ArrayList<T1> columnaConValoresPorDefecto = new ArrayList<T1>();

			for (int col = 0; col < tamanio; col++) {
				columnaConValoresPorDefecto.add(valorDefecto);
			}

			this.celdas.add(columnaConValoresPorDefecto);
		}

	}

	/**
	 * Obtiene el valor almacenado en la posición (fil,col)
	 * 
	 * @param fil Indice de la posición respecto a la FILA
	 * @param col Indice de la posición respecto a la COLUMNA
	 * @return El valor de dicha posición
	 */
	public T1 getValor(int fil, int col) {

		return this.celdas.get(fil).get(col);

	}

	/**
	 * Cambia el valor de una posición
	 * 
	 * @param fil   Indice de la posición respecto a la FILA
	 * @param col   Indice de la posición respecto a la COLUMNA
	 * @param valor Valor a modificar
	 */

	public void setValor(int fil, int col, T1 valor) throws IndexOutOfBoundsException {

		if (this.indicesNegativos(fil, col)) {
			throw new IndexOutOfBoundsException(
					"El índice de la fila o columna no puede ser negativo: (" + fil + "," + col + ")");
		} else if (this.indiceFilaIgualMayorQueGrilla(fil)) {
			throw new IndexOutOfBoundsException(
					"El índice de la fila no puede ser igual o mayor al tamaño actual de la grilla: (" + fil + ")");
		} else if (this.indiceColumnaIgualMayorQueGrilla(fil, col)) {
			throw new IndexOutOfBoundsException(
					"El índice de la columna no puede ser igual o mayor al tamaño actual de la grilla: (" + col + ")");
		} else {

			ArrayList<T1> filaParaModificar = this.celdas.get(fil);
			filaParaModificar.set(col, valor);
			this.celdas.set(fil, filaParaModificar);
		}
	}

	/**
	 * Evalúa si los indices de fila y columna de parámetros son negativos
	 * 
	 * @param fil Posición de Fila
	 * @param col Posición de Columna
	 * @return Verdadero en caso de que sean negativos (índice inválido)
	 */
	public boolean indicesNegativos(int fil, int col) {
		return (fil < 0 || col < 0) ? true : false;
	}

	/**
	 * Evalúa si el índice desborda la cantidad de filas
	 * 
	 * @param fil Posición de Fila
	 * @return Verdadero en caso de que sea inválido
	 */
	public boolean indiceFilaIgualMayorQueGrilla(int fil) {
		return (fil >= this.celdas.size()) ? true : false;
	}

	/**
	 * Evalúa si el índice desborda la cantidad de columnas
	 * 
	 * @param fil Posición de Fila
	 * @param col Posición de Columna
	 * @return Verdadero en caso de que sea inválido
	 */
	public boolean indiceColumnaIgualMayorQueGrilla(int fil, int col) {
		return (col >= this.celdas.get(fil).size()) ? true : false;
	}

	/**
	 * Obtener todos los valores de una fila
	 * 
	 * @param fil La fila que se quiere obtener
	 * @return Un ArrayList con los valores de dicha fila
	 */
	public ArrayList<T1> getValoresFila(int fil) {
		return this.celdas.get(fil);

	}

	/**
	 * Obtener todos los valores de una columna
	 * 
	 * @param col La Columna que se quiere obtener
	 * @return Un ArrayList con los valores de dicha columna
	 */
	public ArrayList<T1> getValoresColumna(int col) {

		ArrayList<T1> columna = new ArrayList<T1>();

		for (int i = 0; i < this.celdas.size(); i++) {

			columna.add(this.celdas.get(i).get(col));

		}

		return columna;
	}

	/**
	 * Obtener todos los valores de la grilla de forma "serial", como una única
	 * colección lineal. Leyendo los valores "de izquierda a derecha" y de "arriba a
	 * abajo"
	 * 
	 * @return Un ArrayList con los valores de toda la grilla
	 */
	public ArrayList<T1> getValoresSerializados() {

		ArrayList<T1> resultadoSerializado = new ArrayList<T1>();

		for (int i = 0; i < this.celdas.size(); i++) {

			resultadoSerializado.addAll(this.getValoresColumna(i));

		}
		return resultadoSerializado;
	}
	
	
	public ParOrdenado<Integer,Integer> getFilColDesdePos(int pos) {
		System.out.println("Pidieron la pos: " + pos);
		System.out.println("de un tablero: " + this.tamanio + " x " + this.tamanio);
		
		Integer fila = (int) pos / this.celdas.size();
		System.out.println("fila: " + fila);
		Integer columna = (int) pos % this.getValoresColumna(fila).size();
		System.out.println("col: " + columna);
		return new ParOrdenado<Integer,Integer>(fila,columna);
	
		
	}
	
	public int getCantidadTotalDeGrillas() {
		return this.cantTotalDeGrillas;
	}
	
	
	public Iterator<T1> iterator() {
		Iterator iterador = new IteradorDeGrilla();
		return iterador;
	}
	
	
	
	protected class IteradorDeGrilla implements Iterator<T1> {

		protected int posicionActualDeGrilla;
		
		public IteradorDeGrilla() {
			this.posicionActualDeGrilla = 0;
		}
		
		
		@Override
		public boolean hasNext() {
		
			if (this.posicionActualDeGrilla < cantTotalDeGrillas ) {
				return true;
			} else {
				return false;
			}
			
			
		}

		@Override
		public T1 next() {
			
			ParOrdenado<Integer,Integer> XY = getFilColDesdePos(this.posicionActualDeGrilla);
			int fila = XY.GetX();
			int columna = XY.GetY();
			T1 celda = getValor(fila, columna);
			
			this.posicionActualDeGrilla++;
			return celda;
		}
		
		public int posicionActual() {
			return this.posicionActualDeGrilla;
		}
		
	}
	
	
	
	

	
	
	
	public int getTamanio() {
		return this.tamanio;
	}
	
	

	
}
