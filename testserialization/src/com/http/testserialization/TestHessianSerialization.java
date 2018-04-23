/**
 * 
 */
package com.http.testserialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * @Description: hessian���л�
 **/
public class TestHessianSerialization {

	public static void main(String[] args) throws IOException {

		Person zhangsan = Person.genZhangsan();
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		// hessian�����л����
		HessianOutput ho = new HessianOutput(os); // hessian��װһ��outputstream
		ho.writeObject(zhangsan);
		byte[] zhansanByte = os.toByteArray();

		ByteArrayInputStream is = new ByteArrayInputStream(zhansanByte);
		// hessian�ķ����л���ȡ����
		HessianInput hi = new HessianInput(is);
		Person person = (Person) hi.readObject();

		System.out.println("name : " + person.getName() + ", age : " + person.getAge());
	}

}
