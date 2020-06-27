package cn.sd.yz.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ʹ�����롢����ֽ���ʵ���ļ��Ŀ���
 */
public class Copy {
	public static void main(String[] args) {
		copy("D:/JAVA Code/workspace/MyPro14/src/cn/sd/yz/io/Copy.java","copy.txt");
	}
	
	
	static void copy(String srcPath,String destPath) {		
		//1������Դ
		File src = new File(srcPath);  //�����ļ���Դͷ
		File src_copy = new File(destPath);  //����ļ���Ŀ�ĵ�
		//2��ѡ����
		FileInputStream is = null;
		FileOutputStream os = null;
		//3������
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(src_copy);
			//3���������ֶζ�ȡ
			byte[] data = new byte[1024]; //��������
			int len = -1; //���ճ���
			try {
				while((len=is.read(data))!=-1) {
					os.write(data,0,len);  //�ֶ�д��
				}
				os.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e