package eus.azterketa.controlador;
import java.util.ArrayList;

import eus.azterketa.modelo.*;

public class ControladorEtapa {
	
	private ModeloEtapa modeloEtapa;

	public ControladorEtapa() {
		super();
		modeloEtapa=new ModeloEtapa();

	}
	
public ArrayList<Etapa> seleccionarTodas(){
		
		ArrayList<Etapa> etapas; 
		
		etapas = modeloEtapa.seleccionarTodas();
		return etapas;
		
	}
	
}
