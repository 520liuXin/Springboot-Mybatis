package com.example.demo.entity.Bo;
;
import com.example.demo.utils.excel.annotation.ExcelField;
import lombok.Data;
import lombok.ToString;
import java.util.Date;

/*
 * @Author liuxin
 * @Description //TODO
 **/
@Data
@ToString
public class UserExportBo  {
    @ExcelField(title = "创建时间", align = 2, sort = 5)
    private Date createTime;
    @ExcelField(title = "修改时间", align = 2, sort = 10)
    private Date updateTime;
    /**
     * 用户名
     */
    @ExcelField(title = "用户名", align = 2, sort = 15)
    private String username;
    /**
     * 手机号
     */
    @ExcelField(title = "手机号", align = 2, sort = 20)
    private String mobile;
    /**
     * 邮箱
     */
    @ExcelField(title = "邮箱", align = 2, sort = 25)
    private String email;
    /**
     * 密码 1.密码必须由字母、数字组成，区分大小写
     * 2.密码长度为8-18位
     */
    @ExcelField(title = "密码", align = 2, sort = 30)
    private String password;
    /**
     * 头像
     */
    @ExcelField(title = "头像", align = 2, sort = 35)
    private String imgurl;

    @ExcelField(title = "身份证", align = 2, sort = 40)
    private String idCard;
    /**
     * 性别
     */
    @ExcelField(title = "邮箱", align = 2, sort = 45)
    private String sex;
}
