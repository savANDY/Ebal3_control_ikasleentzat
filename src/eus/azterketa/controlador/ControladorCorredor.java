package eus.azterketa.controlador;

import java.util.ArrayList;

import eus.azterketa.modelo.*;

public class ControladorCorredor {

	private ModeloCorredor modeloCorredor;

	public ControladorCorredor() {
		super();
		modeloCorredor = new ModeloCorredor();

	}

	
	public ArrayList<Corredor> seleccionarTodos(){
		
		ArrayList<Corredor> corredores; 
		
		corredores = modeloCorredor.seleccionarTodos();
		return corredores;
		
	}
	
}