package com.diaosichengxuyuan.spring.boot.web.test.impl;

import com.diaosichengxuyuan.spring.boot.service.test.TestService;
import com.diaosichengxuyuan.spring.boot.service.test.dto.TestDTO;
import com.diaosichengxuyuan.spring.boot.web.test.TestRemote;
import com.diaosichengxuyuan.spring.common.page.Page;
import com.diaosichengxuyuan.spring.common.validation.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * web层
 *
 * @author liuhaipeng
 * @date 2018/8/24
 */
@RestController("testRemote")
@RequestMapping(value = "/test")
@Slf4j
public class TestRemoteImpl implements TestRemote {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    @Override
    public TestDTO selectById(@RequestParam Long id) {
        return testService.selectById(id);
    }

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @Override
    public List<TestDTO> selectAll() {
        return testService.selectAll();
    }

    @RequestMapping(value = "/selectPage", method = RequestMethod.POST)
    @Override
    public List<TestDTO> selectPage(@RequestBody Page page) {
        ValidationUtil.validate(page);
        return testService.selectPage(page);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @Override
    public int insert(@RequestBody TestDTO testDTO) {
        ValidationUtil.validate(testDTO);
        return testService.insert(testDTO);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    @Override
    public int deleteById(@RequestParam Long id) {
        return testService.deleteById(id);
    }
}
