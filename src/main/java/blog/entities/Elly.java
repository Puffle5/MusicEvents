package blog.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ellies")
public class Elly {
    private Integer id;
    private String name;
    private Set<Enemies> enemies;
    public Elly() {
    }

    public Elly(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name ="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(mappedBy = "elly") //could be a bug
    public Set<Enemies> getEnemies() {
        return enemies;
    }

    public void setEnemies(Set<Enemies> enemies) {
        this.enemies = enemies;
    }
}
