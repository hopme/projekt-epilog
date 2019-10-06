package pl.epilog.model;

import javax.persistence.*;

@Entity
@Table(name = "corelations")
public class Corelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToOne
    private Factor factor;


    private Double corelation;













}
