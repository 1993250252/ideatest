package com.test.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JsonResponseStatus {
    SUCCESS(200,"成功"),
    ERROR(100,"失败"),
    NULLACCOUNT(204,"账号不存在"),
    PWDERROR(205,"密码错误"),
    ADD(300,"新增成功"),
    CZ(001,"用户已存在"),
    CREATEMENU(234,"创建菜单失败")
    ;

    private Integer code;
    private String msg;
}
