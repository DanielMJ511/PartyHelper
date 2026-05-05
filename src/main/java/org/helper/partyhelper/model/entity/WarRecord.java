package org.helper.partyhelper.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity

public class WarRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Player player;

    private int kills;
    private int deaths;
    private long dmgToPlayers;



}
