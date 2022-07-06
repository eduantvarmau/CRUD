package com.example.springboot.app.controller;

import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Country;
import com.example.springboot.app.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countryList")
    public ResponseEntity<?> getAllCountry() {
        List<Country> lista = countryService.getAllCountry();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin nacionalidades en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(countryService.getAllCountry());
    }

    @GetMapping("/countryDetails/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(countryService.getCountryById(id));
    }

    @PostMapping("/countryCreate")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        return ResponseEntity.ok().body(this.countryService.createCountry(country));
    }

    @PutMapping("/countryUpdate/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Integer id, @RequestBody Country country) {
        country.setId(id);
        return ResponseEntity.ok().body(this.countryService.updateCountry(country));
    }

    @DeleteMapping("/countryDelete/{id}")
    public HttpStatus deleteCountry(@PathVariable Integer id) {
        this.countryService.deleteCountry(id);
        return HttpStatus.OK;
    }
}
