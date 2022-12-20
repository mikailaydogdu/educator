package com.app.educator.entity.location;

import com.app.educator.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "county")
public class Country extends BaseLocation{

}
