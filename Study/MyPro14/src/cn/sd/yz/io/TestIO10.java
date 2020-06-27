package cn.sd.yz.io;

import java.io.*;


/**
 * ���Ի����ֽ���+�ļ��ֽ�����ֻ���ļ��ֽ�����Ч��
 * @author Yin
 *
 */
public class TestIO10 {
	public static void main(String[] args) {
		File src = new File("F:/wu2012.pdf");
		File dest = new File("F:/1/wu2012.pdf");
		
		long time1 = System.currentTimeMillis();
		copyFile1(src,dest);
		long time2 = System.currentTimeMillis();
		System.out.println("ʹ�û����ֽ��������ļ����ѵ�ʱ��Ϊ��"+(time2-time1));
		
		long time3 = System.currentTimeMillis();
		copyFile2(src,dest);
		long time4 = System.currentTimeMillis();
		System.out.println("��ʹ�û����ֽ��������ļ����ѵ�ʱ��Ϊ��"+(time4-time3));
		
	}
	
	
	//ʹ�û����ֽ�������ļ��ֽ��������ļ�
	public static void copyFile1(File src,File dest) {  
		FileInputStream is = null;
		BufferedInputStream bis = null;
		FileOutputStream os = null;
		BufferedOutputStream bos = null;
		try {
			is = new FileInputStream(src);
			bis = new BufferedInputStream(is);
			os = new FileOutputStream(dest);
			bos = new BufferedOutputStream(os);
			byte[] datas = new byte[1024];
			int len = -1;
			try {
				while((len = is.read(datas))!=-1) {
					os.write(datas, 0, len);
				}
				bos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(bos!=null) {						
						bos.close();
					}				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(os!=null) {						
						os.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(bis!=null) {
						bis.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(is!=null) {
						is.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	//��ʹ�û����ֽ�������ļ��ֽ��������ļ�
	public static void copyFile2(File src,File dest) {
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);
			byte[] datas = new byte[1024];
			int len = -1 ;
			try {
				while((len=is.read(datas))!=-1) {
					os.write(datas, 0, len);
				}
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
			try {
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}