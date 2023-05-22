package com.tms.controller;

import com.tms.dal.dto.TendererDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TendererController {
  @GetMapping
  List<TendererDTO> getAllTenderers();

  @GetMapping("/{id}")
  ResponseEntity<TendererDTO> getTendererById(@PathVariable Long id);

  @PostMapping
  ResponseEntity<TendererDTO> createTenderer(@RequestBody TendererDTO tendererDTO);

  @PutMapping("/{id}")
  ResponseEntity<TendererDTO> updateTenderer(@PathVariable Long id, @RequestBody TendererDTO tendererDTO);

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteTenderer(@PathVariable Long id);
}
