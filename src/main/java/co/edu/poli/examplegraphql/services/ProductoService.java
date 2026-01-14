package co.edu.poli.examplegraphql.services;

import co.edu.poli.examplegraphql.model.Producto;
import co.edu.poli.examplegraphql.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() {
        return repo.findAll();
    }

    public Producto buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Producto crear(String nombre, Double precio, Integer stock) {
        return repo.save(new Producto(nombre, precio, stock));
    }

    public Producto actualizar(Long id, String nombre, Double precio, Integer stock) {
        Producto existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setNombre(nombre);
        existente.setPrecio(precio);
        existente.setStock(stock);

        return repo.save(existente);
    }

    public boolean eliminar(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
