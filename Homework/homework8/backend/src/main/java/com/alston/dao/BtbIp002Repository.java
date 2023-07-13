package com.alston.dao;

import com.alston.model.BtbOafBtb002;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BtbIp002Repository extends JpaRepository<BtbOafBtb002, Integer>,
        JpaSpecificationExecutor<BtbOafBtb002> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM ( " +
                    "SELECT * FROM BTB_OAF_BTB001 UNION " +
                    "SELECT * FROM BTB_OAF_BTB002 ) AS A " +
                    "WHERE  NO = :no ")
    BtbOafBtb002 findBtb002(@Param("no") Integer no);

}