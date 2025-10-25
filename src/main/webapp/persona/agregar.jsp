<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Persona</title>
</head>
<body>
    <h2>Agregar Persona</h2>

    <form action="<%= request.getContextPath() %>/persona" method="post">
        Nombre: <input type="text" name="nombre" required><br><br>
        Edad: <input type="number" name="edad" required><br><br>
        <input type="submit" value="Agregar Persona">
    </form>

    <br>
    <br><br>
    <a href="<%= request.getContextPath() %>/index.jsp">
        <button>🏠 Menú Principal</button>
    </a>
</body>
</html>
