package com.example.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="JobTitles")
@Data
public class JobTitles {
    @Id
    @GeneratedValue
    @Column(name="TitleId")
    private int titleId;

    @Column(name="Title")
    private String title;

    public JobTitles(int titleId, String title) {
        super();
        this.setTitleId(titleId);
        this.title = title;
    }

    public JobTitles() {

    }
}
