package com.example.springboot.app.controller;

import java.util.List;

import com.example.springboot.app.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.service.EmployeeService;

@RestController
@RequestMapping("/evaluacion")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;


	@GetMapping("/listaempleados")
	public ResponseEntity<?> getAllEmployee() {
		List<Employee> lista = employeeService.getAllEmployee();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin empleados en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(employeeService.getAllEmployee());
	}

	@GetMapping("/detalleempleado/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}

	@PostMapping("/crearempleado")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
	}

	@PutMapping("/actualizaempleado/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		employee.setId(id);
		return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
	}

	@DeleteMapping("/eliminaempleado/{id}")
	public HttpStatus deleteEmployee(@PathVariable long id) {
		this.employeeService.deleteEmployee(id);
		return HttpStatus.OK;
	}
}//class