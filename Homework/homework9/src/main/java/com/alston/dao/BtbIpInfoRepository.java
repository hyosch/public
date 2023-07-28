package com.alston.dao;

import com.alston.dto.BtbIpInfo;
import com.alston.dto.BtbIpType;
import com.alston.model.BtbOafBtb002;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BtbIpInfoRepository extends JpaRepository<BtbIpInfo, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM ( " +
                    "SELECT No,APPLY_DATE,STATUS,BAN,APPROVED_DATE FROM BTB_OAF_BTB001 UNION " +
                    "SELECT No,APPLY_DATE,STATUS,BAN,APPROVED_DATE FROM BTB_OAF_BTB002 UNION " +
                    "SELECT No,APPLY_DATE,STATUS,BAN,APPROVED_DATE FROM BTB_OAF_BTB004 UNION " +
                    "SELECT No,APPLY_DATE,STATUS,BAN,APPROVED_DATE FROM BTB_OAF_BTB005 UNION " +
                    "SELECT No,APPLY_DATE,STATUS,BAN,APPROVED_DATE FROM BTB_OAF_BTB006  ) AS B " +
                    "WHERE  NO = :no ")
    BtbIpInfo findBtbIpInfo(@Param("no") Integer no);

}