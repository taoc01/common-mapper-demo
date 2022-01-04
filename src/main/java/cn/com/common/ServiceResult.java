package cn.com.common;

import java.io.Serializable;

import cn.com.common.util.JsonUtils;

/**
 * 
 * <p>标题： ServiceResult</p>
 * <p>
 *    功能描述：
 *      系统执行结果
 * </p>
 * <p>创建日期：2018年1月25日 下午1:50:15 </p>
 * <p>作者：TaoCong</p>
 * <p>版本：1.0</p>
 */
public class ServiceResult<T> implements Serializable{

	private static final long serialVersionUID = -5295106851751528524L;

	private boolean success = true;

	private Integer errorCode;

	/**
	 * 错误描述
	 */
	private String errorMsg;

	private T result;

	public ServiceResult() {
	};

	public ServiceResult(T result) {
		this.result = result;
	}

	public ServiceResult(ErrMsgEnum errMsgEnum) {
		this.errorCode = errMsgEnum.getErrCode();
		this.errorMsg = errMsgEnum.getErrMsg();
		this.success = false;
	}

	public ServiceResult(ErrMsgEnum errMsgEnum, String errMsg) {
		this.errorCode = errMsgEnum.getErrCode();
		this.errorMsg = errMsg;
		this.success = false;
	}
	
	public ServiceResult(ServiceResult<?> serviceResult, T result) {
		this.success = serviceResult.success;
		this.errorCode = serviceResult.errorCode;
		this.errorMsg = serviceResult.errorMsg;
		this.result = result;
	}
	
	/**
	 * 判断执行结果是否出错
	 * 
	 * @return
	 */
	public boolean isSuccess() {
		return this.success;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public Integer getErrCode() {
		return errorCode;
	}

	public void setErrCode(Integer errCode) {
		this.errorCode = errCode;
	}

	public String getErrMsg() {
		return errorMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errorMsg = errMsg;
	}

	@Override
	public String toString() {
		return JsonUtils.object2Json(this);
	}
}
