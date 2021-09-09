package fueraLuces.modelo;

import java.util.ArrayList;
import java.util.Random;

import fueraLuces.gui.LuzLed;
import grilla.Grilla;
import grilla.ParOrdenado;

/**
 * Modelo del juego "Luces Fuera".
 * Posee:
 *  - Un tablero o grilla de filas y columnas (tamanio x tamanio) en cada celda debe haber
 * un objeto de la clase Iluminable (que tenga estado, y posibilidad de ser encendido, o apagado).
 * 
 *  - Un flag o estado general para conocer si fue terminado exitosamente (ganado).
 *  
 *  - Un contador de movimientos o jugadas realizadas
 *  
 *  - Un listado que representa los movimientos según la posición lineal de la luz en el tablero.
 *  
 * @author ignacio
 *
 */
public class TableroLuces {

	private Grilla<Iluminable> tablero;
	private boolean ganado;
	private int cantMovimientosRealizados;
	private ArrayList<Integer> listadoMovimientosRealizados;
	private double probabilidadEncendidoInicial = 0.24;
	/**
	 * Constructor de tablero genérico, puede servir para versiones de consola o de Testing.
	 * @param tamanio
	 */
	public TableroLuces (int tamanio) {
		this.ganado = false;
		this.cantMovimientosRealizados = 0;
		this.construirTablero(tamanio, new Luz());

	}
	
	/**
	 * Constructor del tablero con algún Iluminable específico, útil para una GUI 
	 * @param tamanio
	 * @param luz
	 */
	public TableroLuces (int tamanio, Iluminable luz) {
		this.ganado = false;
		this.cantMovimientosRealizados = 0;
		this.construirTablero(tamanio, luz);
	}
	
	
	/**
	 * Añade la cantidad indicada por tamanio de filas y columnas al tablero, las rellena con Iluminables apagados
	 * @param luz
	 */
	void construirTablero(int tamanio, Iluminable luz) {
		
		this.tablero = new Grilla<Iluminable>(tamanio,luz);
		
		
		for (int i = 0; i< this.tablero.getCantidadTotalDeGrillas(); i++) {
			this.RandomizarEstadoLuz(i);
		}
		
		
		
	}

	/**
	 * Sirve para elegir que luces están encendidas y cuales no, al principio de la partida.
	 * @param pos Indice del Iluminable a tratar, con respecto a su posición
	 */
	private void RandomizarEstadoLuz(int pos) {
		Random rand = new Random();
		int bolillero = rand.nextInt(100);
		
		if ( bolillero <= (int) (this.probabilidadEncendidoInicial * 100)) {		
			this.NuevaLuzEnPos(pos, true);
		} else {
			this.NuevaLuzEnPos(pos, false);
		}
		
		
		
		
	}
	
	
	private void NuevaLuzEnPos(int pos, boolean valor) {
		ParOrdenado<Integer,Integer> XY = this.tablero.getFilColDesdePos(pos);
		
		int fila = XY.GetX();
		int columna = XY.GetY();
		
		LuzLed nueva = new LuzLed();
	
		if (valor) {
			nueva.encender();
		}
		
		this.tablero.setValor(fila, columna, nueva);
	}
	
	
	private void ConmutarLuzEnPos(int pos) {
		
		ParOrdenado<Integer,Integer> XY = this.tablero.getFilColDesdePos(pos);
		
		int fila = XY.GetX();
		int columna = XY.GetY();
		
		LuzLed luzActual = (LuzLed) this.tablero.getValor(fila, columna);
		
		luzActual.conmutar();
		
		this.tablero.setValor(fila, columna, luzActual);
		
		
		
	}
	
	
	
	
	
	public Grilla<Iluminable> obtenerTableroActual() {
		return this.tablero;
	}
	
	
}
