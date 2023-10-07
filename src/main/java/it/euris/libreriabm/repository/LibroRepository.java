package it.euris.libreriabm.repository;

import it.euris.libreriabm.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
