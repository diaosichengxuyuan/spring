package com.diaosichengxuyuan.spring.mvc.web.test;

import com.diaosichengxuyuan.spring.mvc.common.Page;
import com.diaosichengxuyuan.spring.mvc.service.test.dto.TestDTO;

import java.util.List;

/**
 * web层
 *
 * @author liuhaipeng
 * @date 2018/8/24
 */
public interface TestRemote {

    TestDTO selectById(Long id);

    List<TestDTO> selectAll();

    List<TestDTO> selectPage(Page page);

    int insert(TestDTO testDTO);

    int deleteById(Long id);

    String hello();
}
