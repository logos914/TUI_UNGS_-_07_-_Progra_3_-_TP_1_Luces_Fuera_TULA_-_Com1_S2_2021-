package fueraLuces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fueraLuces.controlador.Arbitro;
import fueraLuces.gui.LuzLed;
import fueraLuces.gui.VentanaPrincipal;
import fueraLuces.modelo.TableroLuces;

public class juego {

	

	public static void main(String[] args) {
		
		VentanaPrincipal interfaceGrafica = new VentanaPrincipal();
		TableroLuces modelo = new TableroLuces(5,new LuzLed());
		 
		Arbitro controlador = new Arbitro(modelo, interfaceGrafica);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceGrafica.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
