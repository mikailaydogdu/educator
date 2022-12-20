package com.app.educator.entity.location;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "district")
public class District extends BaseLocation{

    @ManyToOne
    private City city;
}
