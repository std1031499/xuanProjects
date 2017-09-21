
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xuan.cs.entities.Area;
import com.xuan.cs.entities.Basic;
import com.xuan.cs.entities.ListFirst;
import com.xuan.cs.entities.ListSecond;
import com.xuan.cs.entities.ListThird;
import com.xuan.cs.entities.Management;
import com.xuan.cs.entities.Skill;
import com.xuan.cs.entities.TradeFirst;
import com.xuan.cs.entities.TradeSecond;
import com.xuan.cs.entities.TradeThird;
import com.xuan.cs.entities.User;
import com.xuan.cs.service.AreaService;
import com.xuan.cs.service.BasicService;
import com.xuan.cs.service.ManagementService;
import com.xuan.cs.service.ShowService;
import com.xuan.cs.service.SkillService;
import com.xuan.cs.service.UserService;

public class UserServiceTest extends BaseServiceTest {
	@Autowired
	UserService userService;
	@Autowired
	ManagementService managementService;
	@Autowired
	AreaService areaService;
	@Autowired
	BasicService basicService ;
	@Autowired
	SkillService skillService;
	@Autowired
	ShowService showService;
	
	//用户信息test*********************************************************************
	//登录
	@Test 
	public void login() throws Exception {
		userService.loginSave("1", "1", 1);
	}
	
	//删除用户
	@Test
	public void delete() throws Exception{
		userService.delete(36);
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
		
		User user = userService.get(35);
		user.setC_Password("1111");
		System.out.println(user);
		userService.saveOrUpdate(user);
	}
	
	//基础信息test*****************************************************************
	@Test
	public void addBasic() throws Exception{
		
		Basic basic = new Basic();
		//basic.setBasic_Id(2);
		basic.setC_Name("软件测试工程");
		
//		Management management = (Management) managementService.getAllById(3);		
//		basic.setManagement(management);
//		
//		Area area = (Area) areaService.getAllById(1);		
//		basic.setArea(area);
		Management management  = new Management();
		management.setManagement_Id(3);

		management.setManagementName("石家庄市科技局");
		basic.setManagement(management);
		Area area = new Area();
		area.setArea_Id(1);
		area.setAreaName("石家庄市");
		basic.setArea(area);
		
		basic.setUser_IdB(35);
		basic.setC_AddressT("第九实验楼");
		basic.setC_AddressW("www.dycs.com");
		basic.setC_AddressE("dycs@qq.com");
		basic.setC_Person("黄梓轩");
		basic.setC_Code("321321");
		basic.setC_contact("黄梓轩");
		basic.setC_Telephone("15232179838");
		basic.setC_Phone("21321984");
		basic.setC_Mail("34323");
		basic.setC_Property("高等院校");
		basic.setC_Introduction("软件测试");
		//System.out.println(basic);
		//System.out.println(management);
		//System.out.println(area);
		basicService.saveOrUpdate(basic);
	}
	
	@Test
	public void getBasic() throws Exception
	{
		basicService.getAll(1);
		//System.out.println(basicService.getAll(1));
		List<Basic> result = basicService.getAll(1);
		System.out.println(result);
	}
	
	//技术信息Test******************************************************************
	@Test
	//技术信息添加
	public void addSkill() throws Exception
	{
		Skill skill = new Skill();
		
		skill.setT_Name("单元测试");
		skill.setT_TimeMin("2001");
		skill.setT_TimeMax("2003");
		skill.setT_MainProblem("junit测试");
		skill.setT_SkillKey("junit测试");
		skill.setT_Aim("junit测试");
		skill.setT_Key1("junit测试");
		skill.setT_MoneySet("22");
		skill.setT_Cooperate("独立开发");
		skill.setT_Unit("石家庄铁道大学");
		skill.setT_Type("基础研究");
		
		ListFirst listFirst = new ListFirst();
		listFirst.setListFirstId("1200000");
		listFirst.setListFirstName("信息科学与系统科学");
		skill.setListFirst(listFirst);
		
		ListSecond listSecond = new ListSecond();
		listSecond.setListSecondId("1201000");
		listSecond.setListSecondoName("信息科学与系统科学基础学科");
		skill.setListSecond(listSecond);
		
		ListThird listThird = new ListThird();
		listThird.setListThirdId("1201099");
		listThird.setListThirdName("信息科学与系统科学基础学科其他学科");
		skill.setListThird(listThird);
		
		TradeFirst tradeFirst = new TradeFirst();
		tradeFirst.setTradeFirstId("0");
		skill.setTradeFirst(tradeFirst);
		
		TradeSecond tradeSecond = new TradeSecond();
		tradeSecond.setTradeSecondId("0");
		skill.setTradeSecond(tradeSecond);
		
		TradeThird tradeThird = new TradeThird();
		tradeThird.setTradeThirdId("0");
		skill.setTradeThird(tradeThird);
		
		skill.setUser_IdS(35);
		skill.setAuditState("待审核");
		
		skillService.saveOrUpdate(skill);
	}
	
	//技术信息查询
	@Test
	public void getSkill() throws Exception
	{
		showService.getSkillById(35, 4);
		//System.out.println(basicService.getAll(1));
		List<Skill> result = showService.getSkillById(35, 4);
		System.out.println(result);
	}
	
}
