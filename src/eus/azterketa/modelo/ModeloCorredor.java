package eus.azterketa.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import eus.azterketa.modelo.Conectar;

public class ModeloCorredor extends Conectar{

	public ModeloCorredor() {
		super();
	}

	public ArrayList<Corredor> seleccionarTodos() {
		PreparedStatement pst;
		Corredor corredor;
		ArrayList<Corredor> corredores = new ArrayList<Corredor>();

		try {
			pst = cn.prepareStatement("select * from corredor");

			ResultSet rs = pst.executeQuery();// ejecuta

			while (rs.next()) {
				corredor = new Corredor();
				corredor.setId(Integer.parseInt(rs.getString(1)));
				corredor.setNombre(rs.getString(2));
				corredor.setApellido(rs.getString(3));
				corredor.setNombre_grupo(rs.getString(4));
				

				corredores.add(corredor);
			}
			return corredores;

		} catch (Exception e) {
			//System.out.println("No se han podido recuperar los corredores de la BBDD");
			return corredores;
		}
	}

	public int buscarIdPorNombreApellido(String nombreCorredor, String apellidoCorredor) throws Exception {

			PreparedStatement ps;
			int idCorredor = 0;
			try {
				ps = cn.prepareStatement("SELECT id FROM corredor WHERE nombre like ? AND apellido like ?");
				ps.setString(1, nombreCorredor);
				ps.setString(2, apellidoCorredor);

			//	System.out.println(ps);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					idCorredor = rs.getInt("id");
					return idCorredor;
				}
			} catch (Exception e) {
				throw e;
			}
			return idCorredor;
		
	}

public boolean borrarPorId(int idCorredor) throws Exception {
		
	boolean corredorBorrado = false;
		try {
			PreparedStatement pst = cn.prepareStatement("DELETE FROM corredor WHERE id = ?");
			pst.setInt(1, idCorredor);
			
			//System.out.println(pst);
			
			pst.execute();

			if (pst.getUpdateCount() == 0) {// no ha borrado nada
				//System.out.println("Se ha intentado borrar el corredor (id:" + idCorredor + ") pero... sin resultados");
				corredorBorrado = false;
			} else {
				//System.out.println("Corredor con id " + idCorredor + " borrado de la BBDD");
				corredorBorrado = true;
			}

		} catch (Exception e) {
			
			throw e;
		}
		if (corredorBorrado){
			return true;
		} else {
			return false;
		}
	}
	
	
}
