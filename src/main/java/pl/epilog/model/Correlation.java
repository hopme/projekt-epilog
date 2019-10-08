package pl.epilog.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "correlations")
public class Correlation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Factor factor;

    @ManyToOne
    private User user;

    private Double correlationMeasure;
    private LocalDateTime created;


    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    public Long getId() {
        return id;
    }

    public Double getCorrelationMeasure() {
        return correlationMeasure;
    }

    public void setCorrelationMeasure(Double correlationMeasure) {
        this.correlationMeasure = correlationMeasure;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
