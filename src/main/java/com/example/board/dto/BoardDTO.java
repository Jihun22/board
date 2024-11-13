package com.example.board.dto;

import com.example.board.entity.BoardEntity;
import com.example.board.entity.BoardFileEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    //파일첨부

    private List<MultipartFile> boardFile; //save.html -> Controller 파일 담는 용
    private  List<String> originalFileName;   //원본 파일 이름
    private  List<String>  storedFileName;    // 서버 저장용 파일 이름
    private  int fileAttached; // 파일 첨부 여부 ( 첨부 1, 미첨부 0)

    public BoardDTO(Long id, String boardWriter, String boardTitle, int boardHits, LocalDateTime createdTime) {
        this.id = id;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardHits = boardHits;
        this.boardCreateTime = createdTime;

    }


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

      if(boardEntity.getFileAttached()==0) {
          boardDTO.setFileAttached(boardEntity.getFileAttached());//0
      } else {
          List<String> originalFileNameList = new ArrayList<>();
          List<String> storedFileNameList = new ArrayList<>();
          boardDTO.setFileAttached(boardEntity.getFileAttached()); //1
          //파일 이름 가져와야함
          // orginalFileName, storeFileName : board_file_table(BoardFileEntity)
          //join
          //select* from board_table b, board_file_table bf where b.id -bf.board_id
          // and where b.id=?

          for (BoardFileEntity boardFileEntity : boardEntity.getBoardFileEntityList()) {
             originalFileNameList.add(boardFileEntity.getOriginalFileName()); //오리지널 리스트에 하나하나씩 담는다
             storedFileNameList.add(boardFileEntity.getStoredFileName()); // 서버 파일 리스트에 담는다
              System.out.println("getOriginalFileName:"+boardFileEntity.getOriginalFileName());
              System.out.println("getStoredFileName:"+boardFileEntity.getStoredFileName());
          }
          boardDTO.setOriginalFileName(originalFileNameList);
          boardDTO.setStoredFileName(storedFileNameList);
      }
    return boardDTO;
    }




}