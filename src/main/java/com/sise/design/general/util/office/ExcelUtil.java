package com.sise.design.general.util.office;

import com.sise.design.general.util.content.DateTime;
import com.sise.design.wechat.entity.mybatis.WechatStr;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Chen xuexin
 * @Time: 2019/8/5 10:04
 * @Descript: TODO
 * @Version: 1.0
 */

public class ExcelUtil {

    /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @return 对象
     */
    public static HSSFWorkbook getOutput(String sheetName,String []title,String [][]values){
        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
         //创建一个居中格式
        style.setAlignment(HorizontalAlignment.CENTER);
        //声明列对象
        HSSFCell cell = null;
        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        //创建内容
        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<values[i].length;j++){
                //将内容按顺序赋给对应的列对象
                cell = row.createCell(j);
                cell.setCellValue(values[i][j]);
                cell.setCellStyle(style);
            }
        }
        return wb;
    }

    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testExportExcel(){
        try {
            String[] title = {"用户" , "内容" ,"动作" ,"类型"};
            WechatStr str = new WechatStr("11", "张三", 1, 1);
            List<WechatStr> list = new ArrayList<>();
            list.add(str);
            //1.通过forEach循环，生成list数组
            List<String[]> excelDatas = new ArrayList<>();
            list.forEach( str2 -> {
                String[] content = new String[4];
                content[0] = str2.getUser();
                content[1] = str2.getMsg();
                content[2] = String.valueOf(str2.getMsgAction());
                content[3] = String.valueOf(str2.getMsgType());
                excelDatas.add(content);
            });
            //生成cexel内容，二维String数组
            String[][] values = excelDatas.toArray(new String[0][title.length]);
            HSSFWorkbook wb = getOutput("测试",title , values);
            String targentPath = "C:\\Users\\lenovo\\Desktop\\"+ DateTime.getFileNameDateTime() +".xls";
            FileOutputStream fout = new FileOutputStream(targentPath);
            wb.write(fout);
            fout.close();
            System.out.println("导出excel成功，文件地址：" + targentPath);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

