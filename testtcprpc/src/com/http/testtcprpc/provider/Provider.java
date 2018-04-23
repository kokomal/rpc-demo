package com.http.testtcprpc.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.http.testtcprpc.common.SayHelloService;

/**
 * 
 * @Description: �����ṩ��
 *
 */
public class Provider {

	// ���еķ���
	private static Map<String, Object> services = new HashMap<String, Object>();
	// Ԥ�Ƚ��ӿڵ�ʵ��ע�뵽services���棬����spring��������bean����һ��
	static {
		services.put(SayHelloService.class.getName(), new SayHelloServiceImpl());
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		ServerSocket server = new ServerSocket(1234);
		while (true) {
			Socket socket = server.accept();

			// ����Լ����˳���ȡ������Ϣ
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			String interfacename = input.readUTF(); // �ӿ�����
			String methodName = input.readUTF(); // ��������
			Class<?>[] parameterTypes = (Class<?>[]) input.readObject(); // ��������
			Object[] arguments = (Object[]) input.readObject(); // ��������

			// ִ�е���
			Class<?> serviceinterfaceclass = Class.forName(interfacename);// �õ��ӿڵ�class
			Object service = services.get(interfacename);// ȡ�÷���ʵ�ֵĶ���
			Method method = serviceinterfaceclass.getMethod(methodName, parameterTypes);// ���Ҫ���õķ���
			Object result = method.invoke(service, arguments);

			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(result);
		}
	}
}
