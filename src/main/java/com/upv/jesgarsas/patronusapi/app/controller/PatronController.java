package com.upv.jesgarsas.patronusapi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.upv.jesgarsas.patronusapi.app.model.dto.PageDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.PatronDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.filter.PatronFilterDTO;
import com.upv.jesgarsas.patronusapi.app.service.PatronService;

@Controller
@RequestMapping(value = "/patron")
public class PatronController {

	@Autowired
	private PatronService patronService;
	
	@GetMapping("/alumno/all")
	public ResponseEntity<List<PatronDTO>> findAllPatrones() {
		return ResponseEntity.ok(patronService.findAllPatrones());
	}
	
	@PostMapping("/alumno/all/filtered")
	public ResponseEntity<PageDTO<PatronDTO>> findAllPatronesFiltered(@RequestBody(required = true) PatronFilterDTO filter) {
		return ResponseEntity.ok(patronService.findAllPatronesPageable(filter));
	}
	
	@GetMapping("/alumno/all/{idLocale}")
	public ResponseEntity<List<PatronDTO>> findAllPatrones(@PathVariable(name = "idLocale", required = true) Integer idLocale) {
		return ResponseEntity.ok(patronService.findAllPatronesByLocale(idLocale));
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<PatronDTO> findById(@PathVariable(name = "id", required = true) Integer id) {
		return ResponseEntity.ok(patronService.findById(id));
	}
	
	@GetMapping("/alumno/{idPatron}/{idLocale}")
	public ResponseEntity<PatronDTO> findByIdAndLocale(@PathVariable(name = "idPatron", required = true) Integer id,
			@PathVariable(name = "idLocale", required = true) Integer idLocale) {
		return ResponseEntity.ok(patronService.findByIdAndLocale(id, idLocale));
	}
	
	@DeleteMapping("/profesor/{id}") 
	public ResponseEntity<Boolean> deleteById(@PathVariable(name = "id", required = true) Integer id){
		patronService.deleteById(id);
		return ResponseEntity.ok(true);
	}
	
	@PostMapping("/profesor/save")
	public ResponseEntity<Boolean> save(@RequestPart(name="patron", required = true) PatronDTO patron,
			@RequestPart(name="files", required = false) List<MultipartFile> files) {
		PatronDTO newPatron = patronService.saveOrUpdate(patron, files);
		return ResponseEntity.ok(newPatron == null ? false : true);
	}
}
