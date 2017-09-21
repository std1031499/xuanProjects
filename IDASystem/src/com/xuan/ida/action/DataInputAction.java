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
	
	//����service****************************************************************
	private DataInputService dataInputService;
	
	public void setDataInputService(DataInputService dataInputService) {
		this.dataInputService = dataInputService;
	}
	
	//��ȡ��ֵ*********************************************************************
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
	
	//public ����
	public InputStream getInputStream(){
		return inputStream;
	}
		
	
	
	
	//��ת
	public String dataInput(){
		
		
		return "dataInput";
	}
	
	
		
	//�ļ��ϴ�*********************************************************************
	
	public void importExcel(String ufileFileName ){
		
		
		String directory = "/upload";//�����ϴ�·��
		String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
		 //�����ϴ����ļ�����    
        
        //���涨����ļ�����Ҳҳ��ı���һ�� ufileFileName 
		File target = new File(targetDirectory,ufileFileName);
		//����һ�����ն���list
		List list = new ArrayList();
		//��ȡ�ϴ����ļ�
		
		try{
			InputStream ins = null;
			Workbook wb =null;
			ins = new FileInputStream(target);
			//��ʼ��һ��������
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
			//��һ�ű�
			 Sheet sheet = wb.getSheetAt(0);
			 int rowNum = sheet.getLastRowNum()+1;//row�г�ʼ����λ0
			 System.out.println("sheet������Ϊ��"+rowNum);
			 //�ϴ���Excel����б�ͷ�����Դӵڶ��п�ʼ������Ϊ1
			 for(int i=1;i<rowNum;i++){
				//������0��ʼ,��Ϊ��ĵ�1��;
				 model = new DataInput();//newһ��DataInputʵ��
				 Row row = sheet.getRow(i);
				 int cellNum = row.getLastCellNum();
				 for(int j=1;j<cellNum;j++){
					 
					 Cell cell = row.getCell(j);
					 String cellValue = null;
					 
					 //����ת��
					 if(cell.getCellType() == XSSFCell.CELL_TYPE_STRING){
						 //���ַ����Ĵ���
						 cellValue = cell.getStringCellValue();
					 }
					 else if(cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN){
						 //�Բ���ֵ�Ĵ���
						 cellValue = String.valueOf(cell.getBooleanCellValue());
					 }
					 else if(XSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()){
						 //�����ֵĴ���
						 if(DateUtil.isCellDateFormatted(cell)){
							 Date date = cell.getDateCellValue();//�����ڴ���
							 DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
							 cellValue = formater.format(date);
						 }
						 else{
							 //���ఴ����������
							 cellValue = cell.getNumericCellValue()+" ";
						 }
						 
					 }
					 
					 //�������ݳ��ֵ�λ�÷�װ��ʵ������
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
				
		String directory = "/upload";//�����ļ�·��
		String targetFileName = ufileFileName;
		String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
		//�����ϴ�����
		File target = new File(targetDirectory,targetFileName); 
		//����ļ��Ѿ����ڣ���ɾ��ԭ���ļ�
		if(target.exists()){
			
			target.delete();
			System.out.println("�ļ��Ѵ��ڣ��������ǣ�");
		}
		
		//�����ļ�
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
	
	
	//ͼ�����
	public String chartInput(){

		return "dataInput-chartInput";
	}
	
	//����ͼ����Ϣ
	public String chartBar() throws JsonGenerationException, JsonMappingException, IOException{
		
		
		try {
			List<DataInput> dataInputResult = dataInputService.getAll();
			//System.out.println(dataInputResult);
			//����һ��json����
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
	
	//��Ӧ�̵�������******************************************************************
	public String areaPieInput(){
		
		return "areaPieInput";
	}
	
	//�ص㹩Ӧ�̷���********************************************************************
	
	//��������ѯ��ֵ
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
	
	//�����Էֲ�����******************************************************************
	public String seasonInput(){
		
		return "seasonInput";
	}
	
	public String chartLine() throws JsonGenerationException, JsonMappingException, IOException{
		
		try {
			List<DataInput> dataInputResult = dataInputService.getinfosByYear(seasonYear);
			//System.out.println(dataInputResult);
			//����һ��json����
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
	
	//��ʷͬ��*********************************************************************
	public String historyInput(){
		
		return "historyInput";
	}
	
	public String historyChartBar() throws JsonGenerationException, JsonMappingException, IOException{		
		
		try {
			//System.out.println("ss");
			List<DataInput> dataInputResult = dataInputService.getInfosBySelect();
			//System.out.println(dataInputResult);
			//����һ��json����
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
	
	//��ȡͬ����������
	public String historySpeedAddOne() throws JsonGenerationException, JsonMappingException, IOException{
		
		try {
			
			List<DataInput> dataInputResult = dataInputService.getinfosByYear(historyYearOne);			
			
			//����һ��json����
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
			
			//����һ��json����
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
	
	
	
	
	//�ӿڷ���*********************************************************************
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
