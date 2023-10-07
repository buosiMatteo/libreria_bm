package it.euris.libreriabm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.libreriabm.dto.AutoreDTO;
import it.euris.libreriabm.dto.CasaEditriceDTO;
import it.euris.libreriabm.exception.IdMustBeNullException;
import it.euris.libreriabm.exception.IdMustNotBeNullException;
import it.euris.libreriabm.model.Autore;
import it.euris.libreriabm.model.CasaEditrice;
import it.euris.libreriabm.service.CasaEditriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/case-editrici")
@SecurityRequirement(name = "authentication")
public class CasaEditriceController {

  CasaEditriceService casaEditriceService;

  @GetMapping("/v1")
  @Operation(description = "Questo endpoint viene usato per elencare tutto le case editrici")
  public List<CasaEditriceDTO> getAllCustomers() {
    return casaEditriceService.findAll()
        .stream()
        .map(CasaEditrice::toDto)
        .toList();
  }

  @PostMapping("/v1")
  public CasaEditriceDTO saveCustomer(@RequestBody CasaEditriceDTO casaEditriceDTO) {
    try{
      CasaEditrice casaEditrice = casaEditriceDTO.toModel();
      return casaEditriceService.insert(casaEditrice).toDto();
    }
    catch(IdMustBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping("/v1")
  public CasaEditriceDTO updateCustomer(@RequestBody CasaEditriceDTO casaEditriceDTO){
    try{
      CasaEditrice casaEditrice = casaEditriceDTO.toModel();
      return casaEditriceService.update(casaEditrice).toDto();
    }
    catch(IdMustNotBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @DeleteMapping("/v1/{id}")
  public Boolean deleteCustomer(@PathVariable("id") Long idCasaEditrice) {
    return casaEditriceService.deleteById(idCasaEditrice);
  }

  @GetMapping("/v1/{id}")
  public CasaEditriceDTO getCustomerById(@PathVariable("id") Long idCasaEditrice) {
    return casaEditriceService.findById(idCasaEditrice).toDto();
  }

}
