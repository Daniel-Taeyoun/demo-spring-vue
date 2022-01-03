package me.naming.demospringvue.repository;

import static org.assertj.core.api.Assertions.assertThat;

import me.naming.demospringvue.entity.UserMgt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : naming
 * @packageName : me.naming.demospringvue.repository
 * @date : 2022/01/03
 * @description :
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMgtRepositoryTest {

  @Autowired
  private TestEntityManager testEntityManager;

  @Test
  public void insertUserMgt() {
    UserMgt userMgt = UserMgt.builder()
        .userId("dbTest")
        .pwd("dbTest1!23")
        .build();

    testEntityManager.persist(userMgt);

    assertThat(userMgt).isEqualTo(testEntityManager.find(UserMgt.class, userMgt.getUserNo()));
  }

}