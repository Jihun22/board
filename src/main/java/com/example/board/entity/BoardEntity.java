package com.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//DB의 테이블 역할을 하는 클래스
@Entity
@Getter
@Setter
@Table(name ="test")
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(length = 30, nullable = false)
    private  String boardWriter;


    @Column
    private  String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;


}
