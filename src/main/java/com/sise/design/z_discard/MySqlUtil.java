package com.sise.design.z_discard;

//import com.sise.design.general.service.MySqlServerImpl;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * @author: Chen xuexin
// * @Time: 2019/7/21 22:41
// * @Descript: TODO
// * @Version: 3.0
// */
//
//@Component
//public class MySqlUtil {
//
//    public static JdbcTemplate jdbcTemplate = MySqlServerImpl.getJdbcTemplate();
//
//    public static int update(String sql) {
//        return jdbcTemplate.update(sql);
//    }
//
//    public static int[] update(String sql, List<Object[]> obj) {
//        return jdbcTemplate.batchUpdate(sql,obj);
//    }
//
//    public static List select(String sql){
//        return jdbcTemplate.queryForList(sql);
//    }
//
//    public static List select(String sql, List<Object[]> obj){
//        return jdbcTemplate.queryForList(sql, obj);
//    }
//
//    public static void exec(String sql){
//        jdbcTemplate.execute(sql);
//    }
//
//}
