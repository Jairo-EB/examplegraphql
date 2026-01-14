package co.edu.poli.examplegraphql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private Double precio;
    private Integer stock;

    public Producto() {}

    public Producto(String nombre, Double precio, Integer stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Double getPrecio() { return precio; }
    public Integer getStock() { return stock; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public void setStock(Integer stock) { this.stock = stock; }
}
