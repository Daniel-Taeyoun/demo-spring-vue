package me.naming.demospringvue.repository;

import me.naming.demospringvue.entity.Boards;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : naming
 * @packageName : me.naming.demospringvue.repository
 * @date : 2022/01/26
 * @description :
 */
public interface BoardRepository extends JpaRepository<Boards, Integer> {

}
