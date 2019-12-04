package com.zhiyou.mapper;

import com.zhiyou.model.RegistrationInfor;

public interface RegistrationInforMapper {
    int insert(RegistrationInfor record);

    int insertSelective(RegistrationInfor record);
}