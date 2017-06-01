package eus.azterketa.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ModeloEtapa   extends Conectar{

	public ModeloEtapa() {
		super();
	}
	
	
	public ArrayList<Etapa> seleccionarTodas() {
		PreparedStatement pst;
		Etapa etapa;
		ArrayList<Etapa> etapas = new ArrayList<Etapa>();

		try {
			pst = cn.prepareStatement("select * from etapa");

			ResultSet rs = pst.executeQuery();// ejecuta

			while (rs.next()) {
				etapa = new Etapa();
				etapa.setId(Integer.parseInt(rs.getString(1)));
				etapa.setKm(Integer.parseInt(rs.getString(2)));
				etapa.setSalida(rs.getString(3));
				etapa.setLlegada(rs.getString(4));
				

				etapas.add(etapa);
			}
			return etapas;

		} catch (Exception e) {
			System.out.println("No se han podido recuperar los corredores de la BBDD");
			return etapas;
		}
	}

}
