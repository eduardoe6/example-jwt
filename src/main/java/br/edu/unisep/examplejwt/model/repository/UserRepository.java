package br.edu.unisep.examplejwt.model.repository;

import br.edu.unisep.examplejwt.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // é igual a => @Query("select u from User where login = :LOGIN);
    User findByLogin(String login);

}
