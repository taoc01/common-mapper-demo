/**
 * 
 */
package cn.com.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import cn.com.dao.ExpendTypeMapper;
import cn.com.model.ExpendType;

/**
 * <p>标题： MapperTest</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2018年1月24日 下午3:18:41 </p>
 * <p>作者：TaoCong</p>
 * <p>版本：1.0</p>
 */
public class MapperTest extends AbstractApiTest{

	@Resource ExpendTypeMapper expendTypeMapper;
	
	@Test
	public void test() {
		System.out.println(expendTypeMapper.selectByPrimaryKey(5));
		
		ExpendType record = new ExpendType();
		System.out.println(expendTypeMapper.selectCount(record));
		record.setIsValid(null);
		System.out.println(expendTypeMapper.selectCount(record));
		record.setIsValid(false);
		System.out.println(expendTypeMapper.selectCount(record));
	}
	
	@Test
	public void testMysqlInsertBatch() {
		ExpendType e = new ExpendType();
		e.setName("333");
		List<ExpendType> recordList = new ArrayList<>();
		recordList.add(e);
		recordList.add(null);
		expendTypeMapper.insertList(recordList);
	}
}
