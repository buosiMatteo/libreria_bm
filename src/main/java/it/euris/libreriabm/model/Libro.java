package it.euris.libreriabm.model;

import it.euris.libreriabm.dto.LibroDTO;
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
@Table(name = "libri")
public class Libro implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "isbn")
  private String isbn;

  @Column(name = "titolo")
  private String titolo;

  @ManyToOne
  @MapsId("id_autore")
  @JoinColumn(name = "id_autori")
  private Autore autore;

  @ManyToOne
  @MapsId("id_casa_editrice")
  @JoinColumn(name = "id_casa_editrice")
  private CasaEditrice casaEditrice;

  @Override
  public LibroDTO toDto() {
    return LibroDTO
        .builder()
        .id(numberToString(id))
        .isbn(isbn)
        .titolo(titolo)
        .idAutore(numberToString(autore.getId()))
        .idCasaEditrice(numberToString(casaEditrice.getId()))
        .build();
  }
}
