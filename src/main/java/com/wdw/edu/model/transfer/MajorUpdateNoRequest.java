package com.wdw.edu.model.transfer;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class MajorUpdateNoRequest  implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer id;

    @NotNull
    private Integer no;

}
