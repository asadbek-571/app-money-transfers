package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "expire_date", nullable = false)
    private LocalDate expireDate;

    @Column(name = "active", nullable = false)
    private boolean active;
}
