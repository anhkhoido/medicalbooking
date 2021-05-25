package com.anhkhoido.pomelo.embeddedId;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonCompositePrimaryKey implements Serializable {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
}
