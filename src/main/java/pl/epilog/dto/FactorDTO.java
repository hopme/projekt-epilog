package pl.epilog.dto;

import pl.epilog.model.Category;

import java.time.LocalDateTime;

public class FactorDTO {

    private String name;
    private Category category;
    private LocalDateTime created;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
