/**
 * 
 */
package com.http.testserialization;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @Description: 使用xml进行对象序列化 将对象转为xml
 **/
public class TestXMLSerialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person person = Person.genZhangsan();

		// 将person对象序列化为XML
		XStream xStream = new XStream(new DomDriver());
		// 设置Person类的别名
		// 不设的话就会比较ugly
		// <com.http.testserialization.Person>
		xStream.alias("person", Person.class);
		String personXML = xStream.toXML(person);

		// 将XML反序列化还原为person对象
		Person zhangsan = (Person) xStream.fromXML(personXML);

		System.out.println(personXML);
		System.out.println(zhangsan.getBirth());

	}

}
