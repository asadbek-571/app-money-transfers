package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "income")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "form_card_id", nullable = false)
    private Card fromCardId;

    @ManyToOne
    @JoinColumn(name = "to_card_id", nullable = false)
    private Card toCardId;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "date", nullable = false)
    private Timestamp date;

}
