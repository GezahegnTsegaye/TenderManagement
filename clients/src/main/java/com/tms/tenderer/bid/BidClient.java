package com.tms.tenderer.bid;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "bid",
        url = "${clients.bid.url}"
)
public interface BidClient {

  @PostMapping("api/bid")
  void sendBidNotification(BidRequest bidRequest);
}
