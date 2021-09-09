package grilla;

public class ParOrdenado<T1,T2> {

	T1 X;
	T2 Y;
	
	public ParOrdenado (T1 X, T2 Y) {
		this.Set(X, Y);
	}
	
	
	public void Set(T1 X, T2 Y) {
		this.SetX(X);
		this.SetY(Y);
	}
	
	public void SetX(T1 X) {
		this.X = X;
	}
	
	public void SetY(T2 Y) {
		this.Y = Y;
	}
	
	public T1 GetX() {
		return this.X;
	}
	
	public T2 GetY() {
		return this.Y;
	}
	
	
}
