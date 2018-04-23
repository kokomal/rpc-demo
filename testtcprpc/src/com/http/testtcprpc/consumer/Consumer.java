/**
 * 
 */
package com.http.testtcprpc.consumer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.UnknownHostException;

import com.http.testtcprpc.common.SayHelloService;

/**
 * @Description: 服务消费者
 * 通过端口发送流，获取生产者的反馈后，获得结果
 **/
public class Consumer {

	public static void main(String[] args)
			throws UnknownHostException, IOException, SecurityException, NoSuchMethodException, ClassNotFoundException {

		// 接口名称
		String interfacename = SayHelloService.class.getName();

		// 需要远程执行的方法，注意这里的方法是从interface里面直接获得method，与实现impl无关！
		Method method = SayHelloService.class.getMethod("sayHello", java.lang.String.class);

		// 需要传递到远端的参数
		Object[] arguments = { "hello" };

		@SuppressWarnings("resource")
		Socket socket = new Socket("127.0.0.1", 1234);

		// 将方法名称和参数传递到远端
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		output.writeUTF(interfacename); // 接口名称
		output.writeUTF(method.getName()); // 方法名称
		output.writeObject(method.getParameterTypes());
		output.writeObject(arguments);

		// 从远端读取方法执行结果
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		Object result = input.readObject();

		// 使用代理对象来处理，直接返回string类型

		System.out.println(result);
	}
}
