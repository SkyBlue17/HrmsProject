package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "activations_code")
@AllArgsConstructor
@NoArgsConstructor
public class ActivationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "activation_code")
    private String activationCode;
    @Column(name = "is_confirmed")
    private boolean isConfirmed;
    @Column(name = "confirmed_date")
    private Date confirmedDate;
}
