package me.naming.demospringvue.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.naming.demospringvue.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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
  public ModelMap getBoards(ModelMap modelMap) {
    log.info("***** getBoards");
    modelMap.put("list", boardService.getBoardList());
    return modelMap;
  }
}
