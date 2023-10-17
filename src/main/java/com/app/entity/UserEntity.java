package com.app.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 */
@Data
public class UserEntity implements Serializable {

    private static long serialVersionUID = -64963065484587L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;


}
