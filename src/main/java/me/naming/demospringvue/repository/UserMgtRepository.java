package me.naming.demospringvue.repository;

import me.naming.demospringvue.entity.UserMgt;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : naming
 * @packageName : me.naming.demospringvue.repository
 * @date : 2022/01/03
 * @description :
 */
public interface UserMgtRepository extends JpaRepository<UserMgt, Integer> {

  UserMgt getUserMgtByUserId(String userId);

}
