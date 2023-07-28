package com.alston;

import com.alston.model.BtbApplyRedis;
import com.alston.model.BtbFirewallApply;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redis;

    private final Logger log = LoggerFactory.getLogger(RedisTest.class);

    @Test
    public void savePerson() {
        BtbApplyRedis apply = new BtbApplyRedis();
        apply.setApply("qq");
        apply.setApproved("1");
        apply.setBan("aa");
        //redis.opsForValue().set("test", apply);
        Object redis1 = redis.opsForValue().get("test");
        log.info("GET :　{}", redis1);
    }

    @Test
    void testString() {
        // 插入数据，参数不仅仅是字符串，Java对象也可以
//        redis.opsForValue().set("name","小红");
        // 获取数据
        BtbFirewallApply ip = new BtbFirewallApply();
        ip.setNo(12);
        ip.setStatus("7");
//        redis.opsForHash().put("APPLY_KEY", 12, ip);
//        BtbFirewallApply name = (BtbFirewallApply) redis.opsForHash().get("APPLY_KEY", 12);
//        log.info("name = {}", name);

    }

}