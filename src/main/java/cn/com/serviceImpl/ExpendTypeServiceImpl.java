/**
 * 
 */
package cn.com.serviceImpl;

import org.springframework.stereotype.Service;

import cn.com.model.ExpendType;
import cn.com.service.ExpendTypeService;

/**
 * <p>标题： ExpendTypeServiceImpl</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2018年1月26日 下午12:23:04 </p>
 * <p>作者：TaoCong</p>
 * <p>版本：1.0</p>
 */
@Service("expendTypeService")
public class ExpendTypeServiceImpl extends BaseServiceImpl<ExpendType> implements ExpendTypeService {

	@Override
	public ExpendType filterSelectByPrimaryKey(ExpendType t) {
		if (t.getIsValid() == null || !t.getIsValid())
			t = null;
		
		return t;
	}
}
