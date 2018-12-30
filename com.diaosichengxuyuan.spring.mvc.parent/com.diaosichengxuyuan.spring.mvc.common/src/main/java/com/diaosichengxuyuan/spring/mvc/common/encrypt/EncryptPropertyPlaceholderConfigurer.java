package com.diaosichengxuyuan.spring.mvc.common.encrypt;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashSet;
import java.util.Set;

/**
 * 加密属性配置，由spring框架使用
 *
 * @author liuhaipeng
 * @date 2018/8/29
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private final Set<String> encryptPropNames = new HashSet<>();

    public EncryptPropertyPlaceholderConfigurer() {
        encryptPropNames.add("jdbc.password");
    }

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        //如果在加密属性名单中发现该属性
        if(isEncryptProp(propertyName)) {
            return DESEncryptUtil.decrypt(propertyValue);
        } else {
            return propertyValue;
        }

    }

    private boolean isEncryptProp(String propertyName) {
        return encryptPropNames.contains(propertyName);
    }

}
