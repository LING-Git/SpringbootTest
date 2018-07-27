package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 在Spring-data-jpa中，只需要编写类似上面这样的接口就可实现数据访问。
 * 不再像我们以往编写了接口时候还需要自己编写接口实现类，
 * 直接减少了我们的文件清单。
 */

/**
 * 下面对上面的UserRepository做一些解释，该接口继承自JpaRepository，
 * 通过查看JpaRepository接口的API文档，
 * 可以看到该接口本身已经实现了
 * 创建（save）、更新（save）、删除（delete）、查询（findAll、findOne）
 * 等基本操作的函数，
 * 因此对于这些基础操作的数据访问就不需要开发者再自己定义。
 */
public interface UserRepository extends JpaRepository<User,Long> {
    //1.Spring-data-jpa的一大特性：通过解析方法名创建查询
    User findByName(String name) ;

    User findByNameAndAge(String name,Integer age) ;

    //2.@Query 注解来创建查询，您只需要编写JPQL语句，并通过类似“:name”来映射@Param指定的参数
    @Query("from User u where u.name=:name")
    User findUser( @Param ("name") String name) ;
}
