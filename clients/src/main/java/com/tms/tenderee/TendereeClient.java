package com.tms.tenderee;


import jakarta.annotation.PostConstruct;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "tenderee",
url = "${clients.tenderee.url}")
public interface TendereeClient {

  @PostConstruct
  public void sendTenderee(TendereeRequest tendereeRequest);
}
