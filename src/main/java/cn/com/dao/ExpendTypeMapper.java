package cn.com.dao;

import cn.com.model.ExpendType;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <p>标题： ExpendTypeMapper</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2017年10月25日 下午4:12:14 </p>
 * <p>作者：TaoCong</p>
 * <p>版本：1.0</p>
 */
public interface ExpendTypeMapper extends MySqlMapper<ExpendType>, Mapper<ExpendType> {

//	public ExpendType searchById(Integer id);
}
