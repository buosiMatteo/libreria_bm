package it.euris.libreriabm.dto;

import it.euris.libreriabm.dto.archetype.Dto;
import it.euris.libreriabm.model.Autore;
import it.euris.libreriabm.model.CasaEditrice;
import it.euris.libreriabm.model.Libro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.libreriabm.utility.DataConversionUtils.stringToLong;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroDTO implements Dto {

  private String id;

  private String isbn;

  private String titolo;

  private String idAutore;

  private String idCasaEditrice;


  @Override
  public Libro toModel() {
    return Libro
        .builder()
        .id(stringToLong(id))
        .isbn(isbn)
        .titolo(titolo)
        .autore(Autore.builder().id(stringToLong(idAutore)).build())
        .casaEditrice(CasaEditrice.builder().id(stringToLong(idCasaEditrice)).build())
        .build();
  }
}
