
package com.emergentes.controlador;
import com.emergentes.modelo.Universitario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession ses = request.getSession();

        if (ses.getAttribute("listuni") == null) {
            ArrayList<Universitario> listaux = new ArrayList<>();
            ses.setAttribute("listuni", listaux);
        }

        ArrayList<Universitario> lista = (ArrayList<Universitario>) ses.getAttribute("listuni");
        String op = request.getParameter("op");
        String opcion = (op != null) ? request.getParameter("op") : "view";

        Universitario obj1 = new Universitario();
        int id, pos;
        switch (opcion) {
            case "nuevo":
                request.setAttribute("miUniversitario", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request,id);
                obj1 = lista.get(pos);
                request.setAttribute("miUniversitario", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request, id);
                lista.remove(pos);
                ses.setAttribute("listuni", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "view":
                response.sendRedirect("index.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ArrayList<Universitario> lista = (ArrayList<Universitario>) ses.getAttribute("listuni");

        Universitario obj1 = new Universitario();

        obj1.setId(Integer.parseInt(request.getParameter("id")));
        obj1.setNombre(request.getParameter("nombre"));
        obj1.setApellido(request.getParameter("apellido"));
        obj1.setCategoria(request.getParameter("categoria"));
        obj1.setConfirmado(Integer.parseInt(request.getParameter("confirmado")));
        obj1.setFecha1 (request.getParameter("fecha1"));
        int idt = obj1.getId();
        if (idt == 0) {
            int ultID;
            ultID = ultimoId(request);
            obj1.setId(ultID);
            lista.add(obj1);
        } else {
            lista.set(buscarIndice(request, idt), obj1);

        }
        ses.setAttribute("listuni", lista);
        response.sendRedirect("index.jsp");
    }
    private int ultimoId(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<Universitario> lista = (ArrayList<Universitario>) ses.getAttribute("listuni");
        int idaux = 0;
        for (Universitario item : lista) {
            idaux = item.getId();
        }
        return idaux + 1;
    }

    private int buscarIndice (HttpServletRequest request , int id){
        HttpSession ses = request.getSession();
        ArrayList<Universitario> lista =(ArrayList<Universitario>)ses.getAttribute("listuni");
        
        int i=0;
        if(lista.size()>0){
            while (i< lista.size()){
                if(lista.get(i).getId()==id){
                    break;
                }
                else{
                    i++;
                }
            }
        }
        return i;
    }
 

}
