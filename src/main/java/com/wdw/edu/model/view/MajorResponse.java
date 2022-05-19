package com.wdw.edu.model.view;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MajorResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer no;

    private String name;

    private Integer collegeId;

    private String collegeName;

    private Date createTime;

    private Date updateTime;
}
