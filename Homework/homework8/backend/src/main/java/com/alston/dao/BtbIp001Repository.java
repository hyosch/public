package com.alston.dao;

import com.alston.model.BtbOafBtb001;
import com.alston.model.BtbOafBtb004;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BtbIp001Repository extends JpaRepository<BtbOafBtb001, Integer>,
        JpaSpecificationExecutor<BtbOafBtb001> {

}