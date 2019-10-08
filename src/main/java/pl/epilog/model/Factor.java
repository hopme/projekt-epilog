package pl.epilog.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "factors")
public class Factor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    private Correlation correlation;
    @ManyToOne
    private Category category;
    private LocalDateTime created;

    @ManyToMany(mappedBy = "factors")
    private List<DayLog> daylogs = new ArrayList<>();

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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



}