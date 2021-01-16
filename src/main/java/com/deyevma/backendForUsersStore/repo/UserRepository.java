package com.deyevma.backendForUsersStore.repo;

import com.deyevma.backendForUsersStore.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {//or JpaRepository???
    Optional<User> findByNickName(String nickName);

    User findById(Long id);
}
