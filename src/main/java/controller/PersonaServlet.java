package controller;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Persona;

@WebServlet("/persona")
public class PersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final PersonaController controller = new PersonaController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("buscar".equals(action)) {
            String nombre = request.getParameter("nombre");
            Persona persona = null;

            if (nombre != null && !nombre.trim().isEmpty()) {
                persona = controller.buscarPersona(nombre.trim());
            }

            request.setAttribute("persona", persona);
            RequestDispatcher rd = request.getRequestDispatcher("persona/buscar.jsp");
            rd.forward(request, response);
        } 
        else if ("listar".equals(action)) {
            List<Persona> lista = controller.listarPersonas();
            request.setAttribute("personas", lista);
            RequestDispatcher rd = request.getRequestDispatcher("persona/listar.jsp");
            rd.forward(request, response);
        } 
        else {
            // Acción por defecto: mostrar listado
            response.sendRedirect(request.getContextPath() + "/persona?action=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            // ✅ 1. Agregar persona
            if (action == null || "agregar".equals(action)) {
                String nombre = request.getParameter("nombre");
                int edad = Integer.parseInt(request.getParameter("edad"));
                Persona p = new Persona(nombre, edad);

                boolean ok = controller.agregarPersona(p);
                if (ok) {
                    response.sendRedirect(request.getContextPath() + "/persona?action=listar");
                } else {
                    response.getWriter().println("Error al agregar persona.");
                }
        }catch (Exception e) {
            System.out.println("=== ERROR DB INSERT ===");
            e.printStackTrace(); 
            throw e; 
        }

            // ✅ 2. Actualizar edad
            else if ("actualizar".equals(action)) {
                String nombre = request.getParameter("nombre");
                int nuevaEdad = Integer.parseInt(request.getParameter("edad"));

                boolean actualizado = controller.actualizarEdad(nombre, nuevaEdad);
                if (actualizado) {
                    request.setAttribute("mensaje", "Edad actualizada correctamente para " + nombre);
                } else {
                    request.setAttribute("mensaje", "No se encontró persona con el nombre: " + nombre);
                }

                RequestDispatcher rd = request.getRequestDispatcher("persona/actualizar.jsp");
                rd.forward(request, response);
            }

            // ✅ 3. Eliminar persona
            else if ("eliminar".equals(action)) {
                String nombre = request.getParameter("nombre");
                boolean eliminado = controller.eliminarPersona(nombre);

                if (eliminado) {
                    request.setAttribute("mensaje", "Persona eliminada correctamente: " + nombre);
                } else {
                    request.setAttribute("mensaje", "No se encontró persona con el nombre: " + nombre);
                }

                RequestDispatcher rd = request.getRequestDispatcher("persona/eliminar.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error general al procesar la solicitud.");
        }
    }
}
