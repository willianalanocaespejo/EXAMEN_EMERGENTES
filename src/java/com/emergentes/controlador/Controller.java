
package com.emergentes.controlador;

import com.emergentes.modelo.GestorVacuna;
import com.emergentes.modelo.Vacuna;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        Vacuna objVacuna = new Vacuna();
        int id, pos;
        
        String op=request.getParameter("op");
        
        if(op.equals("nuevo"))
        {
            HttpSession ses = request.getSession();
            GestorVacuna agenda =(GestorVacuna) ses.getAttribute("agenda");
            objVacuna.setId(agenda.obtieneId());
            request.setAttribute("op", op);
            request.setAttribute("miVacuna", objVacuna);
            request.getRequestDispatcher("editar.jsp").forward(request, response);    
        }
        
        if(op.equals("modificar"))
        {
            id=Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorVacuna agenda =(GestorVacuna) ses.getAttribute("agenda");
            pos=agenda.ubicarVacuna(id);
            objVacuna = agenda.getLista().get(pos);
            
            request.setAttribute("op", op);
            request.setAttribute("miVacuna", objVacuna);
            request.getRequestDispatcher("editar.jsp").forward(request, response);  
        }

        if(op.equals("eliminar"))
        {
            id=Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorVacuna agenda =(GestorVacuna) ses.getAttribute("agenda");
            pos=agenda.ubicarVacuna(id);
            agenda.eliminarVacuna(pos);
            ses.setAttribute("agenda", agenda);
            response.sendRedirect("index.jsp");

        } 
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        Vacuna objVacuna = new Vacuna();
        int pos;
        String op=request.getParameter("op");
        
        if(op.equals("grabar"))
        {
            objVacuna.setId(Integer.parseInt(request.getParameter("id")));
            objVacuna.setNombre(request.getParameter("nombre"));
            objVacuna.setPeso(Double.parseDouble(request.getParameter("peso")));
            objVacuna.setTalla(Double.parseDouble(request.getParameter("talla")));
            objVacuna.setVacuna(request.getParameter("vacuna"));
            
            
            HttpSession ses = request.getSession();
            GestorVacuna agenda =(GestorVacuna) ses.getAttribute("agenda");
            
            String opg = request.getParameter("opg");
            if(opg.equals("nuevo"))
            {
                agenda.insertarVacuna(objVacuna);
            }
            else
            {
                pos=agenda.ubicarVacuna(objVacuna.getId());
                agenda.modificarVacuna(pos, objVacuna);
            }
            ses.setAttribute("agenda", agenda);
            response.sendRedirect("index.jsp");       
        }      
    }
}
