package br.com.fiap.cpdoix.entity;

import br.com.fiap.cpdoix.enums.ToyClassification;
import br.com.fiap.cpdoix.enums.ToySize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TAB_TOY")

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Toy {

    @Id
    @Column(name = "id_toy")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nm_toy", length = 50, nullable = false)
    private String name;

    @NotNull
    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "classification")
    private ToyClassification classification;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "toy_size")
    private ToySize size;

    @NotNull
    @Positive
    @Column(name = "nr_price")
    private double price;
}
