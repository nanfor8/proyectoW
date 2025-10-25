<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Eliminar Persona</title>
</head>
<body>
    <h2>Eliminar Persona</h2>

    <form action="<%= request.getContextPath() %>/persona" method="post">
        <input type="hidden" name="action" value="eliminar">
        Nombre: <input type="text" name="nombre" required><br><br>
        <input type="submit" value="Eliminar Persona">
    </form>

    <hr>

    <%
        String mensaje = (String) request.getAttribute("mensaje");
        if (mensaje != null) {
    %>
        <p><strong><%= mensaje %></strong></p>
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
