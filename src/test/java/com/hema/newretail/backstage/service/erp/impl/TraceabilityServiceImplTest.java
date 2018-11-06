package com.hema.newretail.backstage.service.erp.impl;

import com.hema.newretail.backstage.common.utils.NumberUtils;
import com.hema.newretail.backstage.common.utils.StringUtil;
import com.hema.newretail.backstage.common.utils.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Department 新零售
 * @ClassName TraceabilityServiceImplTest
 * @Description TODO
 * @Author ---CWZ
 * @Date 2018/11/1 10:52
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TraceabilityServiceImplTest {

    @Test
    public void manufacturerList() {
        try {
            TimeUtil.stringToDate("2018-02-03","yyyy-MM-dd");
            System.out.println(TimeUtil.stringToDate("2018-02-03","yyyy-MM-dd"));
            System.out.println(TimeUtil.getStringByDateFormart(TimeUtil.stringToDate("2018-02-03","yyyy-MM-dd"),"yyyy-MM-dd"));

        }catch (Exception e){

        }

    }
}