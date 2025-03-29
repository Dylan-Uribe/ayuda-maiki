package com.app.parcial.service;

import com.app.parcial.dto.ProveedorDto;
import java.util.List;

public interface ProveedorService {
    ProveedorDto addProveedor(ProveedorDto proveedorDto);
    ProveedorDto findById(Long id);
    List<ProveedorDto> findAll();
    void delete(Long id);
    ProveedorDto update(ProveedorDto proveedorDto, long Id);
}