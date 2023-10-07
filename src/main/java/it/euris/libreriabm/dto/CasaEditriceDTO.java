package it.euris.libreriabm.dto;

import it.euris.libreriabm.dto.archetype.Dto;
import it.euris.libreriabm.model.CasaEditrice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.libreriabm.utility.DataConversionUtils.stringToLong;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CasaEditriceDTO implements Dto {

  private String id;

  private String nome;

  @Override
  public CasaEditrice toModel() {
    return CasaEditrice
        .builder()
        .id(stringToLong(id))
        .nome(nome)
        .build();
  }
}
