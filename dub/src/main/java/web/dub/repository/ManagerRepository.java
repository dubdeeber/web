package web.dub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.dub.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, String> {
    Manager findByUsername(String username);
}
