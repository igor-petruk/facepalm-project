package com.myfacepalm.webapp.controllers;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TestServlet{
    @Resource
    JdbcTemplate jdbcTemplate;

    @Resource
    DB mongoDatabase;

    @ResponseBody
    @RequestMapping(value = "/app/test", produces = "application/json")
    public List<Long> v() throws Exception{
        System.out.println(Arrays.toString(mongoDatabase.getCollectionNames().toArray()));
        DBCollection a = mongoDatabase.getCollection("a");
        DBCursor cursor = a.find();
        List<Long> items = new ArrayList<Long>();
        for (DBObject o: cursor){
            items.add((Long)o.get("b"));
        }
        List<Long> extra =  jdbcTemplate.query("select * from a", new RowMapper<Long>() {
            @Override
            public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getLong("b");
            }
        });
        items.addAll(extra);
        return items;
    }
}
