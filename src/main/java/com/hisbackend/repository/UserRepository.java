package com.hisbackend.repository;

import com.hisbackend.domain.entity.Patient;
import com.hisbackend.domain.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User save(User user);

    Optional<User> findByUsernameAndPassword(String username, String password);

    @Override
    List<User> findAll();

    @Modifying
    @Query(nativeQuery = true)
    void signIn(@Param("ID") long id);


}
