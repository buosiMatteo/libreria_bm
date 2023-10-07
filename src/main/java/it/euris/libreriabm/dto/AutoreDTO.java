package it.euris.libreriabm.dto;

import it.euris.libreriabm.dto.archetype.Dto;
import it.euris.libreriabm.dto.archetype.Model;
import it.euris.libreriabm.model.Autore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.libreriabm.utility.DataConversionUtils.stringToLong;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutoreDTO implements Dto {

  private String id;

  private String cognome;

  private String nome;

  @Override
  public Autore toModel() {
    return Autore
        .builder()
        .id(stringToLong(id))
        .cognome(cognome)
        .nome(nome)
        .build();
  }
}
