package br.com.fiap.cpdoix.dto;

import br.com.fiap.cpdoix.enums.ToyClassification;
import br.com.fiap.cpdoix.enums.ToySize;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ToyReq(
    @NotBlank(message = "The name cannot be empty")
    String name,

    @NotBlank(message = "The type cannot be empty")
    String type,

    @NotNull(message = "The classification cannot be null")
    ToyClassification classification,
    
    @NotNull(message = "The size cannot be null")
    ToySize size,

    @NotNull(message = "The price cannot be null")
    @Positive(message = "The price must be greater than 0")
    @Column(name = "nr_price", nullable = false)
    double price
) {
}
