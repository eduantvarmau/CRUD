package com.example.springboot.app.controller;

import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Language;
import com.example.springboot.app.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/languageList")
    public ResponseEntity<?> getAllLanguage() {
        List<Language> lista = languageService.getAllLanguage();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin empleados en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(languageService.getAllLanguage());
    }

    @GetMapping("/languageDetails/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable int id) {
        return ResponseEntity.ok().body(languageService.getLanguageById(id));
    }

    @PostMapping("/languageCreate")
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        return ResponseEntity.ok().body(this.languageService.createLanguage(language));
    }

    @PutMapping("/languageUpdate/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable int id, @RequestBody Language language) {
        language.setId(id);
        return ResponseEntity.ok().body(this.languageService.updateLanguage(language));
    }

    @DeleteMapping("/languageDelete/{id}")
    public HttpStatus deleteLanguage(@PathVariable int id) {
        this.languageService.deleteLanguage(id);
        return HttpStatus.OK;
    }
}
