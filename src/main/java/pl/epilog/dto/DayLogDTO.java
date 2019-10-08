package pl.epilog.dto;

import pl.epilog.model.Factor;
import pl.epilog.model.User;

import java.time.LocalDateTime;
import java.util.List;

public class DayLogDTO {

    private List<Factor> factors;
    private boolean attack;
    private LocalDateTime created;
    private User user;

    public DayLogDTO() {
    }

    public DayLogDTO(List<Factor> factors, boolean attack, LocalDateTime created, User user) {
        this.factors = factors;
        this.attack = attack;
        this.created = created;
        this.user = user;
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
