/**
 * 
 */
package com.http.testrestfulrpc;

import java.util.Map;

/**
 * @Description: 基础服务接口
 **/
public interface BaseService {

	public Object execute(Map<String,Object> args);
}
