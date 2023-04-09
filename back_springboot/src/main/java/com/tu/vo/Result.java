package com.tu.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author rantuping
 * @date 2023/4/7 13:09
 */
@Data
public class Result {
    private Boolean status = true;
    private String msg;
}
