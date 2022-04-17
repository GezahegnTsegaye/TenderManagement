package com.tms.controller;


import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public record TendereeRequest(String firstName,String lastName) {


}
