package com.anhkhoido.pomelo.model;

import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "provider")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Provider implements Serializable {

    @EmbeddedId
    private PersonCompositePrimaryKey providerCompositePrimaryKey;

    @OneToOne
    @JoinColumn(name = "fk_clinic", referencedColumnName = "name")
    private Clinic clinic;
}
