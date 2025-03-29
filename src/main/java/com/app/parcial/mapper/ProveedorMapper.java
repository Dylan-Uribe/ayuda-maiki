package com.app.parcial.mapper;

import com.app.parcial.dto.ProveedorDto;
import com.app.parcial.entity.Proveedor;
import java.util.List;
import java.util.stream.Collectors;

public class ProveedorMapper {
    public static ProveedorDto toEntityDto(Proveedor proveedor) {
        return new ProveedorDto(
                proveedor.getId(),
                proveedor.getFirstName(),
                proveedor.getLastName(),
                proveedor.getBirthDate(),
                proveedor.getTipoProveedor(),
                proveedor.getNit(),
                proveedor.getDescuento()
        );
    }
    public static Proveedor toEntity(ProveedorDto proveedorDto) {
        return new Proveedor(
                proveedorDto.getId(),
                proveedorDto.getFirstName(),
                proveedorDto.getLastName(),
                proveedorDto.getBirthDate(),
                proveedorDto.getTipoProveedor(),
                proveedorDto.getNit(),
                proveedorDto.getDescuento()
        );
    }

    public static List<ProveedorDto> toEntityDtoList(List<Proveedor> proveedores) {
        return proveedores.stream()
                .map(ProveedorMapper::toEntityDto)
                .collect(Collectors.toList());
    }
}
