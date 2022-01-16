package com.victortello;

import java.sql.*;

import com.victortello.models.Producto;
import com.victortello.repositories.ProductoRepositorioImp;
import com.victortello.repositories.Repositorio;
import com.victortello.utils.databaseConnection;

public class JBDCEjemplo {
    public static void main(String[] args) {

        try (
            Connection conn = databaseConnection.getInstance();)
        {            
            Repositorio<Producto>repositorio = new ProductoRepositorioImp();
            repositorio.Find().forEach(producto -> System.out.println(producto.getCnombre()));
        }
         catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
