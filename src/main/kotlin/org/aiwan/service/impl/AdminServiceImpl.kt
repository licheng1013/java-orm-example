package org.aiwan.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.aiwan.dao.AdminDao
import org.aiwan.entity.Admin
import org.aiwan.service.AdminService
import org.springframework.stereotype.Service

@Service
open class AdminServiceImpl : ServiceImpl<AdminDao , Admin>() , AdminService