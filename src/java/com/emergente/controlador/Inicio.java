
package com.emergente.controlador;

import com.emergentes.dao.ProductosDAO;
import com.emergentes.dao.ProductosDAOimpl;
import com.emergentes.modelo.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Inicio", urlPatterns = {"/inicio"})
public class Inicio extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductosDAO dao = new ProductosDAOimpl();
            int id;
            Productos pro = new Productos();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    request.setAttribute("productos", pro);
                    request.getRequestDispatcher("frmproductos.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    pro = dao.getById(id);
                    System.out.println(pro);
                    request.setAttribute("productos", pro);
                    request.getRequestDispatcher("frmproductos.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/inicio");
                    break;
                case "view":
                    List<Productos> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                default:
                    break;
            }
        
        } catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
       String nombre_producto = request.getParameter("nombre_producto");
       double precio = Double.parseDouble("precio");
       int stock = Integer.parseInt(request.getParameter("stock"));

       Productos pro = new Productos();
       
       pro.setId(id);
       pro.setNombre_Producto(nombre_producto);
       pro.setPrecio(precio);
       pro.setStock(stock);
       
       if (id == 0){
           try {
               ProductosDAO dao = new ProductosDAOimpl();
               dao.insert(pro);
               response.sendRedirect(request.getContextPath()+"/inicio");
               
           }catch(Exception ex){
               System.out.println("Error " + ex.getMessage());
           }
       }
       
    }
   
}
