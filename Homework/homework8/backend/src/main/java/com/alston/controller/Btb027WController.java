package com.alston.controller;

import com.alston.dto.UpdateParam;
import com.alston.model.BtbFirewallApply;
import com.alston.model.BtbOafBtb001Ip;
import com.alston.model.BtbOafBtb002;
import com.alston.model.BtbOafBtb004;
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

    @GetMapping("/search/002/{no}")
    public ResponseEntity<BtbOafBtb002> queryBtb002(@PathVariable Integer no) {
        BtbOafBtb002 btb002 = btb027WService.queryBtb002(no);
        return new ResponseEntity<>(btb002, HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/004/{no}")
    public ResponseEntity<BtbOafBtb004> queryBtb004(@PathVariable Integer no) {
        BtbOafBtb004 btb004 = btb027WService.queryBtb004(no);
        return new ResponseEntity<>(btb004, HttpStatus.ACCEPTED);
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