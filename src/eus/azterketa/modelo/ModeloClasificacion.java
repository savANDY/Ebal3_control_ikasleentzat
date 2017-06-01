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
		//	System.out.println("No se han podido recuperar los corredores de la BBDD");
			return clasificaciones;
		}
	}

	public void insertarNueva(Clasificacion clasificacion) throws Exception{
			try {

				PreparedStatement pst = cn.prepareStatement("INSERT INTO clasificacion (id_corredor, id_etapa, posicion) VALUES (?,?,?)");

				pst.setInt(1, clasificacion.getId_corredor());
				pst.setInt(2, clasificacion.getId_etapa());
				pst.setInt(3, clasificacion.getPosicion());

				pst.execute();
				
			} catch (Exception e) {
				throw (e);

			}
		}

	public boolean eliminarPorIdCorredor(int idCorredor) throws Exception {
		try {
			PreparedStatement pst = cn.prepareStatement("DELETE FROM clasificacion WHERE id_corredor = ?");
			pst.setInt(1, idCorredor);
			pst.execute();// ejecuta

			if (pst.getUpdateCount() == 0) {// no a borrado nada
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			throw e;
		}
	}
}
