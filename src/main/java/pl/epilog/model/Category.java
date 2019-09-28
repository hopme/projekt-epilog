package pl.epilog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "category") // wlasciciel relacji
    private List<Factor> factors;

}
