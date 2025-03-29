package com.app.parcial.controller;

import com.app.parcial.dto.ProveedorDto;
import com.app.parcial.service.ProveedorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/proveedores")
@CrossOrigin
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<ProveedorDto> addProveedor(@RequestBody ProveedorDto proveedorDto){
        return new ResponseEntity<>(proveedorService.addProveedor(proveedorDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(proveedorService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity <List<ProveedorDto>> findAll(){
        return new ResponseEntity<>(proveedorService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDto> update(@RequestBody ProveedorDto proveedorDto, @PathVariable Long id){
        return new ResponseEntity<>(proveedorService.update(proveedorDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        proveedorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
