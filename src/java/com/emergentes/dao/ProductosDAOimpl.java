
package com.emergentes.dao;

import com.emergentes.modelo.Productos;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAOimpl extends ConexionDB implements ProductosDAO {

    @Override
    public void insert(Productos productos) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT into productos (nombre_producto, precio , stock) values (?, ?, ?)" );
            ps.setString(1, productos.getNombre_Producto());
            ps.setDouble(2, productos.getPrecio());
            ps.setInt(3, productos.getStock());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Productos productos) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE productos set nombre_producto = ?, precio = ? , stock = ? where id = ?");
            ps.setString(1, productos.getNombre_Producto());
            ps.setDouble(2, productos.getPrecio());
            ps.setInt(3, productos.getStock());
            ps.setInt(4, productos.getId());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
     try{
         this.conectar();
         PreparedStatement ps = this.conn.prepareStatement("DELETE FROM productos WHERE id = ?");
         ps.setInt(1,id);
         ps.executeUpdate();
     }catch (Exception e){
         throw e;
     }finally{
         this.desconectar();
     }   
    }

    @Override
    public Productos getById(int id) throws Exception {
        Productos pro = new Productos();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM productos WHERE id = ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pro.setId(rs.getInt("id"));
                pro.setNombre_Producto(rs.getString("nombre_producto"));
                pro.setPrecio(rs.getDouble("precio"));
                pro.setStock(rs.getInt("stock"));
            }
        }catch (Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
        return pro;
    }

    @Override
    public List<Productos> getAll() throws Exception {
        List<Productos> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM productos");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Productos>();
            while(rs.next()){
                Productos pro = new Productos();
                pro.setId(rs.getInt("id"));
                pro.setNombre_Producto(rs.getString("nombre_producto"));
                pro.setPrecio(rs.getDouble("precio"));
                pro.setStock(rs.getInt("stock"));
                
            }
            rs.close();
            ps.close();
        }catch (Exception e) {
            throw e;
        }finally{
          this.desconectar();
        }
        return lista;
    }
    
}
