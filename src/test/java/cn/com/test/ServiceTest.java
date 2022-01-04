/**
 * 
 */
package cn.com.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.github.pagehelper.PageInfo;

import cn.com.common.ServiceResult;
import cn.com.common.util.JsonUtils;
import cn.com.model.ExpendType;
import cn.com.service.ExpendTypeService;
import tk.mybatis.mapper.entity.Example;

/**
 * <p>标题： ServiceTest</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2018年1月26日 下午12:25:00 </p>
 * <p>作者：TaoCong</p>
 * <p>版本：1.0</p>
 */
public class ServiceTest extends AbstractApiTest {

	@Resource ExpendTypeService expendTypeService;
	
	@Test
	public void testInsert() {
		System.out.println("新增null：" + JsonUtils.object2Json(expendTypeService.insert(null)));
		
		ExpendType t1 = new ExpendType();
		ServiceResult<Void> result1 = expendTypeService.insert(t1);
		System.out.println("新增：" + JsonUtils.object2Json(result1));
		
//		List<ExpendType> list = new ArrayList<>();
//		System.out.println("新增empty：" + JsonUtils.object2Json(expendTypeService.insertList(list)));
//		ExpendType t2 = new ExpendType();
//		ExpendType t3 = new ExpendType();
//		list.add(t2);
//		list.add(t3);
//		ServiceResult<Void> result2 = expendTypeService.insertList(list);
//		System.out.println("新增list：" + JsonUtils.object2Json(result2));
//		List<ExpendType> list2 = new ArrayList<>();
//		list2.add(null);
//		result2 = expendTypeService.insertList(list2);
//		System.out.println("新增list包含null：" + JsonUtils.object2Json(result2));
	}
	
	@Test
	public void testUpdate() {
		ExpendType t = new ExpendType();
		t.setId(1);
		expendTypeService.updateByPrimaryKey(t);
		ExpendType t2 = new ExpendType();
		t2.setId(2);
		expendTypeService.updateByPrimaryKeySelective(t2);
	}
	
	@Test
	public void testDelete() {
		expendTypeService.deleteByPrimaryKey(1);
		expendTypeService.deleteByPrimaryKey(null);
	}
	
	@Test
	public void testSelect() {
		ExpendType t = new ExpendType();
		ServiceResult<PageInfo<ExpendType>> page = expendTypeService.page(t, 1, 10);
		System.out.println("page:" + JsonUtils.object2Json(page));
		
		System.out.println("select null:" + JsonUtils.object2Json(expendTypeService.select(null).getResult().size()));
//		System.out.println("selectOne null:" + JsonUtils.object2Json(expendTypeService.selectOne(null)));
	}
	
	@Test
	public void testSelectByExample() {
		ServiceResult<PageInfo<ExpendType>> result = expendTypeService.pageByExample(null, 1, 10);
		System.out.println("page example null:" + result.getResult().getTotal());
		
		// SELECT count(0) FROM EXPEND_TYPE WHERE (ID = ? AND type = 1) OR (NAME = ?) 
		Example example = new Example(ExpendType.class);
		example.createCriteria().andEqualTo("id", "123").andCondition("type=1");
		example.or().andEqualTo("name", "xxx");
		System.out.println("page example" + expendTypeService.pageByExample(example, 1, 10).getResult().getTotal());
	}
	
	@Test
	public void testSelectById() {
		ExpendType result = expendTypeService.selectByPrimaryKey(2).getResult();
		System.out.println(result);
	}
}
