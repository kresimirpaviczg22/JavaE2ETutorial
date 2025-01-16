package com.eviden.e2e.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eviden.e2e.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Modifying
    @Query("delete from Contract c WHERE c.id = :id")
    void deleteById(@Param("id") Long id);
 
    @Query("select count(*) from Contract")
    Long getContractCount();

    @Query("SELECT c FROM Contract c WHERE c.endDate >= :fromToday and c.endDate <= :toDate")
    List<Contract> findAllExpiringContracts(@Param("fromToday") LocalDate fromToday, @Param("toDate") LocalDate toDate);
    
}

