package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "system_personnel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemPersonnel extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name = "nationality_number")
    private String nationalityNumber;
    @Column(name = "job_position")
    private String jobPosition;

}
