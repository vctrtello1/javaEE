package com.victortello.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.victortello.models.Categoria;
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
        ResultSet resultSet = statement.executeQuery("select p.id, p.cnombre, p.iprecio, p.dFechaRegistro, c.id,"
        +" c.cnombre,c.cnombre as categoria from productos as p inner join categorias as c on (p.idCategoria = c.id)") ){
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
        try(PreparedStatement preparedStatement = getConnection().prepareStatement("select p.id, p.cnombre, p.iprecio, p.dFechaRegistro, c.id,"
            +" c.cnombre, c.cnombre as categoria from productos as p inner join categorias as c on (p.idCategoria = c.id) where p.id = ?")){
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
            sql = "insert into productos(cnombre, iprecio,idCategoria,dFechaRegistro,) values (?,?,?.?)";
        }
        else{
            sql = "update productos set cnombre =?, iprecio =?,idCategori=?, dFechaRegistro =? where id =?";
        }
        
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, producto.getCnombre());
            preparedStatement.setInt(2, producto.getIprecio());
            preparedStatement.setLong(4, producto.getCategoria().getId());
            if(producto.getId() == 0){
                preparedStatement.setLong(4, producto.getId());
            }
            else{
                preparedStatement.setDate(4, new Date(producto.getdFechaRegistro().getTime()));
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
        producto.setIprecio(resultSet.getInt("iprecio"));
        producto.setdFechaRegistro(resultSet.getDate("dFechaRegistro"));
        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getLong("id"));
        categoria.setCnombre(resultSet.getString("categoria"));
        producto.setCategoria(categoria);
        return producto;
    }
    
}
