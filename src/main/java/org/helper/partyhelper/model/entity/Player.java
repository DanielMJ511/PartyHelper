package org.helper.partyhelper.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "players", indexes = @Index(name = "idx_player_name", columnList = "playerName"))
@Getter @Setter @NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String playerName;

    @Column(nullable = true)
    private String discordId;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<WarRecord> records;

}
