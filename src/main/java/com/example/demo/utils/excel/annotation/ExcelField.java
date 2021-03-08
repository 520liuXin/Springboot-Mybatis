package com.example.demo.utils.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description 自定义注解
 * @author liuxin
 * @date 2021/2/5 
 * @return 
 **/
//Target表示我们的注解可以用在哪些地方
@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE})
//Retention表示我们的注解在什么时候才有效
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelField {
    /**
     * 导出字段名（默认调用当前字段的“get”方法，如指定导出字段为对象，请填写“对象名.对象属性”，例：“area.name”、“office.name”）
     */
    String value() default "";

    /**
     * 导出字段标题（需要添加批注请用“**”分隔，标题**批注，仅对导出模板有效）
     */
    String title();

    /**
     * 字段类型（默认为0 下载模板和导入均为0）
     */
    int type() default 0;

    /**
     * 导出字段对齐方式（0：自动；1：靠左；2：居中；3：靠右）
     */
    int align() default 0;

    /**
     * 导出字段字段排序（升序）
     */
    int sort() default 0;

    /**
     * 如果是字典类型，请设置字典的type值
     */
    String dictType() default "";


    /**
     * 反射类型
     */
    Class<?> fieldType() default Class.class;

    /**
     * 字段归属组（根据分组导出导入）
     */
    int[] groups() default {};

    /**
     * 下拉框数据集语句
     * @return
     */
    String selectSql()default "";
}
