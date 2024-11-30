package org.aiwan.config


@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class UserRole(val userType: UserType = UserType.ADMIN)
enum class UserType {
    ADMIN,USER
}