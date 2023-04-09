package com.tu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author rantuping
 * @date 2023/4/7 11:38
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Accessors(chain = true)
public class User {
    private String id;
    private String name;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bir;
    private String address;
}
