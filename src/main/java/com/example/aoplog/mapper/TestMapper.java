package com.example.aoplog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.aoplog.pojo.SysLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<SysLog> {

}
