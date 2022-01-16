package com.victortello.repositories;

import java.sql.Connection;
import java.sql.Date;
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
        ResultSet resultSet = statement.executeQuery("select id, cnombre, iprecio,dFechaRegistro from productos") ){
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
        try(PreparedStatement preparedStatement = getConnection().prepareStatement("select id, cnombre, iprecio,dFechaRegistro from productos where id = ?")){
            preparedStatement.setLong(1, id);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    producto = crearProducto(resultSet);
                }                
            }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void save(Producto producto) {
        String sql;
        if(producto.getId() == 0){
            sql = "insert into productos(cnombre, iprecio,dFechaRegistro) values (?,?,?)";
        }
        else{
            sql = "update productos set cnombre =?, iprecio =?,dFechaRegistro =? where id =?";
        }
        
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, producto.getCnombre());
            preparedStatement.setInt(2, producto.getiPrecio());
            if(producto.getId() == 0){
                preparedStatement.setLong(3, producto.getId());
            }
            else{
                preparedStatement.setDate(3, new Date(producto.getdFechaRegistro().getTime()));
            }
        
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }        
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement preparedStatement = getConnection().prepareStatement("delete from productos where id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    private Producto crearProducto(ResultSet resultSet) throws SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id"));
        producto.setCnombre(resultSet.getString("cnombre"));
        producto.setiPrecio(resultSet.getInt("iprecio"));
        producto.setdFechaRegistro(resultSet.getDate("dFechaRegistro"));
        return producto;
    }
    
}
