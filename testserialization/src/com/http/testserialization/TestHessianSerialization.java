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
 * @Description: hessian序列化
 **/
public class TestHessianSerialization {

	public static void main(String[] args) throws IOException {

		Person zhangsan = Person.genZhangsan();
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		// hessian的序列化输出
		HessianOutput ho = new HessianOutput(os); // hessian包装一下outputstream
		ho.writeObject(zhangsan);
		byte[] zhansanByte = os.toByteArray();

		ByteArrayInputStream is = new ByteArrayInputStream(zhansanByte);
		// hessian的反序列化读取对象
		HessianInput hi = new HessianInput(is);
		Person person = (Person) hi.readObject();

		System.out.println("name : " + person.getName() + ", age : " + person.getAge());
	}

}
