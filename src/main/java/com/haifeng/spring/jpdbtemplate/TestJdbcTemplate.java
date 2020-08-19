package com.haifeng.spring.jpdbtemplate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;


/**
 * @author haifeng
 * @date 2020-08-11 1:14
 */
public class TestJdbcTemplate {

    ApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
    JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);

    @Test
    public void testUpdate() {
//        jdbcTemplate.update("insert into emp values(null, '张三', 22, '男')");
        // 使用占位符
        /*String sql = "insert into emp values (null,?,?,?)";
        // 单个添加
        jdbcTemplate.update(sql, "李四", 24, "女");*/

        /**
         * Mybatis中(还是JdbcTemplate中呢？)，不能使用通配符进行赋值的场景：
         * 原因是给通配符赋值时会将替换通配符的字符串加上单引号
         * 1、批量删除、批量修改 （where id in ()）
         * 2、模糊查询
         */
        // 错误示例，不能使用这种方法进行批量删除
        /*String sql = "delete from emp where eid in (?)";
        String eids = "4,5,3";
        // prepareStatement通过setXxx方法赋值会默认将通配符两边加上单引号
        jdbcTemplate.update(sql, eids);*/

        // 正确示例
        /*String eids = "4,5,6";
        String sql = "delete from emp where eid in(" + eids + ")";
        jdbcTemplate.update(sql);*/

        String mohu = "a";
//        String sqls = "select * from emp where ename like '%?%'"; // 不能使用
//        String sqls = "select * from emp where ename like '%'a'%'"; // 拼接后结果 错误示例
        String sqls = "select * from emp where ename like concat('%', ?, '%')"; // 可以使用
    }

    @Test
    /**
     * 批量增、删、改
     */
    public void testBatchUpdate() {
        String sql = "insert into emp values (null,?,?,?)";
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"a1", 1, "男"});
        list.add(new Object[]{"a2", 1, "男"});
        list.add(new Object[]{"a3", 1, "男"});
        // 批量添加
        jdbcTemplate.batchUpdate(sql, list);
    }

    @Test
    public void testQueryForObject() {
//        jdbcTemplate.queryForObject(sql,requiredType)用来获取单个的值，如聚合函数时使用
//        jdbcTemplate.queryForObject(sql,rowMapper)用来获取单条数据
        /*String sql = "select eid, ename, age, sex from emp where eid=?";
        // 将列名(字段名或者字段名的别名)与属性名进行映射
        RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);
        Emp emp = jdbcTemplate.queryForObject(sql, new Object[]{7}, rowMapper);
        System.out.println(emp);*/

        String sql = "select count(*) from emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    @Test
    public void testQuery() {
        String sql = "select eid,ename,age,sex from emp";
        RowMapper rowMapper = new BeanPropertyRowMapper(Emp.class);
        List<Emp> list = jdbcTemplate.query(sql, rowMapper);
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

}
