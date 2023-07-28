package com.alston.dao;

import com.alston.dto.BtbType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface BtbTypeRepository extends JpaRepository<BtbType, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM ( " +
                    "SELECT NO,TYPE,BAN,STATUS,CONT_EMAIL FROM BTB_OAF_BTB001 UNION " +
                    "SELECT NO,TYPE,BAN,STATUS,CONT_EMAIL FROM BTB_OAF_BTB002 UNION " +
                    "SELECT NO,TYPE,BAN,STATUS,CONT_EMAIL FROM BTB_OAF_BTB004 UNION " +
                    "SELECT NO,TYPE,BAN,STATUS,CONT_EMAIL FROM BTB_OAF_BTB005 UNION " +
                    "SELECT NO,TYPE,BAN,STATUS,CONT_EMAIL FROM BTB_OAF_BTB006) AS B " +
                    "WHERE  NO = :serviceCaseNo ")
    BtbType findBtbType(@Param("serviceCaseNo") Integer serviceCaseNo);

}