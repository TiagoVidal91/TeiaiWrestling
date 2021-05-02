package com.TeiaiWrestling.TeiaiWrestling.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "wrestling_card")
public class WrestlingCard {

    @Id
    private Long id;
    private int numberVictories;
    private int numberLosses;
    private int noWin;
    private int draw;
    private int streak;
    @OneToOne(mappedBy = "wrestlingCard")
    private Wrestler wrestler;
    private int totalMatches;
    private String totalAverage;
}
