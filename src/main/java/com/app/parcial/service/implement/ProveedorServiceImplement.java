package com.app.parcial.service.implement;

import com.app.parcial.dto.ProveedorDto;
import com.app.parcial.entity.Proveedor;
import com.app.parcial.exception.ResourceNotFoundException;
import com.app.parcial.mapper.ProveedorMapper;
import com.app.parcial.repository.ProveedorRepository;
import com.app.parcial.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorServiceImplement implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public ProveedorDto addProveedor(ProveedorDto proveedorDto) {

        if(isValidDescuento(proveedorDto.getDescuento())) {
            Proveedor proveedor = ProveedorMapper.toEntity(proveedorDto);
            return ProveedorMapper.toEntityDto(proveedorRepository.save(proveedor));
        }
        return null;
    }

    @Override
    public ProveedorDto findById(Long id) {
        Proveedor proveedor = proveedorRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor not found"));

        return ProveedorMapper.toEntityDto(proveedor);
    }

    @Override
    public List<ProveedorDto> findAll() {
        return ProveedorMapper.toEntityDtoList(proveedorRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public ProveedorDto update(ProveedorDto proveedorDto, long id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor not found"));

        proveedor.setFirstName(proveedorDto.getFirstName());
        proveedor.setLastName(proveedorDto.getLastName());
        proveedor.setBirthDate(proveedorDto.getBirthDate());
        proveedor.setTipoProveedor(proveedorDto.getTipoProveedor());

        return ProveedorMapper.toEntityDto(proveedorRepository.save(proveedor));
    }

    private boolean isValidDescuento(Float descuento) {
        return descuento > 0;
    }
}
