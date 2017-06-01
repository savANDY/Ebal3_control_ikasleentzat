package eus.azterketa.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ModeloClasificacion extends Conectar{
	
	public ModeloClasificacion() {
		super();
	}

	public ArrayList<Clasificacion> seleccionarTodos() {
		PreparedStatement pst;
		Clasificacion clasificacion;
		ArrayList<Clasificacion> clasificaciones = new ArrayList<Clasificacion>();

		try {
			pst = cn.prepareStatement("select * from clasificacion");

			ResultSet rs = pst.executeQuery();// ejecuta

			while (rs.next()) {
				clasificacion = new Clasificacion();
				clasificacion.setId_corredor(Integer.parseInt(rs.getString(1)));
				clasificacion.setId_etapa(Integer.parseInt(rs.getString(2)));
				clasificacion.setPosicion(Integer.parseInt(rs.getString(3)));
				
				clasificaciones.add(clasificacion);
			}
			return clasificaciones;

		} catch (Exception e) {
			System.out.println("No se han podido recuperar los corredores de la BBDD");
			return clasificaciones;
		}
	}
}
