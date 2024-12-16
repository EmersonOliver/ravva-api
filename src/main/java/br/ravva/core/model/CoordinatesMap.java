package br.ravva.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_coordinate")
@SequenceGenerator(name = "sq_id_coordinator", sequenceName = "id_seq_coordinator", allocationSize = 1)
public class CoordinatesMap {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_coordinator")
    private Long idCordinate;

    @Column
    private Long idScene;

    @Column
    private String x;

    @Column
    private String y;

    @Column
    private String status;

    @JsonIgnoreProperties("coordinates")
    @ManyToOne
    @JoinColumn(name = "idScene", referencedColumnName = "idScene", updatable = false, insertable = false)
    private MapScene scene;
}
