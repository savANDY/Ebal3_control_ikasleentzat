<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminando corredor</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
</head>
<body>

	<%@ page import="eus.azterketa.controlador.*"%>
	<%@ page import="eus.azterketa.modelo.*"%>

	<div class="container">
		<br> <br>
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h1>Eliminar corredor</h1>
					<h6>El corredor ha sido sancionado por dopping y queda fuera
						de la carrera. Se borra el corredor y todas sus clasificaciones.</h6>
				</div>
			</div>
		</div>

		<%
			ControladorCorredor controladorCorredor;
			controladorCorredor = new ControladorCorredor();

			ControladorClasificacion controladorClasificacion;
			controladorClasificacion = new ControladorClasificacion();

			Corredor corredor = new Corredor();
			boolean insertadoBien = false;
			boolean jugadorEncontrado = false;

			if (request.getParameter("nombreApellido") != null) {
				String nombreApellidoCorredor = request.getParameter("nombreApellido");
				String nombreCorredor = "";
				String apellidoCorredor = "";

				try {
					nombreCorredor = nombreApellidoCorredor.substring(0, nombreApellidoCorredor.indexOf(","));
					apellidoCorredor = nombreApellidoCorredor.substring(nombreApellidoCorredor.indexOf(",") + 1);
					insertadoBien = true;
				} catch (Exception e) {
		%>
		<div class="alert alert-danger">
			<strong>¡Atención!</strong>No ha ocurrido nada. No has insertado bien
			el Nombre y Apellido separado por coma (,).
		</div>
		<%
			}

				if (insertadoBien) {
					corredor.setNombre(nombreCorredor);
					corredor.setApellido(apellidoCorredor);

					int idCorredor = 0;

					try {
						idCorredor = controladorCorredor.buscarIdPorNombreApellido(nombreCorredor, apellidoCorredor);
						jugadorEncontrado = true;
					} catch (Exception e) {
		%>
		<div class="alert alert-danger">
			<strong>¡Atención!</strong>No se ha encontrado ningun jugador con ese
			nombre y apellido.
		</div>
		<%
			}

					if (jugadorEncontrado) {
						
						boolean clasificacionEliminada = false;
						try {
							clasificacionEliminada = controladorClasificacion.eliminarPorIdCorredor(idCorredor);
							if (clasificacionEliminada){
								%>
								<div class="alert alert-success">
									<strong>Clasificacion </strong> del jugador borrada con exito.
								</div>
								<%
							}
						} catch (Exception e) {
		%>
		<div class="alert alert-danger">
			<strong>¡Atención!</strong>No se han podido borrar las
			clasificaciones del Corredor.
		</div>
		<%
			}
						boolean corredorEliminado = controladorCorredor.eliminar(corredor);
						
						if (!corredorEliminado){
							%>
							<div class="alert alert-danger">
								<strong>¡Atención!</strong>No se han encontrado ningun corredor con ese nombre y apellido.
							</div>
							<%
						} else {
							%>
							<div class="alert alert-success">
								<strong>Corredor</strong> borrado con exito.
							</div>
							<%
						}
						
					}
				}
		%>

		<a href="eliminarCorredor.jsp" class="btn btn-default" role="button">Volver</a>

	</div>

	<%
		} else {
	%>

	<div class="alert alert-danger">
		<strong>¡Atención!</strong>No ha ocurrido nada. ¡No has insertado
		nada!
	</div>
	<a href="eliminarCorredor.jsp" class="btn btn-default" role="button">Volver</a>



	<%
		}
	%>


</body>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</html>