package com.zhiyou.mapper;

import com.zhiyou.model.HospitalInfor;

public interface HospitalInforMapper {
    int insert(HospitalInfor record);

    int insertSelective(HospitalInfor record);
}