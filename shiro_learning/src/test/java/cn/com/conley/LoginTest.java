package cn.com.conley;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import junit.framework.Assert;

public class LoginTest {
	@Test
	public void testHelloWorld(){
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
		Factory<org.apache.shiro.mgt.SecurityManager> factory =  
				new IniSecurityManagerFactory("classpath:shiro-realm.ini");  
		//2、得到SecurityManager实例 并绑定给SecurityUtils  
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
		SecurityUtils.setSecurityManager(securityManager);  
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
		Subject subject = SecurityUtils.getSubject();  
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "23");  

		try {  
			//4、登录，即身份验证  
			subject.login(token);  
		} catch (AuthenticationException e) {  
			//5、身份验证失败  
			System.out.println("失败");
		}  

		Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
		System.out.println("登录成功");
		//6、退出  
		subject.logout();  




	}

	public static class MyRealm implements Realm{

		public String getName() {
			return "myRealm";
		}

		public boolean supports(AuthenticationToken token) {
			return token instanceof UsernamePasswordToken;
		}

		public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			String username = (String)token.getPrincipal();  //得到用户名  
			String password = new String((char[])token.getCredentials()); //得到密码  
			//这里其实可以去查一次数据库
			if(!"zhang".equals(username)) {  
				throw new UnknownAccountException(); //如果用户名错误  
			}  
			if(!"123".equals(password)) {  
				throw new IncorrectCredentialsException(); //如果密码错误  
			}  
			//如果身份认证验证成功，返回一个AuthenticationInfo实现；  
			return new SimpleAuthenticationInfo(username, password, getName());  
		}




	}





}
