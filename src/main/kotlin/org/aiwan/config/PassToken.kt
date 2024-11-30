package org.aiwan.config

/**
 * 排除需要登入的接口
 * @since 8/1/22
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class PassToken