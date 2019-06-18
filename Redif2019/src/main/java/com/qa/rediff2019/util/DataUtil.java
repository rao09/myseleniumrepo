package com.qa.rediff2019.util;

import java.util.Hashtable;

public class DataUtil {
      
      public static Object[][] getTestData(String testCaseName, Xls_Reader xls)
      {
            
            int testStartRowNum = 1;
            while(!xls.getCellData(Constants.DATA_SHEET, 0, testStartRowNum).equalsIgnoreCase(testCaseName))
            {
                  testStartRowNum++;
            }
            System.out.println("Row num of test is-:"+testStartRowNum);
            
            int colStartRowNum = testStartRowNum+1;
            int totalCols = 0;
            while(!xls.getCellData(Constants.DATA_SHEET, totalCols, colStartRowNum).equals(""))
            {
                  totalCols++;
            }
            System.out.println("total Cols num of test is-:"+totalCols);
            
            int dataStartRowNum = testStartRowNum+2;
            int totalRows =0;
            while(!xls.getCellData(Constants.DATA_SHEET, totalRows, dataStartRowNum).equals(""))
            {
                  totalRows++;
                  dataStartRowNum++;
            }
            System.out.println("total Rows num of test is-:"+totalRows);
            
            //Read the data
            dataStartRowNum = testStartRowNum+2;
            Hashtable<String,String> table= null;
            Object[][] myData = new Object[totalRows][1];
            int finalRows = dataStartRowNum+totalRows;
            int i = 0;
            for(int rowNum = dataStartRowNum; rowNum<finalRows; rowNum++ ){
                  table = new Hashtable<String,String>();
                  for(int cNum=0; cNum<totalCols; cNum++){ //put data in hashtable
                        
                        String key = xls.getCellData(Constants.DATA_SHEET, cNum, colStartRowNum);
                        String value = xls.getCellData(Constants.DATA_SHEET, cNum, rowNum);
                        table.put(key, value);  
                  }
                  myData[i][0]=table;
                  i++;
            }
            return myData;          
}
    public static boolean isRunnable(String testName, Xls_Reader xls){
            
            String sheet = Constants.TESTCASES_SHEET;
            int rows = xls.getRowCount(sheet);
            for(int r=2;r<=rows;r++){
                  String tname = xls.getCellData(sheet, Constants.TCID_COL, r);
                  if(tname.equalsIgnoreCase(testName)){
                        String runmode = xls.getCellData(sheet, Constants.RUNMODE_COL, r);
                        if(runmode.equals("Y"))
                              return true;
                              else
                              return false;
                  }
            }
            return false;
            
      }

}


