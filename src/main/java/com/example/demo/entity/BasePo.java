package com.example.demo.entity;

import lombok.Data;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

/*
 * @Author liuxin
 * @Description //TODO
 **/
@Data
public class BasePo implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;
    private Date createTime;
    private Date updateTime;


}

