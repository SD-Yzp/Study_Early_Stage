package cn.sd.yz.cl;

/**
 * ���԰�װ��
 * @author J
 *
 */
public class TestWrappedClass {
	public static void main(String[] args) {
		Integer int1 = new Integer(10);
		Integer int2 = Integer.valueOf(20);
		
		//Integer����ת��Ϊint
		int a=int1.intValue();
		int b=int2;
		System.out.println(b);
		
		//�ַ���ת��ΪInteger����
		Integer int3=Integer.parseInt("334");
		Integer int4=new Integer("999");
		System.out.println(int4);
		
		//Integer����ת��Ϊ�ַ���
		String str1=int3.toString();
		
		//һЩ����int������صĳ���
		System.out.println("int�ܱ�ʾ�����������"+Integer.MAX_VALUE);
		
	}
}