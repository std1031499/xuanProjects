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
	
	//�û���ϢTest***********
	//��¼
	@Test
	public void login() throws Exception
	{
		userService.loginSave("1", "1", 1);
	}
	//ɾ���û�
	@Test
	public void delete() throws Exception
	{
		userService.delete(35);
	}
	//ע��
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
	//�޸ĸ�����Ϣ
	@Test
	public void update() throws Exception
	{
		User user = new User();
		user.setC_Password("1111");
		System.out.println(user);
		userService.saveOrUpdate(user);
	}
	
	
}
