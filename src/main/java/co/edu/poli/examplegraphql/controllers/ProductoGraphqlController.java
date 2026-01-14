package co.edu.poli.examplegraphql.controllers;

import co.edu.poli.examplegraphql.model.Producto;
import co.edu.poli.examplegraphql.services.ProductoService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductoGraphqlController {

    private final ProductoService service;

    public ProductoGraphqlController(ProductoService service) {
        this.service = service;
    }

    // Queries
    @QueryMapping
    public List<Producto> productos() {
        return service.listar();
    }

    @QueryMapping
    public Producto productoPorId(@Argument Long id) {
        return service.buscarPorId(id);
    }

    // Mutations
    @MutationMapping
    public Producto crearProducto(@Argument ProductoInput input) {
        return service.crear(input.nombre(), input.precio(), input.stock());
    }

    @MutationMapping
    public Producto actualizarProducto(@Argument Long id, @Argument ProductoInput input) {
        return service.actualizar(id, input.nombre(), input.precio(), input.stock());
    }

    @MutationMapping
    public Boolean eliminarProducto(@Argument Long id) {
        return service.eliminar(id);
    }

    // Input del schema: ProductoInput
    public record ProductoInput(String nombre, Double precio, Integer stock) {}
}
