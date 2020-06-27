package cn.sd.yz.io;

import java.io.UnsupportedEncodingException;

/**
 * ���Ա���(encode)
 * @author Yin
 *
 */
public class TestEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "��������ʹ��a";
		//���룺�ֽ�����
		byte[] datas = s.getBytes(); //Ĭ��ʹ�ù��̵��ַ���UTF-8
		System.out.println(datas);
		
		//���룺ʹ�������ַ���
		datas = s.getBytes("UTF-16LE");
		System.out.println(datas.length);
		
		datas = s.getBytes("GBK");
		System.out.println(datas.length);
	}
}