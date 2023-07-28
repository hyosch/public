package com.alston.service;

import com.alston.controller.Btb027WController;
import com.alston.dao.Btb027WDao;
import com.alston.dto.BtbIpInfo;
import com.alston.dto.UpdateParam;
import com.alston.model.BtbFirewallApply;
import com.alston.model.BtbOafBtb001Ip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class Btb027WService {

    @Autowired
    private Btb027WDao btb027WDao;

    private final Logger log = LoggerFactory.getLogger(Btb027WController.class);

    @Cacheable(value = "Applies")
    public Page<BtbFirewallApply> queryApplies(String ban, String status, Instant applyDate, Instant toDate, Integer from, Integer to) {
        return btb027WDao.findApplies(ban, status, applyDate, toDate, from, to);
    }

    @Cacheable(value = "OafIP", key = "#serviceCaseNo")
    public List<BtbOafBtb001Ip> queryBtbIp(Integer serviceCaseNo) {
        return btb027WDao.findBtbIp(serviceCaseNo);
    }

    @Cacheable(value = "BtbInfo", key = "#no")
    public BtbIpInfo queryBtbInfo(Integer no) {
        return btb027WDao.findBtbIpInfo(no);
    }

    @Cacheable(value = "Applies")
    public BtbFirewallApply queryByNo(Integer no) {
        return btb027WDao.findByNo(no);
    }


    public List<BtbFirewallApply> queryByNoArray(int[] noArray) {
        List<BtbFirewallApply> applies = new ArrayList<>();
        for (int no : noArray) {
            BtbFirewallApply apply = btb027WDao.findByNo(no);
            log.info("apply : {}", apply.toString());
            applies.add(apply);
        }
        return applies;
    }

    @Transactional
    @CacheEvict(value = "Applies", allEntries = true)
    public String updateApply(List<BtbFirewallApply> applies, UpdateParam updateParam) {
        for (BtbFirewallApply apply : applies) {
            Integer applyResult = btb027WDao.updateApply(apply, updateParam);
            if (applyResult != 1) {
                return "Update BtbFirewallApply failure, no: " + apply.getNo();
            }
            btb027WDao.queryBtbType(apply.getServiceCaseNo());

            Integer btbIpResult = btb027WDao.updateBtbIp(
                    apply.getServiceCaseNo(), apply.getApproved(), updateParam.getAccount());
            if (btbIpResult != 1) {
                return "Update BtbOaf00x failure, no: " + apply.getNo();
            }
        }
        return "OK";
    }

    @Transactional
    @CacheEvict(value = "Applies", allEntries = true)
    public Integer returnUpdate(Integer no, UpdateParam updateParam) {
        return btb027WDao.updateApply(no, updateParam);
    }

}