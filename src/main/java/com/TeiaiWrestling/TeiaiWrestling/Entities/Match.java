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
    @ElementCollection
    private List<String> victory = new ArrayList<>();
    @ElementCollection
    private List<String> loss = new ArrayList<>();
    @ElementCollection
    private List<String> noWin = new ArrayList<>();
    @ElementCollection
    private List<String> draw = new ArrayList<>();
    @ManyToOne
    private MatchType matchType;
    @ManyToOne
    private WrestlingCard wrestlingCard;

    private int rating;

}
