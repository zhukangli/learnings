package cn.com.conley.authorization;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;

public class LoginMain {
	public static void main(String[] args) {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
		Factory<org.apache.shiro.mgt.SecurityManager> factory =  
				new IniSecurityManagerFactory("classpath:shiro-role.ini");  
		//2、得到SecurityManager实例 并绑定给SecurityUtils  
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
		SecurityUtils.setSecurityManager(securityManager);  
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
		Subject subject = SecurityUtils.getSubject(); 
		
		//实际这里是从页面表单取来的
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123"); 
		subject.login(token);  
		//判断拥有角色：role1  
		Assert.assertTrue(subject.hasRole("role1"));  
		//判断拥有角色：role1 and role2  
		Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));  
		//判断拥有角色：role1 and role2 and !role3  
		boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));  
		Assert.assertEquals(true, result[0]);  
		Assert.assertEquals(true, result[1]);  
		Assert.assertEquals(false, result[2]);  



	}
}
