package com.alston.dao;

import com.alston.model.BtbOafBtb001Ip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BtbStatementRepository extends JpaRepository<BtbOafBtb001Ip, Integer> {

    @Query(value =
            "SELECT * FROM ( " +
                    "SELECT * FROM BTB_OAF_BTB001_IP UNION " +
                    "SELECT * FROM BTB_OAF_BTB002_IP UNION " +
                    "SELECT * FROM BTB_OAF_BTB004_IP UNION " +
                    "SELECT * FROM BTB_OAF_BTB005_IP UNION " +
                    "SELECT * FROM BTB_OAF_BTB006_IP) AS A " +
                    "WHERE APPLY_NO = :serviceCaseNo", nativeQuery = true)
    List<BtbOafBtb001Ip> findBtbIp(@Param("serviceCaseNo") Integer serviceCaseNo);

}
