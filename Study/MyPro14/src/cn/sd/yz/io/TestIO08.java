package cn.sd.yz.io;

import java.io.ByteArrayOutputStream;

/**
 * �����ֽ����������
 * ����ֽ�
 * 1������Դ��Դ�����ַ�����
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ�����Բ��ͷ�
 * @author Yin
 *
 */
public class TestIO08 {
	public static void main(String[] args) {
		//1������Դ
		byte[] dest = null;
		//2��ѡ����
		ByteArrayOutputStream os = null;
		os = new ByteArrayOutputStream();
		String string = "abcdefg";
		byte[] datas = string.getBytes();
		os.write(datas, 0, datas.length);
		dest = os.toByteArray();
		System.out.println(dest.length);
	}
}