<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menú Principal</title>
</head>
<body>
    <h1>Menú Principal</h1>
    <ul>
        <li><a href="<%= request.getContextPath() %>/persona/agregar.jsp">Agregar Persona</a></li>
        <li><a href="<%= request.getContextPath() %>/persona/buscar.jsp">Buscar Persona</a></li>
        <li><a href="<%= request.getContextPath() %>/persona/actualizar.jsp">Actualizar Edad</a></li>
        <li><a href="<%= request.getContextPath() %>/persona/eliminar.jsp">Eliminar Persona</a></li>
        <li><a href="<%= request.getContextPath() %>/persona?action=listar">Listar Personas</a></li>
    </ul>
</body>
</html>

