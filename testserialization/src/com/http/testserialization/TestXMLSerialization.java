/**
 * 
 */
package com.http.testserialization;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @Description: ʹ��xml���ж������л� ������תΪxml
 **/
public class TestXMLSerialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person person = Person.genZhangsan();

		// ��person�������л�ΪXML
		XStream xStream = new XStream(new DomDriver());
		// ����Person��ı���
		// ����Ļ��ͻ�Ƚ�ugly
		// <com.http.testserialization.Person>
		xStream.alias("person", Person.class);
		String personXML = xStream.toXML(person);

		// ��XML�����л���ԭΪperson����
		Person zhangsan = (Person) xStream.fromXML(personXML);

		System.out.println(personXML);
		System.out.println(zhangsan.getBirth());

	}

}
