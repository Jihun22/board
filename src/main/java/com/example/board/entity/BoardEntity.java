package com.example.board.entity;

import jakarta.persistence.*;
//DB의 테이블 역할을 하는 클래스
@Entity
@Table(name ="test")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(length = 30, nullable = false)
    private  String boardWriter;


    @Column
    private  String boardTitle;
}
