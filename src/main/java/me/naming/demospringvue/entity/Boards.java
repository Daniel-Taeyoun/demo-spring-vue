package me.naming.demospringvue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : naming
 * @packageName : me.naming.demospringvue.entity
 * @date : 2022/01/26
 * @description :
 */
@Entity
@Table(name = "BOARDS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Boards {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "BOARD_NO")
  private Long boardNo;

  @Column(name = "BOARD_TITLE", nullable = false)
  private String boardTitle;

}
