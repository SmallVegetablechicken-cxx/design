package com.sise.design.general.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sise.design.general.entity.UserCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/26 14:21
 * @Descript: TODO
 * @Version: 1.0
 */

@Component
@Mapper
public interface UserCourseMapper extends BaseMapper<UserCourse> {


}
