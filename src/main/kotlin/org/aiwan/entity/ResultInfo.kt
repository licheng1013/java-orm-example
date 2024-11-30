package org.aiwan.entity

import cn.hutool.json.JSONUtil
import java.io.Serializable

data class ResultInfo<T>(
    var code: Int = 0,
    var msg: String = "成功",
    var data: T? = null
)  {
    companion object {
        fun <T> ok(data: T?): ResultInfo<T> {
            return ResultInfo(data = data)
        }

        fun <T> fail(msg: String,code : Int = -1): ResultInfo<T> {
            return ResultInfo(code, msg)
        }
    }

    override fun toString(): String {
        return JSONUtil.toJsonStr(this)
    }
}
