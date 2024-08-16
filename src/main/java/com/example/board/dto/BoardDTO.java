package com.example.board.dto;

import com.example.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class BoardDTO {
    //데이터를 전송할때 사용하는 객체
    //ID
    private long id;

    //글쓰기
    private String boardWriter;

    //pw
    private String boardPass;

    //제목
    private String boardTitle;

    //내용
    private String boardContents;

    //조회수
    private int boardHits;

    //게시물 작성시간
    private LocalDateTime boardCreateTime;

    //게시물 수정시간
    private LocalDateTime boardUpdateTime;

    public static BoardDTO toBoardDTO (BoardEntity boardEntity) {
      BoardDTO boardDTO = new BoardDTO();
      boardDTO.setId(boardEntity.getId());
      boardDTO.setBoardWriter(boardEntity.getBoardWriter());
      boardDTO.setBoardPass(boardEntity.getBoardPass());
      boardDTO.setBoardTitle(boardEntity.getBoardTitle());
      boardDTO.setBoardContents(boardEntity.getBoardContents());
      boardDTO.setBoardHits(boardEntity.getBoardHits());
      boardDTO.setBoardCreateTime(boardEntity.getCreatedTime());
      boardDTO.setBoardUpdateTime(boardEntity.getUpdatedTime());
    return boardDTO;
    }




}
