package it.euris.libreriabm.service;

import it.euris.libreriabm.model.Autore;

import java.util.List;

public interface AutoreService {

  List<Autore> findAll();

  Autore insert(Autore autore);

  Autore update(Autore autore);

  Boolean deleteById(Long idAutore);

  Autore findById(Long idAutore);
}
