package web.dub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.dub.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
