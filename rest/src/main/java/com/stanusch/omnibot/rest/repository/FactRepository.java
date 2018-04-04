package com.stanusch.omnibot.rest.repository;

import com.stanusch.omnibot.rest.repository.model.Fact;
import com.stanusch.omnibot.rest.repository.model.id.EntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
interface FactRepository extends JpaRepository<Fact, EntityId> {

//    List<Fact> findByName(@Param("name") String name);
//    @RestResource(path = "findById")
//    Optional<Fact> findByIdBotIdAndIdId(@Param("botId") Long botId, @Param("factId") Long factId);
//    @RestResource(path = "findByFactId")
//    List<Fact> findById(@Param("factId") Long id);
//    @RestResource(path = "findByBotId")
//    Page<Fact> findByBotId(@Param("botId") Long botId, Pageable pageable);
}
