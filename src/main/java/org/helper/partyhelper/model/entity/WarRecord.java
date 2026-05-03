package org.helper.partyhelper.model.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity

public class WarRecord {
    @Id
    private Long id;
    private Date date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Player player;

    private int kills;
    private int deaths;
    private long dmgToPlayers;



}
