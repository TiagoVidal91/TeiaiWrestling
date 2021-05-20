package com.TeiaiWrestling.TeiaiWrestling.Entities;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Wrestlingmatch")
public class Match {

    @Id
    @GeneratedValue
    private Long id;
    private String winner;
    private String loser;
    private String noWin;
    private String draw1;
    private String draw2;
    @ManyToOne
    private MatchType matchType;
    @ManyToOne
    private WrestlingCard wrestlingCard;

    private int rating;

}
