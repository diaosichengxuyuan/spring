package com.diaosichengxuyuan.spring.cloud.provider.order1.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuhaipeng
 * @date 2018/12/30
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order1 {

    private Long id;

    private String name;

    private Integer age;
}
