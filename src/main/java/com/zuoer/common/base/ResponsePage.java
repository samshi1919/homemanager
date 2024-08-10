package com.zuoer.common.base;

import lombok.Data;

import java.util.List;

/**
 * @author ck
 * @date 2022/5/24 11:38
 */
@Data
public class ResponsePage {
    /**
     * 总条数
     */
    public long total;

    /**
     * 结果对象
     */
    private List<?> rows;

    public ResponsePage(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }


    public static <T> ResponsePage build(long total, List<?> rows) {
        return new ResponsePage(total, rows);
    }
}