package com.tienda_l.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author manri
 */

@Data
@Entity // Para decir que es una tabla de la base de datos
@Table(name="categoria")

public class Categoria implements Serializable{
    private static final long serialVersionUID = 1L;
@Id  // Para el Primary Key
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_Categoria")
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
}
