/**
 * 
 */
package cn.com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

/**
 * <p>标题： BaseModel</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2018年1月25日 上午9:24:52 </p>
 * <p>作者：TaoCong</p>
 * <p>版本：1.0</p>
 */
public class BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "CREATE_TIME")
	private Date createTime;
	
	@Column(name = "UPDATE_TIME")
	private Date updateTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
