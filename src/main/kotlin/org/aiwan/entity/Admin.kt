package org.aiwan.entity

import java.util.Date

data class Admin(
    /** 管理员id */
    var id: Int? = null,
    /** 账号 */
    var userName: String? = null,
    /** 密码 */
    var password: String? = null,
    /** 盐 */
    var salt: String? = null,
    /** 创建时间 */
    var createTime: Date? = null,
    /** 昵称 */
    var nickName: String? = null,
)