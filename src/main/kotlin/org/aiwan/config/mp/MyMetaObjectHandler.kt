package org.aiwan.config.mp

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import lombok.extern.slf4j.Slf4j
import org.apache.ibatis.reflection.MetaObject
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

/**
 * mybatis-plus 字段填充
 */
@Slf4j
@Component
class MyMetaObjectHandler : MetaObjectHandler {
    override fun insertFill(metaObject: MetaObject?) {
        //println("start insert fill ....")
        this.strictInsertFill<Date?, Date?>(metaObject, "createTime", Date::class.java, Date()) // 起始版本 3.3.0(推荐使用)
    }

    override fun updateFill(metaObject: MetaObject?) {
        //println("start update fill ....")
        this.strictUpdateFill<LocalDateTime?, LocalDateTime?>(
            metaObject,
            "updateTime",
            LocalDateTime::class.java,
            LocalDateTime.now()
        ) // 起始版本 3.3.0(推荐)
    }
}