package cn.sd.yz.commons;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * �г����Ｖ
 * @author Yin
 *
 */
public class CIOTest02 {
	public static void main(String[] args) {
		//listFiles�����βεĺ����ǵ�һ��ΪĿ¼���ڶ���Ϊ��������������Ϊ����Ŀ¼
		Collection<File> files = FileUtils.listFiles(new File("D:/JAVA Code/workspace/IO_study"), 
				EmptyFileFilter.NOT_EMPTY, null);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		
		System.out.println("------���Ƿָ���------");
		
		//listFiles�����βεĺ����ǵ�һ��ΪĿ¼���ڶ���Ϊ��������������Ϊ����Ŀ¼
		files = FileUtils.listFiles(new File("D:/JAVA Code/workspace/IO_study"), 
				EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		
		System.out.println("------���Ƿָ���------");
		
		//listFiles�����βεĺ����ǵ�һ��ΪĿ¼���ڶ���Ϊ��������������Ϊ����Ŀ¼
		files = FileUtils.listFiles(new File("D:/JAVA Code/workspace/IO_study"), 
				new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		
		System.out.println("------���Ƿָ���------");
		
		//listFiles�����βεĺ����ǵ�һ��ΪĿ¼���ڶ���Ϊ��������������Ϊ����Ŀ¼
		files = FileUtils.listFiles(new File("D:/JAVA Code/workspace/IO_study"), 
				FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")), DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
	
		System.out.println("------���Ƿָ���------");
		
		//listFiles�����βεĺ����ǵ�һ��ΪĿ¼���ڶ���Ϊ��������������Ϊ����Ŀ¼
		files = FileUtils.listFiles(new File("D:/JAVA Code/workspace/IO_study"), 
				FileFilterUtils.or(new SuffixFileFilter("java"),
						new SuffixFileFilter("class"),EmptyFileFilter.EMPTY), DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		
		System.out.println("------���Ƿָ���------");
		
		//listFiles�����βεĺ����ǵ�һ��ΪĿ¼���ڶ���Ϊ��������������Ϊ����Ŀ¼
		files = FileUtils.listFiles(new File("D:/JAVA Code/workspace/IO_study"), 
				FileFilterUtils.and(new SuffixFileFilter("java"),
						EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
	}
}