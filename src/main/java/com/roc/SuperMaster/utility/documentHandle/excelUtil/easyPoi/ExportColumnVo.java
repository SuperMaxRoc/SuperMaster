package com.roc.SuperMaster.utility.documentHandle.excelUtil.easyPoi;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExportColumnVo implements Serializable {
    private static final long serialVersionUID = -1130453831556098083L;

    /**
     * 字段(对应后台查询到的字段)
     */
    private String columName;

    /**
     * 列名（前端展示字段，Excel中展示的列名称）
     */
    private String showName;


}
