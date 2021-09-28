package com.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import models.User;
public class ReadData {
            private File f ;
            private static FileInputStream fis;
            private XSSFWorkbook excelWorkbook;
            private static XSSFSheet excelSheet;

    public ReadData() throws IOException{
        f = new File("C:\\Users\\Tal\\GettTask\\task\\data.xlsx");
		fis = new FileInputStream(f);
		excelWorkbook = new XSSFWorkbook(fis);
		excelSheet = excelWorkbook.getSheetAt(0);
    }
	
	public static void main(String args[]) throws IOException
	{	
        ReadData readData=new ReadData();
        System.out.println(readData.getData().get(0).getEmail());
			
	}

    public static  ArrayList<User> getData() throws IOException{
        int rows = excelSheet.getPhysicalNumberOfRows();
        ArrayList<User> userArray=new ArrayList<User>();
        for(int i=1;i<rows;i++){
            User user=new User(
            excelSheet.getRow(i).getCell(0).getStringCellValue(),
            excelSheet.getRow(i).getCell(1).getStringCellValue(),
            excelSheet.getRow(i).getCell(2).getStringCellValue(),
            excelSheet.getRow(i).getCell(3).getStringCellValue(),
            excelSheet.getRow(i).getCell(4).getStringCellValue(),
            excelSheet.getRow(i).getCell(5).getStringCellValue(),
            excelSheet.getRow(i).getCell(6).getStringCellValue()
            );
            userArray.add(user);
        }
        fis.close();
        return userArray;
    }


}