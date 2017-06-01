package eus.azterketa.controlador;

import java.util.ArrayList;

import eus.azterketa.modelo.Clasificacion;
import eus.azterketa.modelo.ModeloClasificacion;

public class ControladorClasificacion {

	private ModeloClasificacion modeloClasificacion;

	public ControladorClasificacion() {
		super();
		modeloClasificacion = new ModeloClasificacion();

	}

	public void insertarNueva(Clasificacion clasificacion) throws Exception {

		try {
			modeloClasificacion.insertarNueva(clasificacion);
		} catch (Exception e) {
			throw e;
		}

	}

	public ArrayList<Clasificacion> seleccionarTodos() {

		ArrayList<Clasificacion> corredores;

		corredores = modeloClasificacion.seleccionarTodos();
		return corredores;

	}

	public boolean eliminarPorIdCorredor(int idCorredor) throws Exception {

		boolean eliminado = false;
		
		try {
			eliminado = modeloClasificacion.eliminarPorIdCorredor(idCorredor);
		} catch (Exception e) {
			throw e;
		}
		
		if (eliminado) {
			return true;
		} else {
			return false;
		}
		
	}

}
