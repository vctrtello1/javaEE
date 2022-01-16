package com.victortello.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.victortello.models.Producto;
import com.victortello.utils.databaseConnection;

public class ProductoRepositorioImp implements Repositorio<Producto>{

    private Connection getConnection(){
        return databaseConnection.getInstance();
    }

    @Override
    public List<Producto> Find() { 
        List<Producto> productos = new ArrayList<>();     
        try(Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from productos") ){
            while(resultSet.next()){
                Producto producto = crearProducto(resultSet);
                productos.add(producto);
            }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto FindById(Long id) {        
        Producto producto  = null;
        try(PreparedStatement preparedStatement = getConnection().prepareStatement("select id, cnombre, precio,dFechaRegistro from productos where id = ?")){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                producto = crearProducto(resultSet);
            }
            resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void save(Producto t) {
        
        
    }

    @Override
    public void delete(Long id) {        
        
    }

    private Producto crearProducto(ResultSet resultSet) throws SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id"));
        producto.setCnombre(resultSet.getString("cnombre"));
        producto.setPrecio(resultSet.getInt("precio"));
        producto.setdFechaRegistro(resultSet.getDate("dFechaRegistro"));
        return producto;
    }
    
}
