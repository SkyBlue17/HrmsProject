package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "employers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employers extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "website")
    private String website;
    @Column(name = "phone_number")
    private  String phoneNumber;
    @Column(name = "is_activated")
    private boolean isActivated;
}
