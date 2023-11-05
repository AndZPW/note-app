package com.andzwp.noteservice.dao;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "notes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @Column(name = "notes_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "title")
    private String title;

    @Column(name = "content", nullable = false, length = 2100)
    private String content;
}
