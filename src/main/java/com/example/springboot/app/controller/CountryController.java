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
@RequestMapping("/evaluacion")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/listanacionalidades")
    public ResponseEntity<?> getAllCountry() {
        List<Country> lista = countryService.getAllCountry();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin nacionalidades en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(countryService.getAllCountry());
    }

    @GetMapping("/detallenacionalidad/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable long id) {
        return ResponseEntity.ok().body(countryService.getCountryById(id));
    }

    @PostMapping("/crearnacionalidad")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        return ResponseEntity.ok().body(this.countryService.createCountry(country));
    }

    @PutMapping("/actualizanacionalidad/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable long id, @RequestBody Country country) {
        country.setId(id);
        return ResponseEntity.ok().body(this.countryService.updateCountry(country));
    }

    @DeleteMapping("/eliminanacionalidad/{id}")
    public HttpStatus deleteCountry(@PathVariable long id) {
        this.countryService.deleteCountry(id);
        return HttpStatus.OK;
    }
}
