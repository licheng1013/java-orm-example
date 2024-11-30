package org.aiwan.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper
import org.aiwan.entity.Admin

@Mapper
interface AdminDao : BaseMapper<Admin>