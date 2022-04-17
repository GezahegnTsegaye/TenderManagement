package com.tms.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("api/v1/tenderees")
public record TendereeController(TendereeService tendereeService) {

    @PostMapping
    public void registerTenderee(@RequestBody TendereeRequest tendereeRequest){
        log.info("new Tenderee registration {}", tendereeRequest);

    }
}
