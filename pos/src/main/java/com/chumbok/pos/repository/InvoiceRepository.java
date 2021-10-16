package com.chumbok.pos.repository;

import com.chumbok.pos.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
/*
* DAO是传统 MVC 中 Model 的关键角色，直接负责数据库的存取工作
* Repository蕴含着真正的OO概念，即一个数据仓库角色，负责所有对象的持久化管理。
* DAO则没有摆脱数据的影子，仍然停留在数据操作的层面上。Repository是相对对象而言，DAO则是相对数据库而言
* 常用的Repository 有 CrudRepository，PagingAndSortingRepository 和 JpaRepository
* */