package it.euris.libreriabm.service.impl;

import it.euris.libreriabm.exception.IdMustNotBeNullException;
import it.euris.libreriabm.model.Autore;
import it.euris.libreriabm.repository.AutoreRepository;
import it.euris.libreriabm.service.AutoreService;
import it.euris.libreriabm.exception.IdMustBeNullException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutoreServiceImpl implements AutoreService {

  AutoreRepository autoreRepository;

  @Override
  public List<Autore> findAll() {
    return autoreRepository.findAll();
  }

  @Override
  public Autore insert(Autore autore) {
    if (autore.getId() != null) {
      throw new IdMustBeNullException();
    }
    return autoreRepository.save(autore);
  }

  @Override
  public Autore update(Autore autore) {
    if (autore.getId()==null){
      throw new IdMustNotBeNullException();
    }
    return autoreRepository.save(autore);
  }

  @Override
  public Boolean deleteById(Long idAutore) {
    autoreRepository.deleteById(idAutore);
    return autoreRepository.findById(idAutore).isEmpty();
  }

  @Override
  public Autore findById(Long idAutore) {
    return autoreRepository.findById(idAutore).orElse(Autore.builder().build());
  }
}
