package me.naming.demospringvue.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.naming.demospringvue.entity.Boards;
import me.naming.demospringvue.repository.BoardRepository;
import org.springframework.stereotype.Service;

/**
 * @author : naming
 * @packageName : me.naming.demospringvue.service
 * @date : 2022/01/26
 * @description :
 */
@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  public List<Boards> getBoardList() {
    return boardRepository.findAll();
  }

}
