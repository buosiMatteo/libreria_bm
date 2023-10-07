package it.euris.libreriabm.model;

import it.euris.libreriabm.dto.AutoreDTO;
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
@Table(name = "autori")
public class Autore implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "cognome")
  private String cognome;

  @Column(name = "nome")
  private String nome;

  @Override
  public AutoreDTO toDto() {
    return AutoreDTO
        .builder()
        .id(numberToString(id))
        .cognome(cognome)
        .nome(nome)
        .build();
  }
}
