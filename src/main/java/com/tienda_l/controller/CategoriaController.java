/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_l.controller;

import com.tienda_l.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author manri
 */
@Controller
@RequestMapping("/categoria")

public class CategoriaController {
    
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var categorias=categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        model.addAttribute("totalCategorias",categorias.size());
            return "/categoria/listado";
    }
}
