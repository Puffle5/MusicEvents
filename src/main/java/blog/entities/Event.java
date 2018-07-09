package blog.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {
    private Integer id;
    private Date date;
    private String place;
    private String city;
    private Integer maxSeats;
    private Integer bookedSeats;
    private Performer performer;


    public Event() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Column(name = "place")
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Column(name = "max_seats")
    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }
    @Column(name = "booked_seats")
    public Integer getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(Integer bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

//    @ManyToOne()
//    @JoinColumn(name = "performer_id")
//    public Performer getPerformer() {
//        return performer;
//    }
//
//    public void setPerformer(Performer performer) {
//        this.performer = performer;
//    }
}
