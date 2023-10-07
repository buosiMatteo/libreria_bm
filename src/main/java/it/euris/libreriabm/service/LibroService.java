package it.euris.libreriabm.service;

import it.euris.libreriabm.model.Libro;

import java.util.List;

public interface LibroService {

  List<Libro> findAll();

  Libro insert(Libro libro);

  Libro update(Libro libro);

  Boolean deleteById(Long idLibro);

  Libro findById(Long idLibro);

}
