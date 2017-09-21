package com.xuan.ida.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 


import org.apache.commons.io.FileUtils;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.mapping.Array;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.xuan.ida.entities.DataInput;
import com.xuan.ida.service.DataInputService;

public class DataInputAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<DataInput>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//连接service****************************************************************
	private DataInputService dataInputService;
	
	public void setDataInputService(DataInputService dataInputService) {
		this.dataInputService = dataInputService;
	}
	
	//获取传值*********************************************************************
	private File ufile;
	
	public void setUfile(File ufile) {
		this.ufile = ufile;
	}
	
	private String ufileFileName;
	
	public void setUfileFileName(String ufileFileName) {
		this.ufileFileName = ufileFileName;
	}
	
	private String chartType;
	
	public void setChartType(String chartType) {
		this.chartType = chartType;
	}
	
	private String seasonYear;
	
	public void setSeasonYear(String seasonYear) {
		this.seasonYear = seasonYear;
	}
	
	private String historyYearOne;
	
	public void setHistoryYearOne(String historyYearOne) {
		this.historyYearOne = historyYearOne;
	}
	
	private String historyYearTwo;
	
	public void setHistoryYearTwo(String historyYearTwo) {
		this.historyYearTwo = historyYearTwo;
	}
	
	
	
	//InputStream
	private InputStream inputStream;
	
	//public 类型
	public InputStream getInputStream(){
		return inputStream;
	}
		
	
	
	
	//跳转
	public String dataInput(){
		
		
		return "dataInput";
	}
	
	
		
	//文件上传*********************************************************************
	
	public void importExcel(String ufileFileName ){
		
		
		String directory = "/upload";//定义上传路径
		String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
		 //生成上传的文件对象    
        
        //上面定义的文件名与也页面的保持一致 ufileFileName 
		File target = new File(targetDirectory,ufileFileName);
		//定义一个接收对象list
		List list = new ArrayList();
		//读取上传的文件
		
		try{
			InputStream ins = null;
			Workbook wb =null;
			ins = new FileInputStream(target);
			//初始化一个工作簿
			wb = WorkbookFactory.create(ins);
			ins.close(); 
			/*try{
				System.out.println("h4");
				di = new HSSFWorkbook(si);	
				System.out.println("h5");
			}
			catch (Exception e) {
				System.out.println("h5");
				di = new XSSFWorkbook(si);
			}*/			
			//第一张表单
			 Sheet sheet = wb.getSheetAt(0);
			 int rowNum = sheet.getLastRowNum()+1;//row行初始行数位0
			 System.out.println("sheet表行数为："+rowNum);
			 //上传的Excel表带有表头，所以从第二行开始，索引为1
			 for(int i=1;i<rowNum;i++){
				//索引从0开始,即为表的第1行;
				 model = new DataInput();//new一个DataInput实例
				 Row row = sheet.getRow(i);
				 int cellNum = row.getLastCellNum();
				 for(int j=1;j<cellNum;j++){
					 
					 Cell cell = row.getCell(j);
					 String cellValue = null;
					 
					 //类型转换
					 if(cell.getCellType() == XSSFCell.CELL_TYPE_STRING){
						 //对字符串的处理
						 cellValue = cell.getStringCellValue();
					 }
					 else if(cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN){
						 //对布尔值的处理
						 cellValue = String.valueOf(cell.getBooleanCellValue());
					 }
					 else if(XSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()){
						 //对数字的处理
						 if(DateUtil.isCellDateFormatted(cell)){
							 Date date = cell.getDateCellValue();//对日期处理
							 DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
							 cellValue = formater.format(date);
						 }
						 else{
							 //其余按照字数处理
							 cellValue = cell.getNumericCellValue()+" ";
						 }
						 
					 }
					 
					 //按照数据出现的位置封装到实体类中
					 switch(j){
					 	
					 case 1:model.setInputId(cellValue);
					 case 2:model.setInputSupplierName(cellValue);
					 case 3:model.setInputInvoiceNum(cellValue);
					 case 4:model.setInputInvoiceDate(cellValue);
					 case 5:model.setInputMoney(cellValue);
					 case 6:model.setInputTax(cellValue);
					 case 7:model.setInputMoneySum(cellValue);
					 case 8:model.setInputRemark(cellValue);
		 
					 }
					//System.out.println("hhh");
					//System.out.println(model);
					 dataInputService.saveOrUpdate(model);
					 
				 }
				 
			 }
			 			 
		}
		catch (Exception e) {
			e.printStackTrace() ;
		}
	}
	
	public String dataInputSave(){
				
		String directory = "/upload";//定义文件路径
		String targetFileName = ufileFileName;
		String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
		//生成上传对象
		File target = new File(targetDirectory,targetFileName); 
		//如果文件已经存在，则删除原有文件
		if(target.exists()){
			
			target.delete();
			System.out.println("文件已存在，将被覆盖！");
		}
		
		//复制文件
		try{
			
			FileUtils.copyFile(ufile, target); 
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		//System.out.println("h1");
		importExcel(ufileFileName);
		//System.out.println("h2");
		return "dataInputSave";
	}
	
	
	//图表分析
	public String chartInput(){

		return "dataInput-chartInput";
	}
	
	//返回图表信息
	public String chartBar() throws JsonGenerationException, JsonMappingException, IOException{
		
		
		try {
			List<DataInput> dataInputResult = dataInputService.getAll();
			//System.out.println(dataInputResult);
			//返回一个json数组
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(dataInputResult);
			System.out.println(result+"result");
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	//供应商地区分析******************************************************************
	public String areaPieInput(){
		
		return "areaPieInput";
	}
	
	//重点供应商分析********************************************************************
	
	//多条件查询传值
	private String selectAnother[];
	
	public void setSelectAnother(String[] selectAnother) {
		this.selectAnother = selectAnother;
	}
	
	private String selectTypes[];
	
	public void setSelectTypes(String[] selectTypes) {
		this.selectTypes = selectTypes;
	}
	
	private String selectInputsMin[];
	
	public void setSelectInputsMin(String[] selectInputsMin) {
		this.selectInputsMin = selectInputsMin;
	}
	
	private String selectInputsMax[];
	
	public void setSelectInputsMax(String[] selectInputsMax) {
		this.selectInputsMax = selectInputsMax;
	}
	
	public String supplierPieInput(){
		
		return "supplierPieInput";
	}
	
	public String supplierPieInputShow() throws JsonGenerationException, JsonMappingException, IOException{
		
		try {
			System.out.println(selectAnother+"ss"+selectTypes+"ss"+selectInputsMin+"ss"+selectInputsMax);
			//List<DataInput> dataInputResult = dataInputService.getNameAndCount();
			List<DataInput> dataInputResult = dataInputService.getNameAndCountComplex(selectAnother, selectTypes, selectInputsMin, selectInputsMax);
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(dataInputResult);
			System.out.println(result+"result");
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ajax-success";
	}
	
	//季节性分布分析******************************************************************
	public String seasonInput(){
		
		return "seasonInput";
	}
	
	public String chartLine() throws JsonGenerationException, JsonMappingException, IOException{
		
		try {
			List<DataInput> dataInputResult = dataInputService.getinfosByYear(seasonYear);
			//System.out.println(dataInputResult);
			//返回一个json数组
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(dataInputResult);
			System.out.println(result+"result");
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	//历史同比*********************************************************************
	public String historyInput(){
		
		return "historyInput";
	}
	
	public String historyChartBar() throws JsonGenerationException, JsonMappingException, IOException{		
		
		try {
			//System.out.println("ss");
			List<DataInput> dataInputResult = dataInputService.getInfosBySelect();
			//System.out.println(dataInputResult);
			//返回一个json数组
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(dataInputResult);
			
			System.out.println(result+"historyChartBarresult");
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	//获取同比增长速率
	public String historySpeedAddOne() throws JsonGenerationException, JsonMappingException, IOException{
		
		try {
			
			List<DataInput> dataInputResult = dataInputService.getinfosByYear(historyYearOne);			
			
			//返回一个json数组
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(dataInputResult);
			
			System.out.println(result+"historySpeedAddOne");
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success"; 
	}
	
	public String historySpeedAddTwo() throws JsonGenerationException, JsonMappingException, IOException{
		
		try {
			
			List<DataInput> dataInputResult = dataInputService.getinfosByYear(historyYearTwo);			
			
			//返回一个json数组
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(dataInputResult);
			
			System.out.println(result+"historySpeedAddTwo");
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success"; 
	}
	
	
	
	
	//接口方法*********************************************************************
	@Override
	public void prepare() throws Exception {}
	
	private DataInput model;
	@Override
	public DataInput getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
}
