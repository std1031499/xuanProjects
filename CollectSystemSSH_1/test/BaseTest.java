import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xuan.cs.entities.User;
import com.xuan.cs.service.AreaService;
import com.xuan.cs.service.BasicService;
import com.xuan.cs.service.ManagementService;
import com.xuan.cs.service.SkillService;
import com.xuan.cs.service.UserService;


public class BaseTest extends BaseServiceTest{

	@Autowired
	UserService userService;
	@Autowired
	ManagementService managermentService;
	@Autowired
	AreaService areaService;
	@Autowired
	BasicService basicService;
	@Autowired
	SkillService skillService;
	
	//用户信息Test***********
	//登录
	@Test
	public void login() throws Exception
	{
		userService.loginSave("1", "1", 1);
	}
	//删除用户
	@Test
	public void delete() throws Exception
	{
		userService.delete(35);
	}
	//注册
	@Test
	public void save() throws Exception
	{
		User user = new User();
		user.setC_Username("222");
		user.setC_Password("222");
		user.setC_Level("3");
		System.out.println(user);
		userService.saveOrUpdate(user);
	}
	//修改个人信息
	@Test
	public void update() throws Exception
	{
		User user = new User();
		user.setC_Password("1111");
		System.out.println(user);
		userService.saveOrUpdate(user);
	}
	
	
}
