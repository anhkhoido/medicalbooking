package com.anhkhoido.pomelo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToOne
    private Patient patient;

    @OneToOne
    private Provider provider;

    @Column(name = "startDateTime")
    private Timestamp startDateTime;

    @Column(name = "endDateTime")
    private Timestamp endDateTime;

}
