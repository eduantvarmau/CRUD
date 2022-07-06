package com.example.springboot.app.service;

import com.example.springboot.app.model.Airport;

import java.util.List;

public interface AirportService {
    Airport createAirport(Airport airport);
    Airport updateAirport(Airport airport);
    List<Airport> getAllAirport();

    Airport getAirportById(Integer airportId);
    void deleteAirport(Integer id);
}
