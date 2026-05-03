package org.helper.partyhelper.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class Player {
    @Id
    private String discordId;
    private String name;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<WarRecord> records;
}
