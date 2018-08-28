package com.diaosichengxuyuan.spring.mvc.web.test;

import com.diaosichengxuyuan.spring.common.page.Page;
import com.diaosichengxuyuan.spring.mvc.service.test.dto.TestDTO;
import org.springframework.ui.Model;

/**
 * web层
 *
 * @author liuhaipeng
 * @date 2018/8/24
 */
public interface TestRemote {

    String hello(Model model);

    String selectById(Model model, Long id);

    String selectAll(Model model);

    String selectPage(Model model, Page page);

    String insert(Model model, TestDTO testDTO);

    String deleteById(Model model, Long id);
}
