package com.example.first_java_project.DAO.repository;

import com.example.first_java_project.DAO.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    // 모든 사용자 조회
    List<User> findAll();
    // 사용자 아이디로 사용자 조회
    Optional<User> findByUserid(Long userId);

    //사용자 저장(또는 업데이트)
    User save(User user);
    //사용자 삭제
    void deleteByUserid(Long userId);

    // 사용자 이름으로 사용자 조회 (사용자 정의 메소드)
    Optional<User> findByUserName(String userName);

}
