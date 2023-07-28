package com.alston.dao;

import com.alston.model.BtbFirewallApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;

public interface Btb027WRepository extends CrudRepository<BtbFirewallApply, Integer>,
        JpaSpecificationExecutor<BtbFirewallApply>, Serializable {

    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE BTB_FIREWALL_APPLY " +
                    "SET " +
                    "APPROVED = :approved," +
                    "APPROVED_DATE = CURRENT_TIMESTAMP," +
                    "STATUS = :status," +
                    "REMARK = :remark," +
                    "LAST_MODIFIED_BY = :lastModifiedBy," +
                    "LAST_MODIFIED_DATE = CURRENT_TIMESTAMP," +
                    "LAST_MODIFIED_IP = :lastModifiedIp," +
                    "LAST_MODIFIED_FUNC = 'BTB027W'" +
                    "WHERE NO = :no")
    Integer updateApply(@Param("no") Integer no,
                        @Param("approved") String approved,
                        @Param("status") String status,
                        @Param("remark") String remark,
                        @Param("lastModifiedBy") String lastModifiedBy,
                        @Param("lastModifiedIp") String lastModifiedIp);

}