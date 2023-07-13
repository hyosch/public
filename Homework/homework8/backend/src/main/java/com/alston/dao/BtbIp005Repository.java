package com.alston.dao;

import com.alston.model.BtbOafBtb004;
import com.alston.model.BtbOafBtb005;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BtbIp005Repository extends JpaRepository<BtbOafBtb005, Integer>,
        JpaSpecificationExecutor<BtbOafBtb005> {

}