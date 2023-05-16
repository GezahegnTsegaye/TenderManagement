package com.tms.controller;

import com.tms.service.TenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/tender")
public class TenderControllerImpl implements TenderController{

  private final TenderService  tenderService;


}
