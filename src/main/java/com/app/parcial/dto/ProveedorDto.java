package com.app.parcial.dto;

import com.app.parcial.entity.enums.TipoProveedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private TipoProveedor tipoProveedor;
    private String nit;
    private Float descuento;
}
