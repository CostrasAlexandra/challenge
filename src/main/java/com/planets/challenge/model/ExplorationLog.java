package com.planets.challenge.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Accessors(chain = true)
@Data
@Table(name = "explored_by")
public class ExplorationLog {

    @Data
    @Embeddable
    public static class ExplorationLogId implements Serializable {
        @Column(name = "planet_id")
        private long planetId;
        @Column(name = "robot_id")
        private long robotId;
    }

    @EmbeddedId
    private ExplorationLogId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "planet_id", insertable = false, updatable = false)
    private Planet planet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "robot_id", insertable = false, updatable = false)
    private Robot robot;

}
