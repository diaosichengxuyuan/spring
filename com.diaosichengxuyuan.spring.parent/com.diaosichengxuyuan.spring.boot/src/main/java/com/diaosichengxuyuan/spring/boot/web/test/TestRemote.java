package com.diaosichengxuyuan.spring.boot.web.test;

import com.diaosichengxuyuan.spring.boot.service.test.dto.TestDTO;
import com.diaosichengxuyuan.spring.boot.common.Page;

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
}
