package br.com.fiap.cpdoix.entity;

import br.com.fiap.cpdoix.enums.ToyClassification;
import br.com.fiap.cpdoix.enums.ToySize;
import jakarta.persistence.*;
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

    @Column(name = "nm_toy", length = 50, nullable = false)
    private String name;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "classification")
    private ToyClassification classification;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "toy_size")
    private ToySize size;

    @Column(name = "nr_price", nullable = false)
    private double price;
}
