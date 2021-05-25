package com.anhkhoido.pomelo.model;

import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient implements Serializable {

    @EmbeddedId
    private PersonCompositePrimaryKey patientCompositeKey;

    @OneToOne
    @JoinColumn(name = "fk_clinic", referencedColumnName = "name")
    private Clinic clinic;
}
