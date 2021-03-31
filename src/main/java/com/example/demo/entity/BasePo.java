package com.example.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.demo.utils.excel.annotation.ExcelField;
import lombok.Data;
import lombok.experimental.Accessors;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

/*
 * @Author liuxin
 * @Description //TODO
 **/
@Data
@Accessors(chain = true)
public class BasePo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date createTime;

    private Date updateTime;


}

