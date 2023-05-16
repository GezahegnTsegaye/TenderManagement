package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "committee")
public class Committee {

  @Id
//  @GeneratedValue(generator = "committee_id_gen", strategy = GenerationType.SEQUENCE)
//  @SequenceGenerator(name = "committee_id_gen", sequenceName = "committee_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String employeePosition;
  private String address;

  public Committee(Long id, String firstName, String lastName, String employeePosition, String address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.employeePosition = employeePosition;
    this.address = address;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmployeePosition() {
    return employeePosition;
  }

  public void setEmployeePosition(String employeePosition) {
    this.employeePosition = employeePosition;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
