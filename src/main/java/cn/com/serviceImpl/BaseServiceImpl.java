/**
 * 
 */
package cn.com.serviceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.common.ErrMsgEnum;
import cn.com.common.ServiceResult;
import cn.com.model.BaseModel;
import cn.com.service.BaseService;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <p>标题： BaseServiceImpl</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2018年1月26日 上午11:32:54 </p>
 * <p>作者：TaoCong</p>
 * <p>版本：1.0</p>
 */
public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	Mapper<T> mapper;

	@Autowired
	MySqlMapper<T> mysqlMapper;

	@Override
	public ServiceResult<T> selectByPrimaryKey(Object key) {
		T t = filterSelectByPrimaryKey(mapper.selectByPrimaryKey(key));
		if (t != null)
			fillAttrs(Arrays.asList(t));
		return new ServiceResult<>(t);
	}

	@Override
	public ServiceResult<List<T>> select(T t) {
		List<T> list = mapper.select(t);
		if (!CollectionUtils.isEmpty(list))
			fillAttrs(list);
		return new ServiceResult<>(list);
	}

	@Override
	public ServiceResult<T> selectOne(T t) {
		T obj = mapper.selectOne(t);
		if (obj != null)
			fillAttrs(Arrays.asList(obj));
		return new ServiceResult<>(obj);
	}

	@Override
	public ServiceResult<List<T>> selectByExample(Object example) {
		List<T> list = mapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(list))
			fillAttrs(list);
		return new ServiceResult<>(list);
	}

	@Override
	public ServiceResult<PageInfo<T>> page(T t, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<T> list = mapper.select(t);
		if (!CollectionUtils.isEmpty(list))
			fillAttrs(list);
		return new ServiceResult<>(new PageInfo<>((list)));
	}

	@Override
	public ServiceResult<PageInfo<T>> pageByExample(Object example, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<T> list = mapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(list))
			fillAttrs(list);
		return new ServiceResult<>(new PageInfo<>((list)));
	}

	@Override
	public ServiceResult<Void> insert(T t) {
		if (t == null) {
			return new ServiceResult<>(ErrMsgEnum.ERR_1000, "The insert param is null");
		}

		if (t instanceof BaseModel) {
			Date now = new Date();
			((BaseModel) t).setCreateTime(now);
			((BaseModel) t).setUpdateTime(now);
		}
		mapper.insertSelective(t);
		
		return new ServiceResult<>();
	}

	@Override
	public ServiceResult<Void> insertList(List<T> t) {
		if (CollectionUtils.isEmpty(t)) {
			return new ServiceResult<>(ErrMsgEnum.ERR_1000, "The insert param is empty");
		}

		Date now = new Date();
		for (T item : t) {
			if (item == null) {
				return new ServiceResult<>(ErrMsgEnum.ERR_1000, "The insert param list contain null");
			}
			if (item instanceof BaseModel) {
				((BaseModel) item).setCreateTime(now);
				((BaseModel) item).setUpdateTime(now);
			}
		}

		mysqlMapper.insertList(t);
		return new ServiceResult<>();
	}

	@Override
	public ServiceResult<Void> updateByPrimaryKey(T t) {
		if (t == null) {
			return new ServiceResult<>(ErrMsgEnum.ERR_1000, "The update param is null");
		}

		if (t instanceof BaseModel) {
			Date now = new Date();
			((BaseModel) t).setUpdateTime(now);
		}
		mapper.updateByPrimaryKey(t);
		return new ServiceResult<>();
	}

	@Override
	public ServiceResult<Void> updateByPrimaryKeySelective(T t) {
		if (t == null) {
			return new ServiceResult<>(ErrMsgEnum.ERR_1000, "The update param is null");
		}

		if (t instanceof BaseModel) {
			Date now = new Date();
			((BaseModel) t).setUpdateTime(now);
		}
		mapper.updateByPrimaryKeySelective(t);
		return new ServiceResult<>();
	}

	@Override
	public ServiceResult<Void> deleteByPrimaryKey(Object key) {
		mapper.deleteByPrimaryKey(key);
		return new ServiceResult<>();
	}

	@Override
	public void fillAttrs(List<T> list) {

	}

	@Override
	public T filterSelectByPrimaryKey(T t) {
		return t;
	}

}
