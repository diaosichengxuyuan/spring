package com.diaosichengxuyuan.spring.mvc.service.test.impl;

import com.diaosichengxuyuan.spring.mvc.common.mapper.MapperUtil;
import com.diaosichengxuyuan.spring.mvc.common.page.Page;
import com.diaosichengxuyuan.spring.mvc.dao.test.TestMapper;
import com.diaosichengxuyuan.spring.mvc.dao.test.entity.TestDO;
import com.diaosichengxuyuan.spring.mvc.service.test.TestService;
import com.diaosichengxuyuan.spring.mvc.service.test.dto.TestDTO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service层
 *
 * @author liuhaipeng
 * @date 2018/8/24
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public TestDTO selectById(Long id) {
        TestDO testDO = testMapper.selectByPrimaryKey(id);
        TestDTO testDTO = MapperUtil.getMapper().map(testDO, TestDTO.class);
        return testDTO;
    }

    @Override
    public List<TestDTO> selectAll() {
        List<TestDO> testDOs = testMapper.selectAll();
        List<TestDTO> testDTOs = MapperUtil.getMapper().mapAsList(testDOs, TestDTO.class);
        return testDTOs;
    }

    @Override
    public List<TestDTO> selectPage(Page page) {
        PageHelper.startPage(page.getNum(), page.getSize(), false);
        List<TestDO> testDOs = testMapper.selectAll();
        List<TestDTO> testDTOs = MapperUtil.getMapper().mapAsList(testDOs, TestDTO.class);
        return testDTOs;
    }

    @Override
    public int insert(TestDTO testDTO) {
        TestDO testDO = MapperUtil.getMapper().map(testDTO, TestDO.class);
        return testMapper.insert(testDO);
    }

    @Override
    public int deleteById(Long id) {
        return testMapper.deleteByPrimaryKey(id);
    }
}
