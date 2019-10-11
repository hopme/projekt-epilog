package pl.epilog.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "daylogs")
public class DayLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(nullable = false, length = 500)


    @Size(min = 1, message = "Musi być przynajmniej 1 factor")

    @ManyToMany
    @JoinTable(name = "daylogs_factors",
            joinColumns = @JoinColumn(name = "daylog_id"),
            inverseJoinColumns = @JoinColumn(name = "factor_id")
    )
    private List<Factor> factors = new ArrayList<>(); //alko + papierosy
    private boolean attack;
    private LocalDateTime created;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Factor> getFactors() {
        return factors;
    }

    public void setFactors(List<Factor> factors) {
        this.factors = factors;
    }

    public boolean getAttack() {
        return attack;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

