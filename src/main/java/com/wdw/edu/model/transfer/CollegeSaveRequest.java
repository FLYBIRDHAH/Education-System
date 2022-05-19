package com.wdw.edu.model.transfer;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CollegeSaveRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer no;

    @NotEmpty
    private String name;

}
