package blog.entities;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {
    private Integer id;
    private String genreName;
    private Set<Performer> performers;
    public Genre() {
    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name ="genre_name")
    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "genres_performers")
    public Set<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(Set<Performer> performers) {
        this.performers = performers;
    }
}
