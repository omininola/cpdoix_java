package br.com.fiap.cpdoix.dto;

import br.com.fiap.cpdoix.enums.ToyClassification;
import br.com.fiap.cpdoix.enums.ToySize;

public record ToyRes(
    Long id,
    String name,
    String type,
    ToyClassification classification,
    ToySize size,
    double price
) {  
}
