package cn.sd.yz.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * ʹ�����롢����ַ�����ʵ�ֿ������ֽ���������ʵ�֣�ֻ������ϵ��
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ���ȴ򿪵ĺ�رգ�
 * @author Yin
 *
 */
public class Copy_String {
	public static void main(String[] args) {
		copy_String("text06.txt","text06_copy.txt");
		
	}
	
	static void copy_String(String srcPath,String destPath) {		
		//1������Դ
		File src = new File("text06.txt");       //Դ�豸
		File dest = new File("text06_copy.txt");  //Ŀ���豸
		//2��ѡ����
		Reader reader = null;
		Writer writer = null;
		try {
			reader = new FileReader(src);
			//3������
			//�������
			char[] datas = new char[1024];
			int len = -1;
			try {
				writer = new FileWriter(dest);
				while((len=reader.read(datas))!=-1) {
					String s = new String(datas,0,len);
					writer.append(s);
					writer.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(writer==null) {				
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(reader==null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}