package pe.edu.i202030258.cl1_jpa_data_medina_diana.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class countrylanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String language;
    private Boolean isOfficial;
    private Double percentage;

    // Relación con Country
    @ManyToOne
    @JoinColumn(name = "country_code")
    private country country; //


}
