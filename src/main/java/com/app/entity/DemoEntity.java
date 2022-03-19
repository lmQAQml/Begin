package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoEntity implements Serializable {

    /**
     * 版本号确保序列化和反序列化
     */
    private static final long serialVersionUID = 2L;

    /**
     * id
     */
    public Integer id;

    /**
     * name
     */
    public String name;
}
