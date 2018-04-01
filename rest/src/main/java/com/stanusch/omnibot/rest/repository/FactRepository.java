package com.stanusch.omnibot.rest.repository;

import com.stanusch.omnibot.rest.repository.model.id.EntityId;
import com.stanusch.omnibot.rest.repository.model.Fact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
interface FactRepository extends JpaRepository<Fact, EntityId> {
    List<Fact> findByName(@Param("name") String name);
    @RestResource(path = "findById")
    Optional<Fact> findByIdBotIdAndIdId(@Param("botId") Long botId, @Param("factId") Long factId);
    @RestResource(path = "findByFactId")
    List<Fact> findByIdId(@Param("factId") Long id);
    @RestResource(path = "findByBotId")
    Page<Fact> findByIdBotId(@Param("botId") Long botId, Pageable pageable);
}
