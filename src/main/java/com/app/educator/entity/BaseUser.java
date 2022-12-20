package com.app.educator.entity;
import com.app.educator.entity.location.City;
import com.app.educator.entity.location.Country;
import com.app.educator.entity.location.District;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String userName;

    @Column(name = "deleted")
    private Boolean deleted=false;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "bio")
    private String bio;

    @Column(name = "image" ,length = 1000)
    private byte[] img;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date =new Date();

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

//    @ManyToMany
//    private List<Tags> tags = new ArrayList<>();
}
