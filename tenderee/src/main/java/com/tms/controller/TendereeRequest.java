package com.tms.controller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class TendereeRequest {

    private String firstName;
    private String lastName;
    private Integer age;
    private String address;

}
