/**
 * 
 */
package cn.com.test;

import cn.com.common.ErrMsgEnum;
import cn.com.common.ServiceResult;

/**
 * <p>标题： ServiceResultTest</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2018年1月25日 下午2:03:49 </p>
 * <p>作者：TaoCong</p>
 * <p>版本：1.0</p>
 */
public class ServiceResultTest {

	public static void main(String[] args) {
		ServiceResult<Void> s = new ServiceResult<>(ErrMsgEnum.ERR_404);
		ServiceResult<Void> s2 = new ServiceResult<>();
		System.out.println(s);
		System.out.println(s2);
	}
}
