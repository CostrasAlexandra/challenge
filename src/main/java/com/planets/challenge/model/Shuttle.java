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
@Table(name = "shuttles")
public class Shuttle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "team_id", insertable = false, updatable = false)
    private Team team;

    @Column(name = "team_id")
    private long teamId;

    @OneToMany(mappedBy = "shuttle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Planet> route = new HashSet<>();

    private long x;

    private long y;

    private long z;
}
