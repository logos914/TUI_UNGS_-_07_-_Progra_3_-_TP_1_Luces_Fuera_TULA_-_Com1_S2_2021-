package fueraLuces.controlador;

import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JLabel;

import fueraLuces.gui.LuzLed;
import fueraLuces.gui.VentanaPrincipal;
import fueraLuces.modelo.Iluminable;
import fueraLuces.modelo.TableroLuces;
import grilla.Grilla;

public class Arbitro {

	private TableroLuces modelo;
	private VentanaPrincipal vista;
	
	public Arbitro(TableroLuces modelo, VentanaPrincipal vista) {
		this.modelo = modelo;
		this.vista = vista;
		//this.activarlaEscuchaDeEventos();
		this.poblarTableroVisual();
		
	
	}

	
	private void poblarTableroVisual() {
		
		
		vista.panelTablero.setLayout(new GridLayout(5, 5, 5, 5));
		
		
		Iterator <Iluminable> grillaVisual = this.modelo.obtenerTableroActual().iterator();
		
		while (grillaVisual.hasNext()) {
			// System.out.println("hola");
				LuzLed luz = (LuzLed) grillaVisual.next();
				vista.panelTablero.add(new JLabel(luz.obtenerEstadoVisual()));
				 
			
			// System.out.println(luz.obtenerEstado());
			}
		
		
	}


	private void activarlaEscuchaDeEventos() {
		
		
	}
	
}
