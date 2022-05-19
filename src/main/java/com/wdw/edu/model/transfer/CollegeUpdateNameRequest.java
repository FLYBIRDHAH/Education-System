package com.wdw.edu.model.transfer;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CollegeUpdateNameRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer id;

    @NotEmpty
    private String name;

}
