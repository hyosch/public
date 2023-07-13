package com.alston.dao;

import com.alston.model.BtbOafBtb006;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BtbIp006Repository extends JpaRepository<BtbOafBtb006, Integer>,
        JpaSpecificationExecutor<BtbOafBtb006> {

}