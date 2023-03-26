package com.roc.SuperMaster.utility.documentHandle.excelUtil.customEasypoiExport;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName TestCustomEasyPoiUtil
 * @Author: WangPeng
 * @Description TODO
 * @date 2023/3/20 21:21
 * @Version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/easy")
public class CustomEasyPoiUtil {
    @GetMapping("/export")
    public void exportForSecondPage(
            HttpServletResponse response,
            @RequestBody List<ColumnInfo> columnInfoList
    ) {
        try {

            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("文件名" + System.currentTimeMillis() + ".xlsx", "UTF-8"));
            response.setContentType("application/vnd.ms-excel");
            ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();
            //构建数据
            ArrayList<JSONObject> jsonObjects = new ArrayList<>();

            for (int i = 0; i < 50000; i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("hsicrm_gridcode", 11111456);
                jsonObject.put("网格名称", 1236);
                jsonObject.put("金额", 1256);
                jsonObject.put("异常单量", 1256);
                jsonObject.put("异常率分母", 1236);
                jsonObject.put("异常率", 123456);
                jsonObject.put("一种风险量", 123456);
                jsonObject.put("2种风险量", 123456);
                jsonObject.put("3种风险量", 123456);
                jsonObject.put("3种以上风险量", 222222222);
                jsonObject.put("123", 222222222);
                jsonObjects.add(jsonObject);
            }

            //内容样式
            WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
            contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);//细实线
            contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
            contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
            contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
            contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER); //设置内容自动换行
            contentWriteCellStyle.setWrapped(true);
            WriteCellStyle headWriteCellStyle = new WriteCellStyle();
            headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

            WriteSheet writeSheet = EasyExcel.writerSheet("Data").head(head(columnInfoList)).registerWriteHandler(horizontalCellStyleStrategy).build();
            excelWriter.write(contentData(jsonObjects, columnInfoList), writeSheet);
            excelWriter.finish();

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<String>> head(List<ColumnInfo> columnInfoList) {
        List<List<String>> list = ListUtils.newArrayList();

        for (ColumnInfo columnInfo : columnInfoList) {
            List<String> objects = ListUtils.newArrayList();
            objects.add(columnInfo.getExcelHeaderName());
            list.add(objects.stream().sorted().collect(Collectors.toList()));
        }

        return list;
    }

    @Data
    public static class ColumnInfo {
        private String columnName;
        private String excelHeaderName;
    }

    public static List<List<String>> contentData(List<JSONObject> data, List<ColumnInfo> columnInfoList) {
        List<List<String>> list = ListUtils.newArrayList();
        for (JSONObject datum : data) {
            //Set<String> strings = datum.keySet();
            List<String> listen = new LinkedList<String>();
            for (ColumnInfo columnInfo : columnInfoList) {
                listen.add(datum.getString(columnInfo.getColumnName()));
            }
            list.add(listen);
        }
        return list;
    }

    public void testament() {
        List<ColumnInfo> columnInfoList = new ArrayList<>();
        for (ColumnInfo columnInfo : columnInfoList) {
            List<String> objects = ListUtils.newArrayList();
            objects.add(columnInfo.getExcelHeaderName());
            ListUtils.newArrayList().add(objects.stream().sorted().collect(Collectors.toList()));
        }
    }
}
