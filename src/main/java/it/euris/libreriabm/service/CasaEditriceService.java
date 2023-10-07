package it.euris.libreriabm.service;

import it.euris.libreriabm.model.CasaEditrice;

import java.util.List;

public interface CasaEditriceService {

  List<CasaEditrice> findAll();

  CasaEditrice insert(CasaEditrice casaEditrice);

  CasaEditrice update(CasaEditrice casaEditrice);

  Boolean deleteById(Long idCasaEditrice);

  CasaEditrice findById(Long idCasaEditrice);
}
