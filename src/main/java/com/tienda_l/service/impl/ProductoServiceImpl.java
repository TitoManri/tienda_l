package com.tienda_l.service.impl;

import com.tienda_l.dao.ProductoDao;
import com.tienda_l.domain.Producto;
import com.tienda_l.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
    @Override
    @Transactional
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup){
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
     @Override
    @Transactional
    public List<Producto> metodoNativo (double precioInf, double precioSup){
        return productoDao.metodoNativo(precioInf, precioSup);
    }
     @Override
    @Transactional
    public List<Producto> metodoJPQL (double precioInf, double precioSup){
        return productoDao.metodoJPQL(precioInf, precioSup);
    }
   

    @Override
    public List<Producto> getProductosByPrecioBetweenOrderByPrecioAsc(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByPrecioAsc(precioInf, precioSup);
    }

    @Override
    public List<Producto> getProductosByPrecioBetweenOrderByPrecioDesc(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByPrecioDesc(precioInf, precioSup);
    }
    
}