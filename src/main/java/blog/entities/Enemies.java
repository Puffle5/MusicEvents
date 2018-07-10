package blog.entities;

import javax.persistence.*;

@Entity
@Table(name = "enemies")
public class Enemies {
    private Integer id;
    private String name;
    private Elly elly;

    public Enemies() {
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
    @ManyToOne()
    @JoinColumn(name = "ellyId")
    public Elly getElly() {
        return elly;
    }

    public void setElly(Elly elly) {
        this.elly = elly;
    }
}
