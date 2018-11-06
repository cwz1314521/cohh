package com.hema.newretail.backstage.common.utils;

import com.hema.newretail.backstage.entry.TempCell;
import com.hema.newretail.backstage.entry.UserManagerData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ExcelUtils {

    //根据指定的excel模板导出数据
    public static void exportExcel(String srcFileName,List data,OutputStream fos) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        InputStream in = ExcelUtils.class.getResourceAsStream("/BOOT-INF/classes/excelModel/"+srcFileName);

        //根据模板创建excel工作簿
        XSSFWorkbook workBook = new XSSFWorkbook(in);

        //获取创建的工作簿第一页
        XSSFSheet sheet = workBook.getSheetAt(0);
        //修改标题
        XSSFRow row = sheet.getRow(0);

        XSSFCell titleCell = row.getCell(0);
        //获取指定单元格值
        String s = titleCell.getStringCellValue();

        String newTitle = s.substring(0,s.indexOf("（")+1)+dateFormat.format(new Date())+"）";

        titleCell.setCellValue(newTitle);

        //获取这一行所有单元格的样式
        XSSFRow row3 = sheet.getRow(2);
        List<CellStyle> cellStyles = new ArrayList<CellStyle>();
        Iterator<Cell> items = row3.cellIterator();
        while (items.hasNext()){
            Cell cell = items.next();
            CellStyle cellStyle = cell.getCellStyle();
            cellStyles.add(cellStyle);
        }

        for (int i=0;i<data.size();i++){
            UserManagerData user = (UserManagerData) data.get(i);
            //创建新的一行，并复制上面的样式
            XSSFRow newRow = sheet.createRow(2+i);
            for (int j=0;j<cellStyles.size();j++){
                Cell newCell = newRow.createCell(j);
                newCell.setCellStyle(cellStyles.get(j));
            }
            newRow.setHeightInPoints(row3.getHeightInPoints());

            StringBuilder strBuilder = new StringBuilder();

            newRow.getCell(0).setCellValue(user.getId());
            newRow.getCell(1).setCellValue(user.getNickname());
            newRow.getCell(2).setCellValue(user.getTag());
            String province = user.getProvince() != null ? user.getProvince() : "";
            String city = user.getCity() != null ? user.getCity() : "";
            String area = user.getArea() != null ? user.getArea() : "";

            if (!"".equals(province)){
                strBuilder.append(province).append("/");
                if(!"".equals(city)){
                    strBuilder.append(city).append("/");
                    if (!"".equals(area)){
                        strBuilder.append(area);
                    }
                }
            }

            newRow.getCell(3).setCellValue(strBuilder.toString());
            if (user.getRegistrationDate()!=null){
                newRow.getCell(4).setCellValue(dateFormat.format(user.getRegistrationDate()));
            }else{
                newRow.getCell(4).setCellValue("");
            }

            newRow.getCell(5).setCellValue("10");//周消费次数
            newRow.getCell(6).setCellValue("+11.5%");//周消费次数中位数对比
            newRow.getCell(7).setCellValue("+11.5%");//周消费次数环比
            newRow.getCell(8).setCellValue("+"+user.getId());//周消费总额
            newRow.getCell(9).setCellValue("+"+user.getId());//周消费总额中位数
            newRow.getCell(10).setCellValue("-"+user.getId());//周消费总额环比
            newRow.getCell(11).setCellValue("-"+user.getId());//周消费均值
            newRow.getCell(12).setCellValue("+"+user.getId());//周消费均值同比
            newRow.getCell(13).setCellValue("-"+user.getId());//周消费均值环比
        }



        workBook.write(fos);
        workBook.close();

        //关闭流
        in.close();
        fos.flush();
        fos.close();
        System.out.println("导出成功");
    }




    //模板map
    private Map<String, Workbook> tempWorkbook = new HashMap<String, Workbook>();
    //模板输入流map
    private Map<String, InputStream> tempStream = new HashMap<String, InputStream>();


    /**
     * 功能:按模板向Excel中列表填充数据.只支持列合并
     */
    public void writeDateList(String templateFilePath, String[] heads, List<Map<Integer, Object>> datalist, int sheetNo)
            throws IOException, InvalidFormatException {
        if (heads == null || heads.length <= 0 || CollectionUtils.isEmpty(datalist)) {
            return;
        }
        //读取模板
        Workbook wbModule = getTempWorkbook(templateFilePath);
        //数据填充的sheet
        Sheet wsheet = wbModule.getSheetAt(sheetNo);

        //列表数据模板cell
        List<TempCell> tempCells = new ArrayList<TempCell>(heads.length);
        for (String point : heads) {
            TempCell tempCell = getCell(point, null, wsheet);
            //取得合并单元格位置 -1:表示不是合并单元格
//            int pos = isMergedRegion(wsheet, tempCell.getRow(), tempCell.getColumn());
//            if (pos > -1) {
//                CellRangeAddress range = wsheet.getMergedRegion(pos);
//                tempCell.setColumnSize(range.getLastColumn() - range.getFirstColumn());
//            }
            tempCells.add(tempCell);
        }
        //赋值
        for (int i = 0; i < datalist.size(); i++) {//数据行
            Map<Integer, Object> dataMap = datalist.get(i);
            for (int j = 0; j < tempCells.size(); j++) {//列
                TempCell tempCell = tempCells.get(j);
                tempCell.setData(dataMap.get(j + 1));
                setCell(tempCell, wsheet);
                tempCell.setRow(tempCell.getRow() + 1);
            }
        }
    }

    /**
     * 功能:获得模板输入流
     */
    private InputStream getInputStream(String templateFilePath) throws FileNotFoundException {
        if (!tempStream.containsKey(templateFilePath)) {
            tempStream.put(templateFilePath, new FileInputStream((templateFilePath)));
        }
        return tempStream.get(templateFilePath);
    }

    /**
     * 功能:获取输入工作区
     */
    private Workbook getTempWorkbook(String templateFilePath) throws IOException, InvalidFormatException {
        if (!tempWorkbook.containsKey(templateFilePath)) {
            InputStream inputStream = getInputStream(templateFilePath);
            tempWorkbook.put(templateFilePath, WorkbookFactory.create(inputStream));
        }
        return tempWorkbook.get(templateFilePath);
    }

    /**
     * 功能:写到输出流并移除资源
     */
    public void writeAndClose(String templateFilePath, OutputStream os) throws IOException, InvalidFormatException {
        if (getTempWorkbook(templateFilePath) != null) {
            getTempWorkbook(templateFilePath).write(os);
            tempWorkbook.remove(templateFilePath);
        }
        if (getInputStream(templateFilePath) != null) {
            getInputStream(templateFilePath).close();
            tempStream.remove(templateFilePath);
        }
    }


    /**
     * 功能:copy cell,不copy值
     */
    private void copyCell(Cell srcCell, Cell distCell) {
        distCell.setCellStyle(srcCell.getCellStyle());
        if (srcCell.getCellComment() != null) {
            distCell.setCellComment(srcCell.getCellComment());
        }
        int srcCellType = srcCell.getCellType();
        distCell.setCellType(srcCellType);
    }

    /**
     * 功能:copy rows
     */
    private void copyRows(int startRow, int endRow, int pPosition, Sheet sheet) {
        int pStartRow = startRow - 1;
        int pEndRow = endRow - 1;
        int targetRowFrom;
        int targetRowTo;
        int columnCount;
        CellRangeAddress region = null;
        int i;
        int j;
        if (pStartRow == -1 || pEndRow == -1) {
            return;
        }
        // 拷贝合并的单元格
        for (i = 0; i < sheet.getNumMergedRegions(); i++) {
            region = sheet.getMergedRegion(i);
            if ((region.getFirstRow() >= pStartRow)
                    && (region.getLastRow() <= pEndRow)) {
                targetRowFrom = region.getFirstRow() - pStartRow + pPosition;
                targetRowTo = region.getLastRow() - pStartRow + pPosition;
                CellRangeAddress newRegion = region.copy();
                newRegion.setFirstRow(targetRowFrom);
                newRegion.setFirstColumn(region.getFirstColumn());
                newRegion.setLastRow(targetRowTo);
                newRegion.setLastColumn(region.getLastColumn());
                sheet.addMergedRegion(newRegion);
            }
        }
        // 设置列宽
        for (i = pStartRow; i <= pEndRow; i++) {
            Row sourceRow = sheet.getRow(i);
            columnCount = sourceRow.getLastCellNum();
            if (sourceRow != null) {
                Row newRow = sheet.createRow(pPosition - pStartRow + i);
                newRow.setHeight(sourceRow.getHeight());
                for (j = 0; j < columnCount; j++) {
                    Cell templateCell = sourceRow.getCell(j);
                    if (templateCell != null) {
                        Cell newCell = newRow.createCell(j);
                        copyCell(templateCell, newCell);
                    }
                }
            }
        }
    }


    /**
     * 功能:给指定坐标单元格赋值
     */
    private void setCell(TempCell tempCell, Sheet sheet) {

//        if (tempCell.getColumnSize() > -1) {
//            CellRangeAddress rangeAddress = mergeRegion(sheet, tempCell.getRow(), tempCell.getRow(), tempCell.getColumn(), tempCell.getColumn() + tempCell.getColumnSize());
//            setRegionStyle(tempCell.getCellStyle(), rangeAddress, sheet);
//        }

        Row rowIn = sheet.getRow(tempCell.getRow());
        if (rowIn == null) {
            copyRows(tempCell.getRow() - 1, tempCell.getRow() - 1, tempCell.getRow(), sheet);//复制上一行
            rowIn = sheet.getRow(tempCell.getRow());
        }
        Cell cellIn = rowIn.getCell(tempCell.getColumn());
        if (cellIn == null) {
            cellIn = rowIn.createCell(tempCell.getColumn());
        }
        //根据data类型给cell赋值
        if (tempCell.getData() instanceof String) {
            cellIn.setCellValue((String) tempCell.getData());
        } else if (tempCell.getData() instanceof Integer) {
            cellIn.setCellValue((int) tempCell.getData());
        } else if (tempCell.getData() instanceof Double) {
            cellIn.setCellValue((double) tempCell.getData());
        } else {
            cellIn.setCellValue((String) tempCell.getData());
        }
        //样式
        if (tempCell.getCellStyle() != null) {
            cellIn.setCellStyle(tempCell.getCellStyle());
        }
    }


    /**
     * 功能:获取单元格数据,样式(根据坐标:B3)
     */
    private TempCell getCell(String point, Object data, Sheet sheet) {
        TempCell tempCell = new TempCell();

        //得到列  字母
        String lineStr = "";
        String reg = "[A-Z]+";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(point);
        while (m.find()) {
            lineStr = m.group();
        }
        //将列字母转成列号 根据ascii转换
        char[] ch = lineStr.toCharArray();
        int column = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            int post = ch.length - i - 1;
            int r = (int) Math.pow(10, post);
            column = column + r * ((int) c - 65);
        }
        tempCell.setColumn(column);

        //得到行号
        reg = "[1-9]+";
        p = Pattern.compile(reg);
        m = p.matcher(point);
        while (m.find()) {
            tempCell.setRow((Integer.parseInt(m.group()) - 1));
        }

        //获取模板指定单元格样式,设置到tempCell(写列表数据的时候用)
        Row rowIn = sheet.getRow(tempCell.getRow());
        if (rowIn == null) {
            rowIn = sheet.createRow(tempCell.getRow());
        }
        Cell cellIn = rowIn.getCell(tempCell.getColumn());
        if (cellIn == null) {
            cellIn = rowIn.createCell(tempCell.getColumn());
        }
        tempCell.setCellStyle(cellIn.getCellStyle());
        tempCell.setData(data);
        return tempCell;
    }

}
