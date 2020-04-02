package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Producto;
import modelo.dao.ModeloProducto;

/**
 * Servlet implementation class FormCrearProducto
 */
@WebServlet("/formCrearProducto")
public class FormCrearProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCrearProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		ModeloProducto modeloproducto=new ModeloProducto();
		Producto producto=new Producto();
		producto.setNombre(request.getParameter("nombre"));
		producto.setStock(Integer.parseInt(request.getParameter("stock")));
		try {
			Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fechaCompra"));
			java.sql.Date fechaCompra=new java.sql.Date(utilDate.getTime());
			producto.setFecha_compra(fechaCompra);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producto.setColor(request.getParameter("color"));
		producto.setMade_in(request.getParameter("madein"));
		producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
		producto.setDescuento(Integer.parseInt(request.getParameter("descuento")));
		modeloproducto.insert(producto);
		System.out.println(producto);
		response.sendRedirect("index");
	}

}
