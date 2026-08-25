package com.learn.postgres.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class AccountRepository {
    private  final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }

    public BigDecimal getAccountBalance(Long accountId){
        String sql="select get_account_balance(?)";

        return  jdbcTemplate.queryForObject(sql,BigDecimal.class,accountId);
    }
}
