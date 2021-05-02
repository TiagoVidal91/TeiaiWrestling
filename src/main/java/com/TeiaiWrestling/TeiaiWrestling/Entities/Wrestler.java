package com.TeiaiWrestling.TeiaiWrestling.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "wrestler")
public class Wrestler {

    @Id
    private Long idWrestler;
    private String wrestlerName;
    private String fullName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wrestling_card_id", referencedColumnName = "id")
    private WrestlingCard wrestlingCard;
}
