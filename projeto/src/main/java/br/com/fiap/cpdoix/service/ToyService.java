package br.com.fiap.cpdoix.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.cpdoix.dto.ToyReq;
import br.com.fiap.cpdoix.dto.ToyRes;
import br.com.fiap.cpdoix.entity.Toy;

@Service
public class ToyService {
  public Toy reqToToy(ToyReq toyReq) {
    Toy newToy = new Toy();

    newToy.setName(toyReq.name());
    newToy.setType(toyReq.type());
    newToy.setClassification(toyReq.classification());
    newToy.setSize(toyReq.size());
    newToy.setPrice(toyReq.price());

    return newToy;
  }

  public ToyRes toyToRes(Toy toy) {
    return new ToyRes(
        toy.getId(),
        toy.getName(),
        toy.getType(),
        toy.getClassification(),
        toy.getSize(),
        toy.getPrice());
  }

  public List<ToyRes> toyToRes(List<Toy> toys) {
    List<ToyRes> toysRes = toys.stream()
        .map(this::toyToRes)
        .collect(Collectors.toList());

    return toysRes;
  }
}
