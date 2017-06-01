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
			System.out.println("No se han podido recuperar los corredores de la BBDD");
			return corredores;
		}
	}
	
	
}
