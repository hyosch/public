package com.alston.dao;

import com.alston.model.BtbOafBtb004;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BtbIp004Repository extends JpaRepository<BtbOafBtb004, Integer>,
        JpaSpecificationExecutor<BtbOafBtb004> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM ( " +
                    "SELECT * FROM BTB_OAF_BTB004 UNION " +
                    "SELECT * FROM BTB_OAF_BTB005 UNION " +
                    "SELECT * FROM BTB_OAF_BTB006  ) AS B " +
                    "WHERE  NO = :no ")
    BtbOafBtb004 findBtb004(@Param("no") Integer no);

//    @Query(nativeQuery = true,
//            value = "SELECT * FROM ( " +
//                    "SELECT NO,TYPE,BAN,STATUS,CONT_EMAIL FROM BTB_OAF_BTB004 UNION " +
//                    "SELECT NO,TYPE,BAN,STATUS,CONT_EMAIL FROM BTB_OAF_BTB005 UNION " +
//                    "SELECT NO,TYPE,BAN,STATUS,CONT_EMAIL FROM BTB_OAF_BTB006) AS C " +
//                    "WHERE  NO = :serviceCaseNo ")
//    BtbOafBtb004 findBtbType004(@Param("serviceCaseNo") Integer serviceCaseNo);

}