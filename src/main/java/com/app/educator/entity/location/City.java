package com.app.educator.entity.location;
import com.app.educator.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "city")
public class City extends BaseLocation{

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
}
