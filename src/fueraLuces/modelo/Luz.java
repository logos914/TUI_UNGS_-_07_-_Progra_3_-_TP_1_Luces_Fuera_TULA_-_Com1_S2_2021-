package fueraLuces.modelo;

/**
 * Representa una luz, que puede estar encendida o apagada
 * @apiNote Si es completamente innecesario, porque se puede representar con un simple bool, 
 * pero es innegable que queda más lindo poder decir encender() o apagar().
 * @author ignacio
 *
 */
public class Luz implements Iluminable {

	private boolean estado;
	
	
	
	public Luz() {
		this.estado = false;
	}
	
	@Override
	public void encender() {
		this.estado = true;
		
	}
	
	@Override
	
	public void apagar() {
		this.estado = false;
	}
	
	@Override
	public void conmutar() {
		this.estado = !estado;
	}
	
	@Override
	public boolean obtenerEstado() {
		return this.estado;
	}
	
	@Override
	public String toString() {
		return (this.estado) ? "1" :  "0";
	}
	
}
	
