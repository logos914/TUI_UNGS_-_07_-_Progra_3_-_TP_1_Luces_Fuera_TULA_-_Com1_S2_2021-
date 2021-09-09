package fueraLuces.gui;

import javax.swing.ImageIcon;

import fueraLuces.modelo.Iluminable;
import fueraLuces.modelo.Luz;

public class LuzLed implements Iluminable {
	
	public ImageIcon ledApagado;
	public ImageIcon ledEncendido;
	public Luz luz;
	
	public LuzLed() {
		this.ledApagado = new ImageIcon(getClass().getResource("assets/led-apagado.png"));
		this.ledEncendido = new ImageIcon(getClass().getResource("assets/led-encendido.png"));
		this.luz = new Luz();;
	}
	
	
	public ImageIcon getLed() {
		return (this.luz.obtenerEstado()) ? this.ledEncendido : this.ledApagado;
	}


	@Override
	public void encender() {
		this.luz.encender();
	}


	@Override
	public void apagar() {
		this.luz.apagar();
	}


	@Override
	public boolean obtenerEstado() {
		return this.luz.obtenerEstado();
	}
	
	
	public ImageIcon obtenerEstadoVisual() {
		if (this.obtenerEstado()) {
			return this.ledEncendido;
		} else {
			return this.ledApagado;
		}
	}


	@Override
	public void conmutar() {
		this.luz.conmutar();
	}
	
	

}
