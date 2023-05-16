package com.tms.tenderer.bid;

public record BidRequest (

   Long toBidId,
   String toBidFullName,
    String message)
{}
