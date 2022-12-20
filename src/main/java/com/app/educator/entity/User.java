package com.app.educator.entity;

import com.app.educator.entity.location.City;
import com.app.educator.entity.location.Country;
import com.app.educator.entity.location.District;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User extends BaseUser{

}
