package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import driver.DriverTest;


public class ReadexcelFile extends DriverTest{
	public static String data=null;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFWorkbook workbookDelete;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	public static XSSFSheet sheetWrite;
	public static String[][] excelData = null;
	static int colCount=0;
	public static String finalTstjson;
	public static int rowCount=0;
	public static String BrowserName = null;
	public static int lastRow ;
	public static int StartRow;
	public static int EndRow;
	public static String[][] readdata;
	public static File source;
	public static String FailFileName;
	public static int retryloop=0;
	public static int loopnumber=3;
	//static String ProjectPath = System.getProperty("user.dir");
	static String HomePath = System.getProperty("user.home");
	//Reading Excel File and get the data
	static String FilePath ;
	public static String OldOrderId ="NotSelected";
	public static String optName;
	public String checkExisting;
	public static String refundstatus;
	public static String ExceptionDetails;
	public static String Status;
	public static ArrayList<String> ExceptionList=new ArrayList<String>();
	public static ArrayList<String> inputList=new ArrayList<String>();
	public static ArrayList<String> ExecutionList=new ArrayList<String>();
	//Payment Info Variables
	public static String subTotal;
	public static String deliveryFee;
	public String couponCodeAmount;
	public String totalTax;
	public String PSTorGST;
	public String GstPst;
	public static int my_picture_id;
	public static XSSFDrawing drawing;
	public static ArrayList<String> Taxtypeslist=new ArrayList<String>();
	public static ArrayList<String> Couponlist=new ArrayList<String>();
	public static String OrderAmount;
	public static String ActualTotal;
	public static ArrayList<String> AdjList=new ArrayList<String>();
	public static ArrayList<String> AdjAmounts=new ArrayList<String>();
	public static ArrayList<String> Explist=new ArrayList<String>();
	public static int adjAMount;
	public static String Adjustmentwrong;
	//Variable for Test Data
	public static String OrderId;
	public static String Reason;
	public static String Amount;
	public static String Coupon;
	public static String ExceptionYesNo;
	public static String ExceptionMsg;
	public static String Execute;
	public static String SKUQty;
	public static String SKUAMount;
	public static String SKUNumber;
	public static String SheetName;
	public static String SheetName_input;
	public static String LastNameEntered;
	public static String SubTotal="-";
	public static String Tax="-";
	public static String Tax1="NA";
	public static String Tax2="NA";
	public static String Total="-";
	public static int Cvalue=0;
	public static int Ctext=0;
	public static int cutloop;
	public static int readloop;
	public static String StartTime;
	public static String EndTime;
	public static String  JsonOrderId;
	public static String  OrderLineNumber;

	public static FormulaEvaluator evaluator;

	public static String[][] oneexcel_Files(String sheetname) throws Exception {

		try {
			//FilePath=ProjectPath+"\\Testdata\\Result.xlsx";
			FileInputStream finputStream = new FileInputStream(new File(FilePath));
			workbook = new XSSFWorkbook(finputStream);
			finputStream.close();
			ZipSecureFile.setMinInflateRatio(0);
			sheet = workbook.getSheet(sheetname);
			workbook.setForceFormulaRecalculation(true);
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			try {
				sheetWrite = workbook.getSheet(SheetName);
				//System.out.println("Columns"+ colCount);
			}catch(Exception e) {
				System.out.println("sheetWrite not required");
			}

			rowCount = sheet.getPhysicalNumberOfRows();

			//System.out.println("Rows"+ rowCount);

			excelData = new String[rowCount][colCount];

			for(int Nrow = 0; Nrow<rowCount; Nrow++) {
				row = sheet.getRow(Nrow);
				for(int Ncolumn =0; Ncolumn<colCount ; Ncolumn++) {
					cell = sheet.getRow(Nrow).getCell(Ncolumn);
					DataFormatter df = new DataFormatter();

					// existing Sheet, Row, and Cell setup

					excelData[Nrow][Ncolumn] = df.formatCellValue(cell);

				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		rowCount = excelData.length;
		return excelData;

	}

	@SuppressWarnings("unused")
	public static String[][] twoExcel_Files(String sheetname) throws Exception {

		String dirName = ResultPath;
		String bookNameA = "AssetCreation.xlsx";
		String bookNameB = "Execution.xlsx";
		try {

			FileInputStream finputStream1 = new FileInputStream(new File(dirName+bookNameA));
			FileInputStream finputStream2= new FileInputStream(new File(dirName+bookNameB));

			XSSFWorkbook workbook1 = new XSSFWorkbook(finputStream1);
			XSSFWorkbook workbook2 = new XSSFWorkbook(finputStream2);
			ZipSecureFile.setMinInflateRatio(0);
			finputStream1.close();
			finputStream2.close();
			XSSFFormulaEvaluator Eval1= new XSSFFormulaEvaluator(workbook1);
			XSSFFormulaEvaluator Eval2= new XSSFFormulaEvaluator(workbook2);
			// Set up the workbook environment for evaluation
			String[] workbookNames = { bookNameA, bookNameB, };

			XSSFFormulaEvaluator[] evaluators = { Eval1, Eval2, };
			XSSFFormulaEvaluator.setupEnvironment(workbookNames, evaluators);
			// do an evaluation


			sheet = workbook1.getSheet(sheetname);
			if(sheet==null) {
				sheet = workbook2.getSheet(sheetname);
				workbook2.close();
			}
			workbook1.close();

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();

			//System.out.println("Columns"+ colCount);

			rowCount = sheet.getPhysicalNumberOfRows();

			//System.out.println("Rows"+ rowCount);

			excelData = new String[rowCount][colCount];
			String valData = "No Value";
			int dataValu;
			for(int Nrow = 0; Nrow<rowCount; Nrow++) {
				row = sheet.getRow(Nrow);
				for(int Ncolumn =0; Ncolumn<colCount ; Ncolumn++) {
					cell = sheet.getRow(Nrow).getCell(Ncolumn);
					DataFormatter df = new DataFormatter();

					// existing Sheet, Row, and Cell setup

					if (cell.getCellType() == CellType.FORMULA) {
						try {
							workbook1.setForceFormulaRecalculation(true);
							evaluator = workbook1.getCreationHelper().createFormulaEvaluator();
							//evaluator.evaluate(cell).getStringValue().isEmpty();
							valData=Eval1.evaluate(cell).getStringValue();
							try {
								if(valData.contains("null")) {
									dataValu=(int) Eval1.evaluate(cell).getNumberValue();
									valData = String.valueOf(dataValu);
								}
							}catch(Exception e) {
								if(valData==null) {

									dataValu=(int) evaluator.evaluate(cell).getNumberValue();
									valData = String.valueOf(dataValu);
									System.out.println("valData is ::"+valData);
								}
							}

						}catch(Exception e) {
							workbook2.setForceFormulaRecalculation(true);
							evaluator = workbook2.getCreationHelper().createFormulaEvaluator();
							valData=Eval2.evaluate(cell).getStringValue();

						}
						excelData[Nrow][Ncolumn]=valData;


					}else {
						excelData[Nrow][Ncolumn] = df.formatCellValue(cell);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		rowCount = excelData.length;
		return excelData;

	}




	//create Cell
	public static void createcell(CellStyle style,XSSFCell searchText2,String Title) {
		style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
		searchText2.setCellStyle(style);
		searchText2.setCellValue(Title);

	}
	//Delete previous sheets 
	@SuppressWarnings("unused")
	public static void DeleteSheets(String FunctionType)throws FileNotFoundException, IOException {

		try {
			Runtime.getRuntime().exec(
					"cmd /c taskkill /f /im excel.exe");
			//"cmd /c taskkill /f /im excel.exe"); 
			//"WINDOWTITLE eq Microsoft Excel - Book1 Mine.*"
			//logStep("The Result Excel was Opned :: Focefully closed ");
		}catch(Exception e){
			System.out.println("Excel already closed ");
		}
		String MyPath = ResultPath+FunctionType+"_Result.xlsx";
		System.out.println("MyPath is for Delete Sheets :: "+MyPath);
		FileInputStream fis = new FileInputStream(MyPath);
		ZipSecureFile.setMinInflateRatio(0);
		@SuppressWarnings("resource")
		XSSFWorkbook workbookwrite = new XSSFWorkbook(fis);
		fis.close();
		int numOfSheets=workbookwrite.getNumberOfSheets();
		System.out.println("numOfSheets :: "+numOfSheets);
		int startSheet = 0;
		if(numOfSheets>7) {
			startSheet=numOfSheets-1;
		}
		for(int i=0;i<startSheet;i++) {
			System.out.println("Detete Sheet Names is : "+workbookwrite.getSheetAt(i).getSheetName());
			workbookwrite.removeSheetAt(i);
			break;

		}
		FileOutputStream fos = new FileOutputStream(ResultPath+FunctionType+"_Result.xlsx");
		workbookwrite.write(fos);
		workbookwrite.close();
		fos.close();
	}



	//Create new sheet with Test Header
	public static void createDataSheet_RemovePrevious(String FunctionType) throws FileNotFoundException, IOException, InterruptedException  {

		try {
			Runtime.getRuntime().exec(
					"cmd /c taskkill /f /im excel.exe");
			//"cmd /c taskkill /f /im excel.exe"); 
			//"WINDOWTITLE eq Microsoft Excel - Book1 Mine.*"
			//logStep("The Result Excel was Opned :: Focefully closed ");
		}catch(Exception e){
			System.out.println("Excel already closed ");
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy_HH-mm");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		SheetName="result_"+ReusableFunctions.getDatafromJson("Environment")+"_"+dtf.format(now);
		//create an object of Workbook and pass the FileInputStream object into it to create a pipeline between the sheet and eclipse.
		String MyPath = ResultPath+FunctionType+"_Result.xlsx";
		System.out.println("MyPath is for Create Sheets :: "+MyPath);
		FileInputStream fis = new FileInputStream(ResultPath+FunctionType+"_Result.xlsx");
		ZipSecureFile.setMinInflateRatio(0);
		XSSFWorkbook workbookwrite = new XSSFWorkbook(fis);
		fis.close();


		//---------------------------------------------------//
		workbookwrite.createSheet(SheetName);
		XSSFSheet sheetWrite = workbookwrite.getSheet(SheetName);
		//sheetWrite.addIgnoredErrors(new CellRangeAddress(0, 9999, 0, 9999), IgnoredErrorType.values().NUMBER_STORED_AS_TEXT);
		System.out.println("Sheet Name for Craeet :: "+SheetName);
		XSSFCell searchText2;
		XSSFRow rowwrite;
		CellStyle style = workbookwrite.createCellStyle();
		int MaxCol = 0;
		if(FunctionType.equalsIgnoreCase("FT")) {
			MaxCol=4;
		}else if(FunctionType.equalsIgnoreCase("RL")) {
			MaxCol=4;
		}
		//		int repeatText=7;
		for(int loop=0;loop<=0;loop++) {
			rowwrite=sheetWrite.createRow(loop);
			for(int cloop=0;cloop<=MaxCol;cloop++) {
				//int reloop=1;
				searchText2 = sheetWrite.getRow(loop).getCell(cloop);

				if (searchText2==null) {
					searchText2=rowwrite.createCell(cloop);
					if(FunctionType.equalsIgnoreCase("FT")||FunctionType.equalsIgnoreCase("RL")) {
						if(cloop==0) {
							style = workbookwrite.createCellStyle();
							style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
							style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
							searchText2.setCellStyle(style);

							searchText2.setCellValue("Asset_Type");
						}else if(cloop==1){
							//style = workbookwrite.createCellStyle();
							style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
							style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
							searchText2.setCellStyle(style);
							searchText2.setCellValue(new XSSFRichTextString("Asset Name"));
						}else if(cloop==2){
							style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
							style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
							searchText2.setCellStyle(style);
							searchText2.setCellValue(new XSSFRichTextString("Asset ID"));
						}else if(cloop==3){
							style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
							style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
							searchText2.setCellStyle(style);
							searchText2.setCellValue(new XSSFRichTextString("Episode_List"));
						}
					}
				}

			}
		}

		System.out.println("SheetReady to Create");
		FileOutputStream fos = new FileOutputStream(ResultPath+FunctionType+"_Result.xlsx");
		workbookwrite.write(fos);
		workbookwrite.close();
		fos.close();
		System.out.println("Sheet Created SuccessFully");
	}




	//read onexcel
	public static void readOneExcel(String sheetName) {
		try {
			Runtime.getRuntime().exec(
					"cmd /c taskkill /f /im excel.exe");
			//"cmd /c taskkill /f /im excel.exe"); 
			//"WINDOWTITLE eq Microsoft Excel - Book1 Mine.*"
			//logStep("The Result Excel was Opned :: Focefully closed ");
		}catch(Exception e){
			System.out.println("Excel already closed ");
		}

		if(sheetName.contains("MultipleExecution")||sheetName.contains("InputData")) {
			try {
				FilePath =ResultPath+"AssetCreation.xlsx";
				readdata = oneexcel_Files(sheetName);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}else if(sheetName.contains("fullFillment_")||sheetName.equalsIgnoreCase("fullFillment_input")) {
			try {
				FilePath =ResultPath+"AssetCreation.xlsx";
				readdata = oneexcel_Files(sheetName);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}else if(sheetName.contains("input_")) {
			try {
				FilePath =ResultPath+"AssetCreation.xlsx";
				readdata = oneexcel_Files(sheetName);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}else if(sheetName.contains("Execution_")) {
			try {
				FilePath =ResultPath+"AssetCreation.xlsx";
				readdata = oneexcel_Files(sheetName);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}else {
			try {
				FilePath =ResultPath+"AssetCreation.xlsx";
				readdata = oneexcel_Files(sheetName);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		System.out.println("File Path is for readOneExcel :: "+FilePath);
	}



	public static void writeResult(String ExeType) throws IOException {


		int maxloop;
		//ExeType="TwoWheeler";

		try {
			Runtime.getRuntime().exec(
					"cmd /c taskkill /f /im excel.exe"); 
			//logStep("The Result Excel was Opned :: Focefully closed ");
		}catch(Exception e){
			System.out.println("Excel already closed. ");
		}

		FileInputStream fis;
		String MyPath = ResultPath+ExeType+"_Result.xlsx";
		System.out.println("MyPath is for Write result Sheets :: "+MyPath);
		fis = new FileInputStream(MyPath);
		ZipSecureFile.setMinInflateRatio(0);
		XSSFWorkbook workbookwrite = new XSSFWorkbook(fis);
		fis.close();
		XSSFSheet sheetWrite = workbookwrite.getSheet(SheetName);
		//XSSFSheet sheetWrite = workbookwrite.getSheet("result_25-08-20_22-48");
		rowCount = sheetWrite.getPhysicalNumberOfRows();
		colCount = sheetWrite.getRow(0).getPhysicalNumberOfCells();
		XSSFCell searchText2;
		XSSFRow rowwrite = null;
		int loop;
		loop=rowCount;
		maxloop=colCount;
		rowwrite=sheetWrite.createRow(loop);
		//rowwrite=sheetWrite.getRow(loop);
		//int repeatText=7;
		for(int cloop=0;cloop<=maxloop;cloop++) {

			searchText2 = sheetWrite.getRow(loop).getCell(cloop);
			if(ExeType.equalsIgnoreCase("FT")||ExeType.equalsIgnoreCase("RL")) {
				if (searchText2==null) {
					searchText2=rowwrite.createCell(cloop);
					if(cloop==0) {
						searchText2.setCellValue(Result.get(0));
					}else if(cloop==1){
						searchText2.setCellValue(Result.get(1));
					}else if(cloop==2){
						searchText2.setCellValue(Result.get(2));
					}else if(cloop==3){
						searchText2.setCellValue(Result.get(3));
					}
				}
			} 
		}
		// Resize all columns to fit the content size
		for (int i = 0; i < colCount; i++) {
			sheetWrite.autoSizeColumn(i);
		}
		//fis.close();
		FileOutputStream fos = new FileOutputStream(ResultPath+ExeType+"_Result.xlsx");
		workbookwrite.write(fos);
		workbookwrite.close();
		fos.close();
	}


	//read excel sheet based on sheetName
	public static  void readExcel(String sheetName) throws Exception {

		try {
			FilePath =ResultPath+"AssetCreation.xlsx";
			readdata = twoExcel_Files(sheetName);

		} catch (Exception e) {

			FilePath =ResultPath+"AssetCreation.xlsx";
			readdata = twoExcel_Files(sheetName);

		}
	}

}
