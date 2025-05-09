package br.com.fiap.cpdoix.controller;

import br.com.fiap.cpdoix.entity.Toy;
import br.com.fiap.cpdoix.repository.ToyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toys")
public class ToyController {

    @Autowired
    private ToyRepository toyRepository;

    @PostMapping
    public ResponseEntity<Toy> create(@RequestBody Toy toy) {
        toyRepository.save(toy);
        return ResponseEntity.ok().body(toy);
    }

    @GetMapping
    public Iterable<Toy> readAll() {
        return toyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Toy> readById(@PathVariable Long id) {
        Toy toy = toyRepository.findById(id).orElse(null);

        if (toy == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(toy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Toy> update(@PathVariable Long id, @RequestBody Toy toy) {
        Toy existingToy = toyRepository.findById(id).orElse(null);

        if (existingToy == null) {
            return ResponseEntity.notFound().build();
        }

        existingToy.setId(id);
        existingToy.setName(toy.getName());
        existingToy.setType(toy.getType());
        existingToy.setClassification(toy.getClassification());
        existingToy.setSize(toy.getSize());
        existingToy.setPrice(toy.getPrice());

        toyRepository.save(existingToy);
        return ResponseEntity.ok().body(existingToy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Toy> delete(@PathVariable Long id) {
        Toy toy = toyRepository.findById(id).orElse(null);

        if (toy == null) {
            return ResponseEntity.notFound().build();
        }

        toyRepository.delete(toy);
        return ResponseEntity.noContent().build();
    }
}
