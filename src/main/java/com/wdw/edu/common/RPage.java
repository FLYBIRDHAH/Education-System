package com.wdw.edu.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@AllArgsConstructor
public class RPage<T> {
    private List<T> records;
    private long total;
    private long size;
    private long current;

    public RPage(Page<T> page) {
        BeanUtils.copyProperties(page, this);
    }
}
