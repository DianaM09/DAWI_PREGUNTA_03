package pe.edu.i202030258.cl1_jpa_data_medina_diana.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class city {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String district;
    private Integer population;

    @ManyToOne
    @JoinColumn(name = "country_code")
    private country country;

}
