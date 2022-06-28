package com.tms.controller;

import com.tms.model.TenderDetail;
import org.springframework.stereotype.Service;

@Service
public record TendereeService () {

    public void registerTenderee(TendereeRequest tendereeRequest){
        int yearrange = tendereeRequest.getAge();
      //  TenderDetail tendereeDetail = TenderDetail.builder().firstName(tendereeRequest.firstName()).build();
    }
}
