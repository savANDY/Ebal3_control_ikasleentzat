package eus.azterketa.controlador;
import java.util.ArrayList;

import eus.azterketa.modelo.Clasificacion;
import eus.azterketa.modelo.Corredor;
import eus.azterketa.modelo.ModeloClasificacion;

public class ControladorClasificacion {
	
	private ModeloClasificacion modeloClasificacion;

	public ControladorClasificacion() {
		super();
		modeloClasificacion=new ModeloClasificacion();
	
	}
	
	public void insertarNueva(int idCorredor, int idEtapa, int posicion){
		
	}
	
	
public ArrayList<Clasificacion> seleccionarTodos(){
		
		ArrayList<Clasificacion> corredores; 
		
		corredores = modeloClasificacion.seleccionarTodos();
		return corredores;
		
	}
	
}
