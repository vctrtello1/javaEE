package com.victortello;

import com.victortello.models.Producto;
import com.victortello.repositories.ProductoRepositorioImp;
import com.victortello.repositories.Repositorio;

public class PoolConnecionExample {
    public static void main(String[] args) {

        Repositorio<Producto> repositorio = new ProductoRepositorioImp();
        repositorio.Find().forEach(System.out::println);
        System.out.println(repositorio.FindById(2L));
        
    }

}
