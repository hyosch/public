package com.alston.controller;

import com.alston.dto.BtbIpInfo;
import com.alston.dto.UpdateParam;
import com.alston.model.BtbFirewallApply;
import com.alston.model.BtbOafBtb001Ip;
import com.alston.service.Btb027WService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class Btb027WController {

    @Autowired
    private Btb027WService btb027WService;

    private final Logger log = LoggerFactory.getLogger(Btb027WController.class);

    @GetMapping("/search")
    public ResponseEntity<Page<BtbFirewallApply>> query(
            @RequestParam(required = false) String ban,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Instant applyDate,
            @RequestParam(required = false) Instant toDate,
            @RequestParam(defaultValue = "0") Integer from,
            @RequestParam(defaultValue = "5") Integer to) {
        Page<BtbFirewallApply> queryList = btb027WService.queryApplies(ban, status, applyDate, toDate, from, to);
        return new ResponseEntity<>(queryList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/{serviceCaseNo}")
    public ResponseEntity<List<BtbOafBtb001Ip>> queryBtbIp(@PathVariable Integer serviceCaseNo) {
        List<BtbOafBtb001Ip> btbIpList = btb027WService.queryBtbIp(serviceCaseNo);
        return new ResponseEntity<>(btbIpList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/searchIp/{no}")
    public ResponseEntity<BtbIpInfo> queryBtbInfo(@PathVariable Integer no) {
        BtbIpInfo btbIpInfo = btb027WService.queryBtbInfo(no);
        return new ResponseEntity<>(btbIpInfo, HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> batchUpdateByNoArray(@RequestBody UpdateParam updateParam) {
        log.info("array: {}", Arrays.toString(updateParam.getNoArray()));
        List<BtbFirewallApply> applies = btb027WService.queryByNoArray(updateParam.getNoArray());
        String result = btb027WService.updateApply(applies, updateParam);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/searchApply/{no}")
    public ResponseEntity<BtbFirewallApply> queryApply(@PathVariable Integer no) {
        BtbFirewallApply apply = btb027WService.queryByNo(no);
        return new ResponseEntity<>(apply, HttpStatus.ACCEPTED);
    }

    @PostMapping("/update/{no}")
    public ResponseEntity<Integer> returnUpdate(@PathVariable Integer no, @RequestBody UpdateParam updateParam) {
        log.info("array: {}", no);
        Integer result = btb027WService.returnUpdate(no, updateParam);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}