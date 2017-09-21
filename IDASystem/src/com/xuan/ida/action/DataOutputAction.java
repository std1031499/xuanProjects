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
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.xuan.ida.entities.DataInput;
import com.xuan.ida.entities.DataOutput;
import com.xuan.ida.service.DataOutputService;

public class DataOutputAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<DataOutput>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//����service****************************************************************
	private DataOutputService dataOutputService;
	
	public void setDataOutputService(DataOutputService dataOutputService) {
		this.dataOutputService = dataOutputService;
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
	
	private String customerAreaYear;
	
	public void setCustomerAreaYear(String customerAreaYear) {
		this.customerAreaYear = customerAreaYear;
	}
	
	private String seasonYear;
	
	public void setSeasonYear(String seasonYear) {
		this.seasonYear = seasonYear;
	}
	
	private String keyCustomerYear;
	
	public void setKeyCustomerYear(String keyCustomerYear) {
		this.keyCustomerYear = keyCustomerYear;
	}
	
	
	
	//InputStream
	private InputStream inputStream;
	
	//public ����
	public InputStream getInputStream(){
		return inputStream;
	}
	
	
	//�ļ��ϴ�    �ϴ���������***********************************************************
	public void importExcel(String ufileFileName ){
		
		
		String directory = "/uploadOutput";//�����ϴ�·��
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
				 model = new DataOutput();//newһ��DataInputʵ��
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
					 	
					 case 1:model.setOutputId(cellValue);
					 case 2:model.setOutputCustomerName(cellValue);
					 case 3:model.setOutputInvoiceNum(cellValue);
					 case 4:model.setOutputInvoiceDate(cellValue);
					 case 5:model.setOutputMoney(cellValue);
					 case 6:model.setOutputTax(cellValue);
					 case 7:model.setOutputMoneySum(cellValue);
					 case 8:model.setOutputRemark(cellValue);
					 case 9:model.setOutputCustomerArea(cellValue);
		 
					 }
					//System.out.println("hhh");
					//System.out.println(model);
					 dataOutputService.saveOrUpdate(model);
					 
				 }
				 
			 }
			 			 
		}
		catch (Exception e) {
			e.printStackTrace() ;
		}
	}
	
	public String dataInput(){
		
		return "dataInput";
	}
	
	public String dataOutputSave(){
		
		String directory = "/uploadOutput";//�����ļ�·��
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
	
	
	//�ͻ���������*******************************************************************
	public String areaCustomerOutput(){
		
		
		return "areaCustomerOutput";
	}
	
	public String areaBar() throws JsonGenerationException, JsonMappingException, IOException{
		//System.out.println("begin");
		
		try {
			List<DataOutput> dataOutputResult = dataOutputService.getAreaAndCountByYear(customerAreaYear);
			//System.out.println(dataInputResult);
			//����һ��json����
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(dataOutputResult);
			System.out.println(result+"result");
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	//�����Էֲ�********************************************************************
	public String seasonOutput(){
		
		return "seasonOutput";
	}
	
	public String seasonLine() throws JsonGenerationException, JsonMappingException, IOException{
		
		try {
			List<DataOutput> dataOutputResult = dataOutputService.getinfosByYear(seasonYear);
			//System.out.println(dataInputResult);
			//����һ��json����
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(dataOutputResult);
			System.out.println(result+"result");
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	//�ص��ͻ�********************************************************************
	public String keyCustomerOutput(){
				
		return "keyCustomerOutput";
	}
	
	public String customerBar() throws JsonGenerationException, JsonMappingException, IOException{
		
		try {
			List<DataOutput> dataOutputResult = dataOutputService.getCustomerAndCountByYear(keyCustomerYear);
			//System.out.println(dataInputResult);
			//����һ��json����
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(dataOutputResult);
			System.out.println(result+"result");
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
	
	private DataOutput model;
	
	@Override
	public DataOutput getModel() {
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
