package com.github.pvkr.todo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "todo")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "summary")
    private String summary;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TodoStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "details")
    private String details;
}
