package org.aiwan.api

import org.aiwan.entity.Admin
import org.aiwan.service.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminApi {

    @Autowired
    lateinit var adminService: AdminService

    @GetMapping("/list")
    fun list(): List<Admin> = adminService.list()

    @PostMapping("/update")
    fun update(admin: Admin) = adminService.updateById(admin)

    @PostMapping("/delete")
    fun delete(id: Int) = adminService.removeById(id)

    @PostMapping("/insert")
    fun insert(admin: Admin) = adminService.save(admin)

}