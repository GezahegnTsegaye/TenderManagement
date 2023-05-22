package com.tms.controller;

import com.tms.dal.dto.TendererDTO;
import com.tms.service.TendererService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/tenderer")
public class TendererControllerImpl implements TendererController {

  private final TendererService tendererService;


  @Override
  @GetMapping
  public List<TendererDTO> getAllTenderers() {
    return tendererService.getAllTenderers();
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<TendererDTO> getTendererById(@PathVariable Long id) {
    TendererDTO tendererDTO = tendererService.getTendererById(id);
    return ResponseEntity.ok(tendererDTO);
  }

  @Override
  @PostMapping
  public ResponseEntity<TendererDTO> createTenderer(@RequestBody TendererDTO tendererDTO) {
    TendererDTO createdTenderer = tendererService.createTenderer(tendererDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdTenderer);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<TendererDTO> updateTenderer(@PathVariable Long id, @RequestBody TendererDTO tendererDTO) {
    TendererDTO updatedTenderer = tendererService.updateTenderer(id, tendererDTO);
    return ResponseEntity.ok(updatedTenderer);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTenderer(@PathVariable Long id) {
    tendererService.deleteTenderer(id);
    return ResponseEntity.noContent().build();
  }


}
