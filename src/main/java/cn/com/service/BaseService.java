package cn.com.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.com.common.ServiceResult;

/**
 * 
 * <p>标题： BaseService</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2018年1月25日 上午11:27:33 </p>
 * <p>作者：TaoCong</p>
 * <p>版本：1.0</p>
 */
public interface BaseService<T> {

	/**
	 * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
	 * @return
	 */
	public ServiceResult<T> selectByPrimaryKey(Object key);
	
	/**
	 * 根据实体中的属性值进行查询，查询条件使用等号
	 * @return
	 */
	public ServiceResult<List<T>> select(T t);
	
	/**
	 * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
	 * @return
	 */
	public ServiceResult<T> selectOne(T t);
	
	/**
	 * 根据Example条件进行查询
	 * @return
	 */
	public ServiceResult<List<T>> selectByExample(Object example);
	
	/**
	 * 根据实体中的属性值进行分页查询，查询条件使用等号
	 * @return
	 */
	public ServiceResult<PageInfo<T>> page(T t,int pageNum, int pageSize);
	
	/**
	 * 根据Example条件进行分页查询
	 * @return
	 */
	public ServiceResult<PageInfo<T>> pageByExample(Object example,int pageNum, int pageSize);
	
	/**
	 * 保存一个实体，null的属性不会保存，会使用数据库默认值
	 * <p>会将当前时间赋值给createTime/updateTime</p>
	 * @return
	 */
	public ServiceResult<Void> insert(T t);
	
	/**
	 * 批量保存,null的属性会保存，不会使用数据库默认值
	 * <p>会将当前时间赋值给createTime/updateTime</p>
	 * @param t
	 * @return
	 */
	public ServiceResult<Void> insertList(List<T> t);
	
	/**
	 * 根据主键更新实体全部字段，null值会被更新
	 * @return
	 */
	public ServiceResult<Void> updateByPrimaryKey(T t);

	/**
	 * 根据主键更新实体全部字段，null值不会被更新
	 * @return
	 */
	public ServiceResult<Void> updateByPrimaryKeySelective(T t);
	
	/**
	 * 根据主键字段进行删除，方法参数必须包含完整的主键属性
	 * @return
	 */
	public ServiceResult<Void> deleteByPrimaryKey(Object key);
	
	/**
	 * 填充查询结果所需要的属性,影响所有公共查询方法,默认实现类无逻辑
	 * @param list
	 */
	public void fillAttrs(List<T> list);
	
	/**
	 * 过滤通过主键查询的数据，用于逻辑删除等场景（默认实现直接返回）
	 * @param t
	 * @return
	 */
	public T filterSelectByPrimaryKey(T t);
}
