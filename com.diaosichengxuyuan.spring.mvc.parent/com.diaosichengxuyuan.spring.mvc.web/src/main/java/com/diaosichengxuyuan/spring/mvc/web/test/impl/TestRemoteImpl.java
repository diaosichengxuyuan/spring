package com.diaosichengxuyuan.spring.mvc.web.test.impl;

import com.alibaba.fastjson.JSON;
import com.diaosichengxuyuan.spring.mvc.common.page.Page;
import com.diaosichengxuyuan.spring.mvc.common.validation.ValidationUtil;
import com.diaosichengxuyuan.spring.mvc.service.test.TestService;
import com.diaosichengxuyuan.spring.mvc.service.test.dto.TestDTO;
import com.diaosichengxuyuan.spring.mvc.web.test.TestRemote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * web层
 *
 * @author liuhaipeng
 * @date 2018/8/24
 */
@Controller("testRemote")
@RequestMapping(value = "/test")
@Slf4j
public class TestRemoteImpl implements TestRemote {

    private static final String CONTENT = "content";

    private static final String TEST = "test";

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @Override
    public String hello(Model model) {
        model.addAttribute("name", "liuhaipeng");
        model.addAttribute("age", 27);
        return "hello";
    }

    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    @Override
    public String selectById(Model model, @RequestParam Long id) {
        TestDTO testDTO = testService.selectById(id);
        String testDTOString = JSON.toJSONString(testDTO);
        model.addAttribute(CONTENT, testDTOString);
        return TEST;
    }

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @Override
    public String selectAll(Model model) {
        List<TestDTO> testDTOs = testService.selectAll();
        String testDTOsList = JSON.toJSONString(testDTOs);
        model.addAttribute(CONTENT, testDTOsList);
        return TEST;
    }

    @RequestMapping(value = "/selectPage", method = RequestMethod.POST)
    @Override
    public String selectPage(Model model, @RequestBody Page page) {
        ValidationUtil.validate(page);
        List<TestDTO> testDTOs = testService.selectPage(page);
        String testDTOsList = JSON.toJSONString(testDTOs);
        model.addAttribute(CONTENT, testDTOsList);
        return TEST;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @Override
    public String insert(Model model, @RequestBody TestDTO testDTO) {
        ValidationUtil.validate(testDTO);
        int num = testService.insert(testDTO);
        model.addAttribute(CONTENT, num);
        return TEST;
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    @Override
    public String deleteById(Model model, @RequestParam Long id) {
        int num = testService.deleteById(id);
        model.addAttribute(CONTENT, num);
        return TEST;
    }

}
