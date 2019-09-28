package pl.epilog.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "factors")
public class Factor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double probability;
    private LocalDateTime created;

    public String getName() {
        return name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Long getId() {
        return id;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

}