package blog.entities;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
    private Integer id;
    private String userName;
    private String userEmail;
    private String userPhone;
    private Integer ticketCount;
    private Event event;
    public Reservation() {}

    public Reservation(String userName, String userEmail, String userPhone, Integer ticketCount) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.ticketCount = ticketCount;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    @Column(name = "user_phone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    @Column(name = "ticket_count")
    public Integer getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(Integer ticketCount) {
        this.ticketCount = ticketCount;
    }
    @ManyToOne()
    @JoinColumn(name = "eventId")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
