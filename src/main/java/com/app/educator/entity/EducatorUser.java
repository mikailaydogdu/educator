package com.app.educator.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "educatorUser")
public class EducatorUser extends BaseUser{

    @Column(name = "status")
    private Boolean status;
}
