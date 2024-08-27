package com.intern.layoutviews.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LayoutAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Layout layout;

    @ManyToOne
    private User user;

    @ManyToOne
    private UserGroup userGroup;

}

