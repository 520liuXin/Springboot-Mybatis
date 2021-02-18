package com.example.demo.entity.Bo;

import com.example.demo.entity.UserInfo;
import lombok.Data;

import java.util.Date;

/*
 * @Author liuxin
 * @Description //TODO
 **/
@Data
public class UserBo  extends UserInfo {

    /**
     * 开始日期
     */
    private Date begDate;
    /**
     * 结束时间
     */
    private Date endData;

}
