package com.alston.service;

import com.alston.dao.Btb027WDao;
import com.alston.dto.UpdateParam;
import com.alston.model.BtbFirewallApply;
import com.alston.model.BtbOafBtb001Ip;
import com.alston.model.BtbOafBtb002;
import com.alston.model.BtbOafBtb004;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Page<BtbFirewallApply> queryApplies(String ban, String status, Instant applyDate, Instant toDate, Integer from, Integer to) {
        Page<BtbFirewallApply> btbApplies = btb027WDao.findApplies(ban, status, applyDate, toDate, from, to);
        if (btbApplies != null) {
            return btbApplies;
        }
//        List<Apply> applies = new ArrayList<>();
//        for (BtbFirewallApply btbApply : btbApplies) {
//            Apply apply = new Apply();
//            apply.setNo(btbApply.getNo());
//            apply.setCaseNo(btbApply.getCaseNo());
//            apply.setServiceCaseNo(btbApply.getServiceCaseNo());
//            apply.setServiceName(btbApply.getServiceName());
//            apply.setBan(btbApply.getBan());
//            apply.setStatus(btbApply.getStatus());
//            apply.setCreatedDate(btbApply.getCreatedDate());
//            apply.setRemark(btbApply.getRemark());
//            applies.add(apply);
//        }
        return null;
    }

    public List<BtbOafBtb001Ip> queryBtbIp(Integer serviceCaseNo) {
        List<BtbOafBtb001Ip> btbIpList = btb027WDao.findBtbIp(serviceCaseNo);
        if (btbIpList != null) {
            return btbIpList;
        }
        return null;
    }

    public String queryBtbType(Integer no) {
        if (btb027WDao.findBtb004(no) != null) {
            return btb027WDao.findBtb004(no).getType();
        } else if (btb027WDao.findBtb002(no) != null) {
            return btb027WDao.findBtb002(no).getType();
        } else {

            return "not found";
        }
    }

    public BtbOafBtb002 queryBtb002(Integer no) {
        BtbOafBtb002 btb002 = btb027WDao.findBtb002(no);
        if (btb002 != null) {
            return btb002;
        }
        return null;
    }

    public BtbOafBtb004 queryBtb004(Integer no) {
        BtbOafBtb004 btb004 = btb027WDao.findBtb004(no);
        if (btb004 != null) {
            return btb004;
        }
        return null;
    }

    public BtbFirewallApply queryByNo(Integer no) {
        return btb027WDao.findByNo(no);
    }

    public List<BtbFirewallApply> queryByNoArray(int[] noArray) {
        List<BtbFirewallApply> applies = new ArrayList<>();
        for (int no : noArray) {
            BtbFirewallApply apply = btb027WDao.findByNo(no);
            applies.add(apply);
        }
        return applies;
    }

    @Transactional
    public String updateApply(List<BtbFirewallApply> applies, UpdateParam updateParam) {
        for (BtbFirewallApply apply : applies) {
            Integer applyResult = btb027WDao.updateApply(apply, updateParam);
            if (applyResult != 1) {
                return "Update BtbFirewallApply failure, no: " + apply.getNo();
            }
            btb027WDao.queryBtbType(apply.getServiceCaseNo());
            Integer btbIpResult = btb027WDao.updateBtbIp(
                    apply.getServiceCaseNo(), updateParam.getStatus(), apply.getApproved(), updateParam.getAccount());
            if (btbIpResult != 1) {
                return "Update BtbOaf00x failure, no: " + apply.getNo();
            }
        }
        return "OK";
    }

    @Transactional
    public Integer returnUpdate(Integer no, UpdateParam updateParam) {
        return btb027WDao.updateApply(no, updateParam);
    }

}