package br.ravva.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_status")
@SequenceGenerator(name = "sq_id_status", sequenceName = "id_seq_status", allocationSize = 1)
public class StatusEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_status")
    private Long id;

    @Column
    private Long idScene;

    @Column
    private String userId;

    @ManyToOne
    @JoinColumn(name = "idScene", referencedColumnName = "idScene", insertable = false, updatable = false)
    private MapScene mapScene;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date timestamp;
}
