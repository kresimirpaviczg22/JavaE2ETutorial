package com.eviden.e2e.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eviden.e2e.model.Organisation;

public interface OrganisationRepository extends JpaRepository<Organisation, Long>{
	
    @Query("select o from Organisation o WHERE o.id = :id")
    Organisation selectById(@Param("id") Long id);
    
    @Query("select o from Organisation o left join fetch o.users where o.id = :id")
    Organisation selectOrganisationAndUsers(@Param("id") Long id);

    @Modifying
    @Query("update Organisation o set o.name = :name where o.id = :id")
    void updateNameById(@Param("name") String name, @Param("id") Long id);
    
    @Modifying
    @Query("delete from Organisation o where o.id = :id")
    void deleteById(@Param("id") Long id);
}
