package com.tms.controller;

import com.tms.model.TendereeDetail;
import org.springframework.stereotype.Service;

@Service
public record TendereeService () {

    public void registerTenderee(TendereeRequest tendereeRequest){
        TendereeDetail  tendereeDetail = TendereeDetail.builder().firstName(tendereeRequest.firstName()).build();
    }
}
