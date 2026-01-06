<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Actualizar Edad</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <h2>Actualizar Edad de Persona</h2>

    <form action="<%= request.getContextPath() %>/persona" method="post">
        <input type="hidden" name="action" value="actualizar">
        Nombre: <input type="text" name="nombre" required><br><br>
        Nueva Edad: <input type="number" name="edad" required><br><br>
        <input type="submit" value="Actualizar Edad">
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
