package me.naming.demospringvue.controller;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.naming.demospringvue.dto.BoardDto;
import me.naming.demospringvue.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;

  @GetMapping("/main")
  public String hello(){
    return "/index";
  }

  @GetMapping("/boards/list")
  @ResponseBody
  public List<BoardDto> getBoards() {
    System.out.println(">>>> getBoards");
    return Arrays.asList(new BoardDto(1L, "게시판1")
        , new BoardDto(2L, "게시판2")
        , new BoardDto(3L, "게시판3"));
  }
}
