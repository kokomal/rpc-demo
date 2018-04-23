package com.http.testtcprpc.provider;

import com.http.testtcprpc.common.SayHelloService;

/*
 * 服务端的服务实现
 * */
public class SayHelloServiceImpl implements SayHelloService {

	@Override
	public String sayHello(String helloArg) {
		
		if(helloArg.equals("hello")){
			return "hello";
		}else{
			return "bye bye";
		}

	}

}
