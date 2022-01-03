package me.naming.demospringvue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : naming
 * @packageName : me.naming.demospringvue.entity
 * @date : 2022/01/03
 * @description :
 */
@Entity
@Table(name = "USERMGT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMgt {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "USER_NO")
  private Long userNo;

  @Column(name = "USER_ID", nullable = false)
  private String userId;

  @Column(name = "PWD", nullable = false)
  private String pwd;

  @Builder
  public UserMgt(String userId, String pwd) {
    this.userId = userId;
    this.pwd = pwd;
  }

}
