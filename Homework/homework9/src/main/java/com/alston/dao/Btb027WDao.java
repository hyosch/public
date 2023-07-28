package com.alston.dao;

import com.alston.controller.Btb027WController;
import com.alston.dto.BtbIpInfo;
import com.alston.dto.BtbIpType;
import com.alston.dto.UpdateParam;
import com.alston.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.List;

@Repository
public class Btb027WDao {

    @Autowired
    private Btb027WRepository btb027WRepo;

    @Autowired
    private BtbIpTypeRepository btbIpTypeRepository;

    @Autowired
    private BtbIp001Repository btbOafBtbRepo1;

    @Autowired
    private BtbIp002Repository btbOafBtbRepo2;

    @Autowired
    private BtbIp004Repository btbOafBtbRepo4;

    @Autowired
    private BtbIp005Repository btbOafBtbRepo5;

    @Autowired
    private BtbIp006Repository btbOafBtbRepo6;

    @Autowired
    private BtbStatementRepository btbOafBtbIpRepo;

    @Autowired
    private BtbIpInfoRepository btbIpInfoRepo;

    private final Logger log = LoggerFactory.getLogger(Btb027WController.class);

    public Page<BtbFirewallApply> findApplies(String ban, String status, Instant applyDate, Instant toDate, Integer from, Integer to) {
        return btb027WRepo.findAll((root, cq, cb) -> {
                    Predicate restrictions = cb.conjunction();
                    log.info("ban {}", ban);
                    if (ban != null) {
                        restrictions = cb.and(restrictions, cb.equal(root.get("ban"), ban));
                    }
                    if (status != null) {
                        restrictions = cb.and(restrictions, cb.equal(root.get("status"), status));
                    }
                    if (applyDate != null) {
                        restrictions = cb.and(restrictions,
                                cb.greaterThanOrEqualTo(root.get("applyDate"), applyDate));
                    }
                    if (toDate != null) {
                        restrictions = cb.and(restrictions,
                                cb.lessThanOrEqualTo(root.get("applyDate"), toDate));
                    }
                    cq.orderBy(cb.desc(root.get("applyDate")));
                    return restrictions;
                },
                PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "no")));
    }

    public List<BtbOafBtb001Ip> findBtbIp(Integer serviceCaseNo) {
        return btbOafBtbIpRepo.findBtbIp(serviceCaseNo);
    }

    public BtbIpInfo findBtbIpInfo(Integer no) {
        return btbIpInfoRepo.findBtbIpInfo(no);
    }

    public Integer updateApply(BtbFirewallApply apply, UpdateParam updateParam) {
        return btb027WRepo.updateApply(apply.getNo(), updateParam.getAccount(), updateParam.getStatus(),
                apply.getRemark(), updateParam.getAccount(), updateParam.getIp());
    }

    public Integer updateBtbIp(Integer serviceCaseNo, String approved, String account) {
        if (btbOafBtbRepo1.existsById(serviceCaseNo)) {
            BtbOafBtb001 btbOafBtb001 = btbOafBtbRepo1.findById(serviceCaseNo).get();
            btbOafBtb001.setStatus("2");
            btbOafBtb001.setApproved(account + ";" + approved);
            btbOafBtb001.setRemark("null");
            btbOafBtbRepo1.save(btbOafBtb001);
            return 1;
        }
        if (btbOafBtbRepo2.existsById(serviceCaseNo)) {
            BtbOafBtb002 btbOafBtb002 = btbOafBtbRepo2.findById(serviceCaseNo).get();
            btbOafBtb002.setStatus("2");
            btbOafBtb002.setApproved(account + ";" + approved);
            btbOafBtb002.setRemark("null");
            btbOafBtbRepo2.save(btbOafBtb002);
            return 1;
        }
        if (btbOafBtbRepo4.existsById(serviceCaseNo)) {
            BtbOafBtb004 btbOafBtb004 = btbOafBtbRepo4.findById(serviceCaseNo).get();
            btbOafBtb004.setStatus("2");
            btbOafBtb004.setApproved(account + ";" + approved);
            btbOafBtb004.setRemark("null");
            btbOafBtbRepo4.save(btbOafBtb004);
            return 1;
        }
        if (btbOafBtbRepo5.existsById(serviceCaseNo)) {
            BtbOafBtb005 btbOafBtb005 = btbOafBtbRepo5.findById(serviceCaseNo).get();
            btbOafBtb005.setStatus("2");
            btbOafBtb005.setApproved(account + ";" + approved);
            btbOafBtb005.setRemark("null");
            btbOafBtbRepo5.save(btbOafBtb005);
            return 1;
        }
        if (btbOafBtbRepo6.existsById(serviceCaseNo)) {
            BtbOafBtb006 btbOafBtb006 = btbOafBtbRepo6.findById(serviceCaseNo).get();
            btbOafBtb006.setStatus("2");
            btbOafBtb006.setApproved(account + ";" + approved);
            btbOafBtb006.setRemark("null");
            btbOafBtbRepo6.save(btbOafBtb006);
            return 1;
        }
        return 0;
    }

    public BtbIpType queryBtbType(Integer serviceCaseNo) {
        return btbIpTypeRepository.findBtbType(serviceCaseNo);
    }

    public BtbFirewallApply findByNo(Integer no) {
        return btb027WRepo.findById(no).orElse(null);
    }

    public Integer updateApply(Integer no, UpdateParam updateParam) {
        return btb027WRepo.updateApply(no, updateParam.getAccount(), updateParam.getStatus(),
                updateParam.getRemark(), updateParam.getAccount(), updateParam.getIp());
    }

}