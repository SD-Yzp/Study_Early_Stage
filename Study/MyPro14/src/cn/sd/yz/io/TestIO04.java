package cn.sd.yz.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ļ���ȡ����
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 * @author Yin
 *
 */
public class TestIO04 {
	public static void main(String[] args) {
		//1������Դ
		File dest = new File("text.txt");
		//2��ѡ����
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(dest);
			//3������
			String str = "i am studying";
			try {
				os.write(str.getBytes());
				os.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(os!=null) {					
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}