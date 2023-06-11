package com.bezkoder.spring.security.modules.login.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table
(
    name = "doctors",
    uniqueConstraints = 
    {
       @UniqueConstraint(columnNames = "crm")
    }
)

public class Doctor
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 120)
  private String name;

  @NotBlank
  @Size(max = 120)
  private String specialty;

  @NotBlank
  @Size(max = 120)
  private String crm;

  @ManyToOne
  @JoinColumn(name="id_user", nullable=false)
  private User user;


  public Doctor() 
  {
  }

  public Doctor
  (
		String name, String crm, User user, String specialty
  ) 
  {
	  this.name = name;
    this.crm = crm;
    this.user = user;
    this.specialty = specialty;
  }

  public Doctor
  (
		long id,String name, String crm, User user, String specialty
  ) 
  {
    this.id = id;
	  this.name = name;
    this.crm = crm;
    this.user = user;
    this.specialty = specialty;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCrm() {
    return crm;
  }

  public void setCrm(String crm) {
    this.crm = crm;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
