package cn.sd.yz.cl;

/**
 * �����Զ�װ��Ͳ���
 * @author J
 *
 */
public class TestAutoBox {
	public static void main(String[] args) {
		Integer i = 23;//�Զ�װ��
		int a = new Integer(20); //�Զ�����
		//��Ҫע�������
		Integer c = null;
//		int d = c; // �˴���ʵ���ǣ�c.intValue(),����׿�ָ���쳣������
		
		
		Integer int1=-128;
		Integer int2=-128;
		System.out.println(int1==int2); //true ��Ϊ128�ڻ��淶Χ��
		System.out.println(int1.equals(int2)); //true
		Integer int3 = 1234;
		Integer int4 = 1234;
		System.out.println(int3==int4); //false ��Ϊ1234���ڻ��淶Χ��
		System.out.println(int3.equals(int4)); // true
		
		
		
	}
}