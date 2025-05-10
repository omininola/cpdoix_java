package br.com.fiap.cpdoix.controller;

import br.com.fiap.cpdoix.dto.ToyReq;
import br.com.fiap.cpdoix.dto.ToyRes;
import br.com.fiap.cpdoix.entity.Toy;
import br.com.fiap.cpdoix.repository.ToyRepository;
import br.com.fiap.cpdoix.service.ToyService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brinquedos")
public class ToyController {

    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private ToyService toyService;

    @PostMapping
    public ResponseEntity<ToyRes> create(@Valid @RequestBody ToyReq toyReq) {
        Toy createdToy = toyRepository.save(toyService.reqToToy(toyReq));
        return ResponseEntity.ok(toyService.toyToRes(createdToy));
    }

    @GetMapping
    public ResponseEntity<List<ToyRes>> readAll() {
        List<Toy> toys = toyRepository.findAll();
        return ResponseEntity.ok(toyService.toyToRes(toys));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToyRes> readById(@PathVariable Long id) {
        Optional<Toy> toy = toyRepository.findById(id);

        if (toy.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(toyService.toyToRes(toy.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToyRes> update(@PathVariable Long id, @Valid @RequestBody ToyReq toyReq) {
        Optional<Toy> existingToy = toyRepository.findById(id);

        if (existingToy.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Toy toy = toyService.reqToToy(toyReq);
        toy.setId(existingToy.get().getId());
        Toy savedToy = toyRepository.save(toy);

        return ResponseEntity.ok(toyService.toyToRes(savedToy));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Toy> delete(@PathVariable Long id) {
        Optional<Toy> toy = toyRepository.findById(id);

        if (toy.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        toyRepository.delete(toy.get());
        return ResponseEntity.noContent().build();
    }
}
