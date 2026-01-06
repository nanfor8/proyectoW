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

    <div class="section">

    <% if (request.getAttribute("persona") != null) { %>
        <div class="result-box">
            <h3>✨ Resultado encontrado</h3>
    
            <div class="result-item">
                👤 Nombre: ${persona.nombre}
            </div>
    
            <div class="result-item">
                🎂 Edad: ${persona.edad}
            </div>
        </div>
    <% } else if (request.getParameter("nombre") != null) { %>
        <div class="result-empty">
            ❌ No se encontró la persona
        </div>
    <% } %>
    
    </div>
    
    <a class="menu-btn" href="<%= request.getContextPath() %>/index.jsp">
        🏠 Menú Principal
    </a>

</body>
</html>

