package com.alston.dao;

import com.alston.dto.BtbType;
import com.alston.dto.UpdateParam;
import com.alston.model.*;
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
    private BtbTypeRepository btbTypeRepository;

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

//    @PersistenceContext
//    private EntityManager em;

    public Page<BtbFirewallApply> findApplies(String ban, String status, Instant applyDate, Instant toDate, Integer from, Integer to) {
        return btb027WRepo.findAll((root, cq, cb) -> {
                    Predicate restrictions = cb.conjunction();
                    if (ban != "") {
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

//    public List getTest() {
//        return btbOafBtbRepo.findAll((root, cq, cb) -> {
//                    Predicate restrictions = cb.and(cb.equal(root.get("no"), "1"));
//                    return restrictions;
//                });
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery cq = cb.createQuery();
//        Root<BtbOafBtb002> root = cq.from(BtbOafBtb002.class);
//        cb.and(cb.equal(root.get("no"), "1"));
//
//        return em.createQuery(cq).getResultList();
//    }

    public List<BtbOafBtb001Ip> findBtbIp(Integer serviceCaseNo) {
        return btbOafBtbIpRepo.findBtbIp(serviceCaseNo);
    }

    public BtbOafBtb002 findBtb002(Integer no) {
        return btbOafBtbRepo2.findBtb002(no);
    }

    public BtbOafBtb004 findBtb004(Integer no) {
        return btbOafBtbRepo4.findBtb004(no);
    }

    public Integer updateApply(BtbFirewallApply apply, UpdateParam updateParam) {
        return btb027WRepo.updateApply(
                apply.getNo(), updateParam.getAccount(), updateParam.getStatus(), apply.getRemark(), updateParam.getAccount(), updateParam.getIp());
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaUpdate<BtbFirewallApply> cu = cb.createCriteriaUpdate(BtbFirewallApply.class);
//
//        Root<BtbFirewallApply> root = cu.from(BtbFirewallApply.class);
//        cu.set("approved", btbApply.getApproved());
//        cu.set("approvedDate", Instant.now());
//        cu.set("status", "Y");
//        cu.set("remark", btbApply.getRemark());
//        cu.set("lastModifiedBy", btbApply.getLastModifiedBy());
//        cu.set("lastModifiedDate", btbApply.getLastModifiedDate());
//        cu.set("lastModifiedIp", btbApply.getLastModifiedIp());
//        cu.set("lastModifiedFunc", btbApply.getLastModifiedFunc());
//        cu.where(cb.equal(root.get("no"), btbApply.getNo()));
//
//        return em.createQuery(cu).executeUpdate();
    }

    public Integer updateBtbIp(Integer serviceCaseNo, String status, String approved, String account) {
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

    public BtbType queryBtbType(Integer serviceCaseNo) {
        return btbTypeRepository.findBtbType(serviceCaseNo);
    }

//    public BtbOafBtb004 queryType004(Integer serviceCaseNo) {
//        return btbOafBtbRepo4.findBtbType004(serviceCaseNo);
//    }

    public BtbFirewallApply findByNo(Integer no) {
        return btb027WRepo.findById(no).orElse(null);
    }

    public Integer updateApply(Integer no, UpdateParam updateParam) {
        return btb027WRepo.updateApply(no, updateParam.getAccount(), updateParam.getStatus(),
                updateParam.getRemark(), updateParam.getAccount(), updateParam.getIp());
    }
}