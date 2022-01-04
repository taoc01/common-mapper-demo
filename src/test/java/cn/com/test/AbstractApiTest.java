/*
 * Copyright (c) 2014 中国国际图书贸易集团公司 
 * All rights reserved.
 *  
 */
package cn.com.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>标题： AbstractApiTest</p>
 * <p>
 *    功能描述：
 *    	junit测试类抽象父类；作用：减少子类重复写注入信息
 * </p>
 * <p>创建日期：2016年9月20日 上午11:45:19 </p>
 * <p>作者：TaoCong</p>
 * <p>版本：1.0</p>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:conf/spring/*.xml"})
public abstract class AbstractApiTest {

}
