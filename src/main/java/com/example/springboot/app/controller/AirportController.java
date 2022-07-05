package com.example.springboot.app.controller;

import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Airport;
import com.example.springboot.app.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;


    @GetMapping("/listaaereopuertos")
    public ResponseEntity<?> getAllAirport() {
        List<Airport> lista = airportService.getAllAirport();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin aereopuertos en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(airportService.getAllAirport());
    }

    @GetMapping("/detalleaereopuerto/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable long id) {
        return ResponseEntity.ok().body(airportService.getAirportById(id));
    }

    @PostMapping("/crearaereopuerto")
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok().body(this.airportService.createAirport(airport));
    }

    @PutMapping("/actualizaaereopuerto/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable long id, @RequestBody Airport airport) {
        airport.setId(id);
        return ResponseEntity.ok().body(this.airportService.updateAirport(airport));
    }

    @DeleteMapping("/eliminaaereopuerto/{id}")
    public HttpStatus deleteAirport(@PathVariable long id) {
        this.airportService.deleteAirport(id);
        return HttpStatus.OK;
    }
}
