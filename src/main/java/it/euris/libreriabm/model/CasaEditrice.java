package it.euris.libreriabm.model;

import it.euris.libreriabm.dto.CasaEditriceDTO;
import it.euris.libreriabm.dto.archetype.Dto;
import it.euris.libreriabm.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.libreriabm.utility.DataConversionUtils.numberToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "casa_editrice")
public class CasaEditrice implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "nome")
  private String nome;

  @Override
  public CasaEditriceDTO toDto() {
    return CasaEditriceDTO
        .builder()
        .id(numberToString(id))
        .nome(nome)
        .build();
  }
}
