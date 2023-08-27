package com.study.boardOne.domin;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Post {

    private Long id;                       // PK
    private String title;                  // 제목
    private String content;                // 내용
    private String writer;                 // 작성자
    private int viewCnt;                   // 조회 수
    private Boolean noticeYn;              // 공지글 여부
    private Boolean deleteYn;              // 삭제 여부
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;     // 생성일시
    private LocalDateTime modifiedDate;    // 최종 수정일시

}