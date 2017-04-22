package cn.javass.chapter2.web.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloWorldController{
	@RequestMapping(value="/hello")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws
	Exception {
		//1���ռ���������֤����
		//2���󶨲������������
		//3�������������ҵ��������ҵ����
		//4��ѡ����һ��ҳ��
		ModelAndView mv = new ModelAndView();
		//���ģ�����ݿ����������POJO����
		mv.addObject("message", "Hello World!");
		//�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��
		mv.setViewName("hello");
		return mv;
	}
}
