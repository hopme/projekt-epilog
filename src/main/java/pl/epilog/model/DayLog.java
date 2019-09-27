package pl.epilog.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "daylogs")
public class DayLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(nullable = false, length = 500)

    private boolean breakfast;
    private boolean dinner;
    private boolean sapper;
    @OneToMany
    private List<Factor> factors; //alko + papierosy
    private boolean attack;
    private LocalDateTime wakeUpHour;
    private LocalDateTime goBedHour;
    private LocalDateTime created;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;


}

