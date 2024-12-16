package br.ravva.core.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_mapscene")
@SequenceGenerator(name = "sq_id_scene", sequenceName = "id_seq_scene", allocationSize = 1)
public class MapScene {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_scene")
    private Long idScene;

    @Column
    private String description;

    @Column
    private String triggerEvent;

    @JsonIgnoreProperties("scene")
    @OneToMany(mappedBy = "scene")
    private List<CoordinatesMap> coordinates;

}
