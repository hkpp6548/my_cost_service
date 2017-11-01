package cn.skyhuang.estore.utils;

import cn.skyhuang.estore.dao.AppUsingStatistics;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/11/1.
 */
public class CreateExcelUtils {
    /**
     * 统计海格app使用情况。
     *
     * @Title: createAppUsingStatisticsExcel
     * @param driverList 需要生成excel的数据
     * @param date 查询日期  查询日期是空时，查询4天前的数据
     * @return void
     */
    public static String createAppUsingStatisticsExcel(List<AppUsingStatistics> driverList, String date) {
        // 第一步：定义一个新的工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建一个Sheet页
        HSSFSheet sheet = wb.createSheet("第一个Sheet页");
        // 给列设置宽
        sheet.setColumnWidth(0, 4000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 4000);
        sheet.setColumnWidth(6, 6000);
        sheet.setColumnWidth(7, 12000);
        sheet.setColumnWidth(8, 18000);

        String agoDay = "";
        if ("".equals(date)) {
            agoDay = getAgoDay(-4);// 4天前
        } else {
            agoDay = date;
        }

        // 在sheet页创建第一行
        HSSFRow row = sheet.createRow(0);
        // 设置行高
        row.setHeightInPoints(20);
        // 创建单元格
        HSSFCell cell = row.createCell(0);
        // 在该单元格里设置值
        cell.setCellValue(new HSSFRichTextString("注：以天为单位统计(" + agoDay + "日)"));
        /**
         * 合并单元格 第一个参数：第一个单元格的行数（从0开始） 第二个参数：第二个单元格的行数（从0开始）
         * 第三个参数：第一个单元格的列数（从0开始） 第四个参数：第二个单元格的列数（从0开始）
         */
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 9);
        sheet.addMergedRegion(range);
        // 获取单元格样式
        HSSFCellStyle headStyle = getHGHeadStyle(wb);
        // 设置单元格样式
        cell.setCellStyle(headStyle);

        // 创建第二行
        HSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("车牌号码");
        row1.createCell(1).setCellValue("未及时到达");
        row1.createCell(2).setCellValue("未报压夜费");
        row1.createCell(3).setCellValue("未上报费用");
        row1.createCell(4).setCellValue("未上报柜号");
        row1.createCell(5).setCellValue("未上报封条号");
        row1.createCell(6).setCellValue("点击到厂时间");
        row1.createCell(7).setCellValue("点击到厂的经纬度");
        row1.createCell(8).setCellValue("点击到厂的地点");
        // 设置行高样式
        row1.setHeightInPoints(20);

        // 设置批注
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        HSSFClientAnchor an = new HSSFClientAnchor(1, 1, 1, 1, (short) 3, 3, (short) 5, 3);// 控制批注大小
        HSSFComment createComment = patriarch.createComment(an);
        createComment.setString(new HSSFRichTextString("说明：到厂时间前后2小时之外点击到厂的都算未及时到达！"));// 设置批注内容
        row1.createCell(1).setCellComment(createComment);
        row1.createCell(1).setCellValue("未及时到达");
        HSSFClientAnchor an2 = new HSSFClientAnchor(1, 1, 1, 1, (short) 3, 3, (short) 5, 3);
        HSSFComment createComment2 = patriarch.createComment(an2);
        createComment2.setString(new HSSFRichTextString("说明：点击离开卸货点的时间距离到厂时间超过48小时" +
                "或者点击离开卸货点48小时后未上报费用的都算未上报费用！"));// 设置批注内容
        row1.createCell(3).setCellComment(createComment2);
        row1.createCell(3).setCellValue("未上报费用");

        HSSFCellStyle columnHeadStyle = getHGColumnHeadStyle(wb);
        for (int i = 0; i < 9; i++) {
            row1.getCell(i).setCellStyle(columnHeadStyle);
        }

        // 循环数据开始行数
        int count = 2;
       /* HSSFCellStyle commonStyle = getHGCommonStyle(wb);
        if (driverList != null && driverList.size() > 0) {
            for (int i = 0; i < driverList.size(); i++) {
                HSSFRow row2 = sheet.createRow(count);
                row2.setHeightInPoints(20);
                row2.createCell(0).setCellValue(driverList.get(i).getLicensePlate());// 车牌号码
                row2.createCell(1).setCellValue(driverList.get(i).getTimelyArrive());// 未及时到达
                row2.createCell(2).setCellValue(driverList.get(i).getHasNightFee());// 未报压夜费
                row2.createCell(3).setCellValue(driverList.get(i).getHasReportFee());// 未上报费用
                row2.createCell(4).setCellValue(driverList.get(i).getCabinetNo());// 未上报柜号
                row2.createCell(5).setCellValue(driverList.get(i).getSealNo());// 未上封条号
                row2.createCell(6).setCellValue(driverList.get(i).getArriveTime());// 点击到厂时间
                row2.createCell(7).setCellValue(driverList.get(i).getLongitudeAndLatitude());// 点击到厂经纬度
                row2.createCell(8).setCellValue(driverList.get(i).getArrivePosition());// 点击到厂的地点
                for (int j = 0; j < row2.getPhysicalNumberOfCells(); j++) {
                    row2.getCell(j).setCellStyle(commonStyle);// 设置单元格样式
                }
                count++;
            }
        }*/
        try {
            CreateExcelUtils excel = new CreateExcelUtils();
            String resource = excel.getClass().getResource("/").getPath();
            resource += "APP司机使用情况统计表.xls";
            FileOutputStream fileOut = new FileOutputStream(resource);
            wb.write(fileOut);
           // SystemLogger.info("excel生成成功了！");
            fileOut.close();
            return resource;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //SystemLogger.info("excel生成失败了！");
            return "";
        }// 输出

    }

    /**
     * 获取海格第一行单元格样式
     *
     * @Title: getHGHeadStyle
     * @param wb
     *            作用的工作薄
     * @return HSSFCellStyle 返回的样式
     */
    public static HSSFCellStyle getHGHeadStyle(HSSFWorkbook wb) {
        // 设置字体
        HSSFFont headfont = wb.createFont();
        headfont.setFontName("宋体");
        headfont.setFontHeightInPoints((short) 9);// 字体大小
        headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
        // 头样式
        HSSFCellStyle headStyle = wb.createCellStyle();
        headStyle.setFont(headfont);// 设置字体
        headStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 左右 居左
        headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        headStyle.setWrapText(true);
        headStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        headStyle.setBorderLeft((short) 1);
        headStyle.setRightBorderColor(HSSFColor.BLACK.index);
        headStyle.setBorderRight((short) 1);
        headStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
        headStyle.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
        headStyle.setFillForegroundColor(HSSFColor.WHITE.index);// 设置单元格的背景颜色．
        return headStyle;
    }

    /**
     * 获取海格列头单元格样式
     *
     * @Title: getHGColumnHeadStyle
     * @param wb
     *            作用的工作薄
     * @return HSSFCellStyle 返回的样式
     */
    public static HSSFCellStyle getHGColumnHeadStyle(HSSFWorkbook wb) {
        // 设置字体样式
        HSSFFont columnHeadFont = wb.createFont();
        columnHeadFont.setFontName("宋体");
        columnHeadFont.setFontHeightInPoints((short) 11);
        columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 头列样式
        HSSFCellStyle columnHeadStyle = wb.createCellStyle();
        columnHeadStyle.setFont(columnHeadFont);
        columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        columnHeadStyle.setLocked(true);
        columnHeadStyle.setWrapText(true);
        columnHeadStyle.setLeftBorderColor(HSSFColor.BLACK.index);// 左边框的颜色
        columnHeadStyle.setTopBorderColor(HSSFColor.BLACK.index);
        columnHeadStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        columnHeadStyle.setRightBorderColor(HSSFColor.BLACK.index);// 右边框的颜色
        columnHeadStyle.setBorderTop((short) 1);// 边框的大小
        columnHeadStyle.setBorderBottom((short) 1);
        columnHeadStyle.setBorderLeft((short) 1);
        columnHeadStyle.setBorderRight((short) 1);// 边框的大小
        columnHeadStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
        columnHeadStyle.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色
        // 设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）
        columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        return columnHeadStyle;
    }

    /**
     * 获取海格普通单元格的样式
     *
     * @Title: getHGCommonStyle
     * @param wb
     *            作用的工作薄
     * @return HSSFCellStyle 返回的样式
     */
    public static HSSFCellStyle getHGCommonStyle(HSSFWorkbook wb) {
        // 设置字体样式
        HSSFFont font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 11);
        // 普通单元格样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        style.setWrapText(true);
        style.setLeftBorderColor(HSSFColor.BLACK.index);// 左边框的颜色
        style.setTopBorderColor(HSSFColor.BLACK.index);
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setRightBorderColor(HSSFColor.BLACK.index);// 右边框的颜色
        style.setBorderTop((short) 1);// 边框的大小
        style.setBorderBottom((short) 1);
        style.setBorderLeft((short) 1);
        style.setBorderRight((short) 1);// 边框的大小
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
        style.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
        style.setFillForegroundColor(HSSFColor.WHITE.index);// 设置单元格的背景颜色．
        return style;
    }

    /**
     * 获取距离现在几天前日期，或者几天后的日期
     *
     * @Title: getAgoDay
     * @Description: TODO
     * @param num
     *            正数为几天后的日期，负数为几天前。
     * @return String 返回String类型的日期
     */
    public static String getAgoDay(int num) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, num);
        Date fourDayAgoData = c.getTime();
        String preMonday = sdf.format(fourDayAgoData);
        //SystemLogger.info("你要查询的日期：" + preMonday);
        return preMonday;
    }

    /**
     * 判断后一个时间是否和前一个时间现在两个小时之内
     *
     * @Title: hasTwoHour
     * @param rightTime
     * @param testTime
     * @return String 两小时之内 "否" 之外"是"
     */
    public static String hasTwoHour(Date rightTime, Date testTime) {
        long time = rightTime.getTime();
        long time2 = testTime.getTime();
        long time3 = time - time2;
        double hour = time3 * 1.0 / (1000 * 60 * 60);
        if (hour < 2 && hour > -2) {
            return "否";
        }
        return "是";
    }

    /**
     * 判断前一个时间是否超过后一个时间48小时
     *
     * @Title: hasFortyHour
     * @param completeTime
     * @param leaveTime
     * @return boolean 超过true,没有超过false
     */
    public static boolean hasFortyHour(Date completeTime, Date leaveTime) {
        long time = completeTime.getTime();
        long time2 = leaveTime.getTime();
        long time3 = time - time2;
        double hour = time3 * 1.0 / (1000 * 60 * 60);
        if (hour < 48) {
            return false;
        }
        return true;
    }
}
