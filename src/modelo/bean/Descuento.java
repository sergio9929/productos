package modelo.bean;

public class Descuento {
	int id, valor;
	String descripcion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Descuento [id=" + id + ", valor=" + valor + ", descripcion=" + descripcion + "]";
	}
	
}
