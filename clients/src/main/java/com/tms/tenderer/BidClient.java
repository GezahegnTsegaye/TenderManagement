package com.tms.tenderer;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "bid",
        url = "${clients.bid.url}"
)
public interface BidClient {

  @PostMapping("api/v2/bid")
  void sendBidNotification(BidRequest bidRequest);
}
