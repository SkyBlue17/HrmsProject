package com.example.hrms.entities.concretes;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="job_titles")
@Data
public class JobTitles {
    @Id
    @Column(name="title_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int titleId;

    @Column(name="title")
    private String title;


}
