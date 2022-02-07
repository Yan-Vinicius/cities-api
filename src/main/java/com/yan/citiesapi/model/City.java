package com.yan.citiesapi.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Table(name = "cidade")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id")
    private State uf;

    private Integer ibge;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point lat_lon;

    private Double latitude;

    private Double longitude;

    private Integer cod_tom;

}
