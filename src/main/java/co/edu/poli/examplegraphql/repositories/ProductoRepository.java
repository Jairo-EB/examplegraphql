package co.edu.poli.examplegraphql.repositories;

import co.edu.poli.examplegraphql.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}
