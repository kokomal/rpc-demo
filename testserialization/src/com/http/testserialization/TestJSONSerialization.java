/**
 * 
 */
package com.http.testserialization;

import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @Description: 使用json进行对象序列化
 * 适用于对象的跨平台请求（HTTP POST）
 **/
public class TestJSONSerialization {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws IOException {

		Person person = Person.genZhangsan();

		// json对象序列化
		String personJson = null;

		StringWriter sw = new StringWriter();
		JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
		mapper.writeValue(gen, person);
		gen.close();
		personJson = sw.toString();

		// json对象反序列化
		Person zhangsan = (Person) mapper.readValue(personJson, Person.class);

		System.out.println(personJson);
		System.out.println(zhangsan.getName());

	}
}
