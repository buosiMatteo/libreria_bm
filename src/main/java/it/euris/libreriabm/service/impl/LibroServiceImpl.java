package it.euris.libreriabm.service.impl;

import it.euris.libreriabm.exception.IdMustBeNullException;
import it.euris.libreriabm.exception.IdMustNotBeNullException;
import it.euris.libreriabm.model.Libro;
import it.euris.libreriabm.repository.LibroRepository;
import it.euris.libreriabm.service.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibroServiceImpl implements LibroService {

  LibroRepository libroRepository;

  @Override
  public List<Libro> findAll() {
    return libroRepository.findAll();
  }

  @Override
  public Libro insert(Libro libro) {
    if (libro.getId() != null){
      throw new IdMustBeNullException();
    }
    return libroRepository.save(libro);
  }

  @Override
  public Libro update(Libro libro) {
    if (libro.getId()==null){
      throw new IdMustNotBeNullException();
    }
    return libroRepository.save(libro);
  }

  @Override
  public Boolean deleteById(Long idLibro) {
    libroRepository.deleteById(idLibro);
    return libroRepository.findById(idLibro).isEmpty();
  }

  @Override
  public Libro findById(Long idLibro) {
    return libroRepository.findById(idLibro).orElse(Libro.builder().build());
  }
}
