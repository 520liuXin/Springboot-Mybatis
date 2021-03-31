package com.example.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.example.demo.utils.excel.annotation.ExcelField;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;



@Data
@Accessors(chain = true) //链式写法
/**    user.setUsername("刘信").setEmail("www.799296010@qq.com").setIdCard("12345678")
 .setMobile("17673817175").setPassword("12432421")
 .setId(432432L).setCreateTime(new Date()).setUpdateTime(new Date());    */
public class UserInfo extends BasePo {
	/**
	 * 用户名
	 */
	@NotBlank(message = "用户名不能为空")
	@Length(max = 20, message = "用户名不能超过20个字符")
	@Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$", message = "用户昵称限制：最多20字符，包含文字、字母和数字")
	@ExcelField(title = "用户名", align = 2, sort = 15)
	private String username;

	/**
	 * 手机号
	 */
	@NotBlank(message = "手机号不能为空")
	@Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
	@ExcelField(title = "手机号", align = 2, sort = 20)
	private String mobile;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 邮箱
	 */
	@NotBlank(message = "联系邮箱不能为空")
	@Email(message = "邮箱格式不对")
	@ExcelField(title = "邮箱", align = 2, sort = 25)
	private String email;

	/**
	 * 密码 1.密码必须由字母、数字组成，区分大小写
	 * 2.密码长度为8-18位
	 */
	@NotBlank(message = "手机号不能为空")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]{8,18}$", message = "密码必须由字母、数字组成，区分大小写并且长度为8-18位")
	@ExcelField(title = "密码", align = 2, sort = 30)
	private String password;


	/**
	 * 头像
	 */
	@ExcelField(title = "头像", align = 2, sort = 35)
	private String imgurl;

	@ExcelField(title = "身份证", align = 2, sort = 40)
	private String idCard;


}
