package it.euris.libreriabm.service.impl;

import it.euris.libreriabm.exception.IdMustBeNullException;
import it.euris.libreriabm.exception.IdMustNotBeNullException;
import it.euris.libreriabm.model.Autore;
import it.euris.libreriabm.model.CasaEditrice;
import it.euris.libreriabm.repository.CasaEditriceRepository;
import it.euris.libreriabm.service.CasaEditriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CasaEditriceServiceImpl implements CasaEditriceService {

  CasaEditriceRepository casaEditriceRepository;

  @Override
  public List<CasaEditrice> findAll() {
    return casaEditriceRepository.findAll();
  }

  @Override
  public CasaEditrice insert(CasaEditrice casaEditrice) {
    if (casaEditrice.getId() != null) {
      throw new IdMustBeNullException();
    }
    return casaEditriceRepository.save(casaEditrice);
  }

  @Override
  public CasaEditrice update(CasaEditrice casaEditrice) {
    if (casaEditrice.getId()==null){
      throw new IdMustNotBeNullException();
    }
    return casaEditriceRepository.save(casaEditrice);
  }

  @Override
  public Boolean deleteById(Long idCasaEditrice) {
    casaEditriceRepository.deleteById(idCasaEditrice);
    return casaEditriceRepository.findById(idCasaEditrice).isEmpty();
  }

  @Override
  public CasaEditrice findById(Long idCasaEditrice) {
    return casaEditriceRepository.findById(idCasaEditrice).orElse(CasaEditrice.builder().build());  }

}
