/**
 * 
 */
package com.http.testserialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Description: java���л� 
 **/
public class TestJavaSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		Person zhangsan = Person.genZhangsan();
		
		//����һ���ֽ����������
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		//���������
		ObjectOutputStream out = new ObjectOutputStream(os);
		
		//������д�뵽�ֽ�����������������л�
		out.writeObject(zhangsan);
		byte[] zhangsanByte = os.toByteArray();
		
		//�ֽ�����������
		ByteArrayInputStream is = new ByteArrayInputStream(zhangsanByte);
		//ִ�з����л��������ж�ȡ����
		ObjectInputStream in = new ObjectInputStream(is);
		Person person = (Person)in.readObject();
		
		System.out.println("name : " + person.getName() + ", age : " + person.getAge());
	}

	
	
}
