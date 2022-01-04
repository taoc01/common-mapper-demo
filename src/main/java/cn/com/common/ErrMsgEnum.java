package cn.com.common;

public enum ErrMsgEnum {
	ERR_404(404,"访问的URL不存在"),
	ERR_1000(1000,"非法参数"),
	ERR_UNKNOWN(1500,"未知异常"),
	;

	/**
	 * 错误编码
	 */
	private Integer errCode;

	/**
	 * 错误信息
	 */
	private String errMsg;

	public Integer getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public static ErrMsgEnum valueOf(Integer errCode) {
		for (ErrMsgEnum errMsgEnum : ErrMsgEnum.values()) {
			if (errMsgEnum.errCode.equals(errCode)) {
				return errMsgEnum;
			}
		}
		return ErrMsgEnum.ERR_UNKNOWN;
	}

	private ErrMsgEnum(Integer errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
}
