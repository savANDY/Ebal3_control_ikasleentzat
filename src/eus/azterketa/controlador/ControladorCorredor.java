package eus.azterketa.controlador;

import java.util.ArrayList;

import eus.azterketa.modelo.*;

public class ControladorCorredor {

	private ModeloCorredor modeloCorredor;

	public ControladorCorredor() {
		super();
		modeloCorredor = new ModeloCorredor();

	}

	public ArrayList<Corredor> seleccionarTodos() {

		ArrayList<Corredor> corredores;

		corredores = modeloCorredor.seleccionarTodos();
		return corredores;

	}

	public int buscarIdPorNombreApellido(String nombre, String apellido) throws Exception {
		int id;
		try {
			id = modeloCorredor.buscarIdPorNombreApellido(nombre, apellido);
			return id;
		} catch (Exception e) {
			throw e;
		}
		
	}

	public boolean eliminar(Corredor corredor) throws Exception {

		String nombreCorredor = corredor.getNombre();
		String apellidoCorredor = corredor.getApellido();

		int idCorredor = modeloCorredor.buscarIdPorNombreApellido(nombreCorredor, apellidoCorredor);
		
		if (idCorredor == 0){
			return false;
		}

		System.out.println(idCorredor);
		boolean corredorBorrado = modeloCorredor.borrarPorId(idCorredor);

		if (corredorBorrado){
			return true;
		} else {
			return false;
		}
		
		
	}

}