package com.tms.tenderer;

public record BidRequest (

   Long toBidId,
   String toBidFullName,
    String message)
{}
