<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.Persona" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Persona</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <h2>Buscar Persona</h2>

    <!-- Formulario de búsqueda -->
    <form action="<%= request.getContextPath() %>/persona" method="get">
        <input type="hidden" name="action" value="buscar">
        Nombre: <input type="text" name="nombre" required>
        <input type="submit" value="Buscar">
    </form>

    <hr>

    <!-- Mostrar resultado si existe -->
    <%
        Persona persona = (Persona) request.getAttribute("persona");
        if (persona != null) {
    %>
        <h3>Resultado:</h3>
        <p><strong>Nombre:</strong> <%= persona.getNombre() %></p>
        <p><strong>Edad:</strong> <%= persona.getEdad() %></p>
    <%
        } else if (request.getParameter("nombre") != null) {
    %>
        <p>No se encontró persona con ese nombre.</p>
    <%
        }
    %>

    <br>
    <br><br>
    <a href="<%= request.getContextPath() %>/index.jsp">
        <button>🏠 Menú Principal</button>
    </a>

</body>
</html>

