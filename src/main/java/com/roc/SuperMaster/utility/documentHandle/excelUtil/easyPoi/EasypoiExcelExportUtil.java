package com.roc.SuperMaster.utility.documentHandle.excelUtil.easyPoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

/**
 * Easypoi导出Excel工具类
 */
@Slf4j
public class EasypoiExcelExportUtil {

    /**
     * 获取利用反射获取类里面的值和名称
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = null;
            try {
                value = field.get(obj);
                if (null == value) {
                    value = null;
                } else if (value instanceof Date) {
                    value = DateUtil.formatDateTime((Date) value);
                } else {
                    ;
                }
            } catch (IllegalAccessException e) {
                log.error("EasyPOI数据对象转Map异常，异常信息：", e);
            }
            map.put(fieldName, value);
        }
        return map;
    }

    public static void exportExcel(HttpServletResponse response, String fileName, String title, String sheetName, String[][] columnArray, List<JSONObject> list) {
        List<ExcelExportEntity> entity = new ArrayList<>();
        Arrays.asList(columnArray).stream().forEach(x -> entity.add(new ExcelExportEntity(x[0], x[1])));
        //定义文件名
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(fileName);
        stringBuffer.append("-");
        stringBuffer.append(DateUtil.format(new DateTime(), DatePattern.PURE_DATETIME_MS_FORMAT));
        stringBuffer.append(".xls");
        //导出
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), entity, list);
        try {
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(stringBuffer.toString(), "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            log.error("Eastpoi Excel数据导出异常，异常信息：{}", e.toString());
        }
    }

    public static void exportExcel(HttpServletResponse response, String fileName, String title, String sheetName, List<ExportColumnVo> columnVoList, List<Map> list) {
        List<ExcelExportEntity> entity = new ArrayList<>();
        columnVoList.forEach(x -> entity.add(new ExcelExportEntity(x.getShowName(), x.getColumName())));
        //定义文件名
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(fileName);
        stringBuffer.append("-");
        stringBuffer.append(DateUtil.format(new DateTime(), DatePattern.PURE_DATETIME_MS_FORMAT));
        stringBuffer.append(".xls");
        //导出
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), entity, list);
        try {
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(stringBuffer.toString(), "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            log.error("Eastpoi Excel数据导出异常，异常信息：{}", e.toString());
        }
    }

}

