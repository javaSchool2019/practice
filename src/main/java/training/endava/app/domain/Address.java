package training.endava.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESSES")
@Data
@NoArgsConstructor
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String country;
    @NotNull
    private String city;
    @NotNull
    private String street;
}
