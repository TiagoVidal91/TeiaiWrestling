package com.TeiaiWrestling.TeiaiWrestling.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "matchtype")
public class MatchType {

    @Id
    private Long id;
    private String name;
}
