package it.euris.libreriabm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.libreriabm.dto.LibroDTO;
import it.euris.libreriabm.exception.IdMustBeNullException;
import it.euris.libreriabm.exception.IdMustNotBeNullException;
import it.euris.libreriabm.model.Libro;
import it.euris.libreriabm.service.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/libri")
@SecurityRequirement(name = "authentication")
public class LibroController {

  LibroService libroService;

  @GetMapping("/v1")
  @Operation(description = "This method is used to retrieve all the books from the database")
  public List<LibroDTO> getAllCustomers() {
    return libroService.findAll()
        .stream()
        .map(Libro::toDto)
        .toList();
  }

  @PostMapping("/v1")
  public LibroDTO saveCustomer(@RequestBody LibroDTO libroDTO) {
    try{
      Libro libro = libroDTO.toModel();
      return libroService.insert(libro).toDto();
    }
    catch(IdMustBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping("/v1")
  public LibroDTO updateCustomer(@RequestBody LibroDTO libroDTO){
    try{
      Libro libro = libroDTO.toModel();
      return libroService.update(libro).toDto();
    }
    catch(IdMustNotBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @DeleteMapping("/v1/{id}")
  public Boolean deleteCustomer(@PathVariable("id") Long idLibro) {
    return libroService.deleteById(idLibro);
  }

  @GetMapping("/v1/{id}")
  public LibroDTO getCustomerById(@PathVariable("id") Long idLibro) {
    return libroService.findById(idLibro).toDto();
  }

}
