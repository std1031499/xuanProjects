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
	
	//用户信息test*******************************
	//登录
	@Test
	public void login() throws Exception{
		
		userService.loginSave("1", "1", 1);
	}
	
	//删除用户
	@Test
	public void delete() throws Exception{
		userService.delete(35);
	}
	
	//注册
	@Test
	public void save() throws Exception{
		
		User user = new User();
		user.setC_Username("222");
		user.setC_Password("222");
		user.setC_Level("3");
		System.out.println(user);
		userService.saveOrUpdate(user);
	}
	
	//修改个人账户信息
	@Test
	public void editSave() throws Exception{
		
		User user = new User();
		user.setC_Password("1111");
		System.out.println(user);
		userService.saveOrUpdate(user);
	}
	
	//基础信息test*******************************
	@Test
	public void addBasic() throws Exception{
		
		Basic basic = new Basic();
		basic.setC_Name("软件测试工程");
		
		Management management = new Management();
		management.setManagement_Id(3);		
		management.setManagementName("石家庄市科技局");
		basic.setManagement(management);
		
		Area area = new Area();
		area.setArea_Id(1);
		area.setAreaName("石家庄市");
		basic.setArea(area);
		
		basic.setUser_IdB(37);
		basic.setC_AddressT("第九实验楼");
		basic.setC_AddressW("www.dycs.com");
		basic.setC_AddressW("dycs@qq.com");
		basic.setC_Person("黄梓轩");
		basic.setC_Code("214211");
		basic.setC_contact("黄梓轩");
		basic.setC_Phone("15256478655");
		basic.setC_Mail("2153543");
		basic.setC_Property("高等院校");
		basic.setC_Introduction("软件测试");
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
