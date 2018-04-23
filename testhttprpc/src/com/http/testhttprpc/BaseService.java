/**
 * 
 */
package com.http.testhttprpc;

import java.util.Map;

/**
 * @Description: 基础服务接口 
 **/
public interface BaseService {

	public Object execute(Map<String,Object> args);
}
