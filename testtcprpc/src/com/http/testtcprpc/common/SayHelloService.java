/**
 * 
 */
package com.http.testtcprpc.common;

/**
	公共的接口，声明服务的方法签名
	供provider和consumer公共使用
	将来可以打成jar包放入私服，供大家公共引用
 **/
public interface SayHelloService {

	/**
	 * 问好的接口
	 * @param helloArg 参数
	 * @return
	 */
	public String sayHello(String helloArg);
}
