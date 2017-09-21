import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.swing.internal.plaf.basic.resources.basic;
import com.xuan.cs.entities.Area;
import com.xuan.cs.entities.Basic;
import com.xuan.cs.entities.Management;
import com.xuan.cs.entities.User;
import com.xuan.cs.service.AreaService;
import com.xuan.cs.service.BasicService;
import com.xuan.cs.service.ManagementService;
import com.xuan.cs.service.SkillService;
import com.xuan.cs.service.UserService;




public class ServiceTest extends BaseServiceTest {
	
	@Autowired
	UserService userService;
	@Autowired
	ManagementService managementService;
	@Autowired
	AreaService areaService;
	@Autowired
	BasicService basicService;
	@Autowired
	SkillService skillService;
	
	//�û���Ϣtest*******************************
	//��¼
	@Test
	public void login() throws Exception{
		
		userService.loginSave("1", "1", 1);
	}
	
	//ɾ���û�
	@Test
	public void delete() throws Exception{
		userService.delete(35);
	}
	
	//ע��
	@Test
	public void save() throws Exception{
		
		User user = new User();
		user.setC_Username("222");
		user.setC_Password("222");
		user.setC_Level("3");
		System.out.println(user);
		userService.saveOrUpdate(user);
	}
	
	//�޸ĸ����˻���Ϣ
	@Test
	public void editSave() throws Exception{
		
		User user = new User();
		user.setC_Password("1111");
		System.out.println(user);
		userService.saveOrUpdate(user);
	}
	
	//������Ϣtest*******************************
	@Test
	public void addBasic() throws Exception{
		
		Basic basic = new Basic();
		basic.setC_Name("������Թ���");
		
		Management management = new Management();
		management.setManagement_Id(3);		
		management.setManagementName("ʯ��ׯ�пƼ���");
		basic.setManagement(management);
		
		Area area = new Area();
		area.setArea_Id(1);
		area.setAreaName("ʯ��ׯ��");
		basic.setArea(area);
		
		basic.setUser_IdB(37);
		basic.setC_AddressT("�ھ�ʵ��¥");
		basic.setC_AddressW("www.dycs.com");
		basic.setC_AddressW("dycs@qq.com");
		basic.setC_Person("������");
		basic.setC_Code("214211");
		basic.setC_contact("������");
		basic.setC_Phone("15256478655");
		basic.setC_Mail("2153543");
		basic.setC_Property("�ߵ�ԺУ");
		basic.setC_Introduction("�������");
		System.out.println(basic);
		basicService.saveOrUpdate(basic);
	}
	
	@Test
	public void getBasic() throws Exception{
		
		basicService.get(1);
		List<Basic> result = basicService.getAll(1);
		System.out.println(result);
	}
}
