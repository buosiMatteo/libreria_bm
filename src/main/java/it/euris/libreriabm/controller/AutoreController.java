package it.euris.libreriabm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.libreriabm.dto.AutoreDTO;
import it.euris.libreriabm.exception.IdMustBeNullException;
import it.euris.libreriabm.exception.IdMustNotBeNullException;
import it.euris.libreriabm.model.Autore;
import it.euris.libreriabm.service.AutoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/autori")
@SecurityRequirement(name = "authentication")
public class AutoreController {

  AutoreService autoreService;

  @GetMapping("/v1")
  @Operation(description = "This endpoint return all authors")
  public List<AutoreDTO> getAllAuthors(){
    return autoreService.findAll()
        .stream()
        .map(Autore::toDto)
        .toList();
  }

  @PostMapping("/v1")
  public AutoreDTO saveCustomer(@RequestBody AutoreDTO autoreDTO) {
    try{
      Autore autore = autoreDTO.toModel();
      return autoreService.insert(autore).toDto();
    }
    catch(IdMustBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping("/v1")
  public AutoreDTO updateCustomer(@RequestBody AutoreDTO autoreDTO){
    try{
      Autore autore = autoreDTO.toModel();
      return autoreService.update(autore).toDto();
    }
    catch(IdMustNotBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @DeleteMapping("/v1/{id}")
  public Boolean deleteCustomer(@PathVariable("id") Long idAutore) {
    return autoreService.deleteById(idAutore);
  }

  @GetMapping("/v1/{id}")
  public AutoreDTO getCustomerById(@PathVariable("id") Long idAutore) {
    return autoreService.findById(idAutore).toDto();
  }

}
