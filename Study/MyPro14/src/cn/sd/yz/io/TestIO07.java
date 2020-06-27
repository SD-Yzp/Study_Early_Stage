package cn.sd.yz.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * �����ֽ�����������
 * �����ֽ�
 * 1������Դ�������ַ�����
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ�����Բ����ͷš�Ҳ����Ϊ����ʽͳһ����
 * @author Yin
 *
 */
public class TestIO07 {
	public static void main(String[] args) {
		//1������Դ
		String s = "i am going to school";
		//2��ѡ����
		ByteArrayInputStream is = null;
		byte[] datas = s.getBytes();
		is = new ByteArrayInputStream(datas);
		//3������
		byte[] datas_read = new byte[1024];
		int len = -1;
		try {
			while((len=is.read(datas_read))!=-1) {
				String string = new String(datas_read,0,len);
				System.out.println(string);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4���ͷ���Դ
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		System.out.println();
	
	}
}