package ru.clmtra.inchatter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clmtra.inchatter.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    <S extends User> S save(S s);

    Optional<User> findByEmail(String email);

}
