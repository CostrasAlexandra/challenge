package com.planets.challenge.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "teams")
@Accessors(chain = true)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "captain_id", insertable = false, updatable = false)
    private Captain captain;

    @Column(name = "captain_id")
    private long captainId;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private Set<Robot> robots = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "shuttle_id", insertable = false, updatable = false)
    private Shuttle shuttle;

    @Column(name = "shuttle_id")
    private long shuttle_id;
}
