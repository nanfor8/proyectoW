<%@ page import="model.Persona" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <title>Lista Persona</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<table border="1">
  <tr>
    <th>Nombre</th>
    <th>Edad</th>
  </tr>

  <%
    List<Persona> personas = (List<Persona>) request.getAttribute("personas");
    if (personas != null && !personas.isEmpty()) {
        for (Persona p : personas) {
  %>
    <tr>
      <td><%= p.getNombre() %></td>
      <td><%= p.getEdad() %></td>
    </tr>
  <%
        }
    } else {
  %>
    <tr><td colspan="2">No hay personas registradas.</td></tr>
  <%
    }
  %>
</table>

<br><br>
<a href="<%= request.getContextPath() %>/index.jsp">
    <button>🏠 Menú Principal</button>
</a>

