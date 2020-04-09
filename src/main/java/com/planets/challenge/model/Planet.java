package com.planets.challenge.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Lob
    @Column(name = "image", nullable = true)
    private byte[] image;

    private String description;

    private long x;

    private long y;

    private long z;

    @Enumerated(EnumType.STRING)
    private PlanetVisitationStatus status;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "shuttle_id", insertable = false, updatable = false)
    private Shuttle shuttle;

    @Column(name = "shuttle_id")
    private long shuttleId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "explored_by",
            joinColumns = @JoinColumn(name = "planet_id"),
            inverseJoinColumns = @JoinColumn(name = "robot_id")
    )
    private Set<Robot> robots = new HashSet<>();
}
