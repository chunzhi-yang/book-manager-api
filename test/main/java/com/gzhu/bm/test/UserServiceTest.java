package com.gzhu.bm.test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzhu.bm.security.util.MD5Helper;
import com.gzhu.bm.service.UsersService;
import com.gzhu.bm.vo.UsersVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class UserServiceTest {
	
	@Autowired
	UsersService usersService;
	
	@Test
	public void insertTest() throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException{
		SimpleDateFormat dateFmt = new SimpleDateFormat("YYYYMMddHHmmss");
		UsersVO usersVO = new UsersVO();		
		StringBuffer sb = new StringBuffer();
		sb.append(dateFmt.format(Calendar.getInstance().getTime()))
		.append("00")
		.append((int)Math.random()*100);
		usersVO.setUid(sb.toString());
		usersVO.setUserName("chonghui");
		usersVO.setUserPassword(MD5Helper.MD5("123456"));
		
		usersVO.setBirth(dateFmt.parse("19881221190050"));
		usersVO.setLocation("广州");
		usersVO.setCreatedTime(Calendar.getInstance().getTime());
		usersVO.setSex(Byte.parseByte("0"));
		
		usersVO.setDescription("暂无");		
		
		usersService.createSelective(usersVO);
		
	}
}
