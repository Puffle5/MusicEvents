
package blog.entities;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "performers")
public class Performer {
    private Integer id;
    private String name;
    private String bio;
    private Set<Event> events;

    public Performer(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }
    public Performer() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "bio")
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    @OneToMany(mappedBy = "performer")
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
