package com.tms.tenderer;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "tenderer",
        url = "${clients.tenderer.url}")
public interface TendererClient {




}
