package me.naming.demospringvue.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.naming.demospringvue.dto.BoardDto;
import me.naming.demospringvue.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("/boards")
  @ResponseBody
  public Map<String, Object> getBoards(@RequestParam(value = "start") int page, @RequestParam(value = "length") int rows) {

    List<BoardDto> testList = Arrays.asList(new BoardDto(1L, "게시판1")
        , new BoardDto(2L, "게시판2")
        , new BoardDto(3L, "게시판3")
        , new BoardDto(4L, "게시판2")
        , new BoardDto(5L, "게시판3")
        , new BoardDto(6L, "게시판2")
        , new BoardDto(7L, "게시판3")
        , new BoardDto(8L, "게시판2")
        , new BoardDto(9L, "게시판3")
        , new BoardDto(10L, "게시판2")
        , new BoardDto(11L, "게시판3")
        , new BoardDto(12L, "게시판2")
        , new BoardDto(13L, "게시판3")
        , new BoardDto(14L, "게시판2")
        , new BoardDto(15L, "게시판3")
    );

    List<BoardDto> outputList = new ArrayList<>();
    for(int i = (page - 1)  * 10; i < page * rows; i++) {
      if(testList.size() > i) {
        outputList.add(testList.get(i));
      }
    }

    Map<String, Object> objectMap = new HashMap<>();
    objectMap.put("list", outputList);
    objectMap.put("count", testList.size());

    return objectMap;
  }
}
