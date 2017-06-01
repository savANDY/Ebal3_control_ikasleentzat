package eus.azterketa.modelo;

public class Etapa {
	
	private int id;
	private int km;
	private String Salida;
	private String Llegada;
	

	
	public Etapa() {
		super();
	}



	public Etapa(int id, int km, String pueblo_salida, String pueblo_llegada) {
		super();
		this.id = id;
		this.km = km;
		this.Salida = pueblo_salida;
		this.Llegada = pueblo_llegada;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getKm() {
		return km;
	}



	public void setKm(int km) {
		this.km = km;
	}



	public String getSalida() {
		return Salida;
	}



	public void setSalida(String pueblo_salida) {
		this.Salida = pueblo_salida;
	}



	public String getLlegada() {
		return Llegada;
	}



	public void setLlegada(String pueblo_llegada) {
		this.Llegada = pueblo_llegada;
	}
	
	
	
	

}
