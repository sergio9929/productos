package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.bean.Producto;
import modelo.bean.Talla;
import modelo.Conector;

public class ModeloProducto extends Conector {
	public ArrayList<Producto> getAll(){
		//TODO implementar
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			PreparedStatement pstSelect = conexion.prepareStatement("select * from productos");
			ResultSet rs=pstSelect.executeQuery();
			while(rs.next()) {
				Producto producto=new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setStock(rs.getInt("stock"));
				producto.setFecha_compra(rs.getDate("fecha_compra"));
				producto.setColor(rs.getString("color"));
				producto.setMade_in(rs.getString("made_in"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setDescuento(rs.getInt("descuento"));
				productos.add(producto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;
	}
	
	public Producto get(int id) {
		//TODO implementar
		Producto producto=new Producto();
		try {
			PreparedStatement pstSelect = conexion.prepareStatement("select * from productos where id=?");
			pstSelect.setInt(1, id);
			ResultSet rs=pstSelect.executeQuery();
			while(rs.next()) {
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setStock(rs.getInt("stock"));
				producto.setFecha_compra(rs.getDate("fecha_compra"));
				producto.setColor(rs.getString("color"));
				producto.setMade_in(rs.getString("made_in"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setDescuento(rs.getInt("descuento"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}
	
	public void insert(Producto producto) {
		try {
			PreparedStatement pstInsert = conexion.prepareStatement("insert into productos values(?,?,?,?,?,?,?,?,?)");
			pstInsert.setInt(1, producto.getId());
			pstInsert.setString(2, producto.getNombre());
			pstInsert.setInt(3, producto.getStock());
			pstInsert.setDate(4, producto.getFecha_compra());
			pstInsert.setString(5, producto.getColor());
			pstInsert.setString(6, producto.getMade_in());
			pstInsert.setDouble(7, producto.getPrecio());
			pstInsert.setInt(8, producto.getDescuento());
			pstInsert.setString(9, producto.getTallas());
			pstInsert.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Producto producto) {
		//TODO implementar
	}
	
	public void delete(int id) {
		try {
			PreparedStatement pstDelete = conexion.prepareStatement("delete from productos where id=?");
			pstDelete.setInt(1, id);
			pstDelete.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Producto> deLaTalla(Talla talla){
		//TODO implementar, un poco mas dificil
		return null;
	}
}
