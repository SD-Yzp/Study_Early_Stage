package cn.sd.yz.mycollection;

import java.util.Arrays;

/**
 * ʵ��get������ͨ��key-value�Ի��
 * @author Y
 *
 */
public class MyHashMap03 {
	Node2[] table;  //λͰ���顣 bucket array
	int size; //��ŵļ�ֵ�Եĸ���
	
	public MyHashMap03() {
		super();
		table = new Node2[16];   //����һ�㶨��Ϊ2��������
	}
	
	public Object get(Object key) {
		Node2 temp = null;
		Object value =null;
		int hash = myHash(key.hashCode(),table.length);

		if(table[hash]!=null) {
			temp=table[hash];
			
			while(temp!=null) {
				if(temp.key.equals(key)) {
					value=temp.value;
					break;
				}else {
					temp=temp.next;
				}
			}
		}
		
//		for(int i=0;i<table.length;i++) {
//			temp=table[i];
//			while(temp!=null) {
//				if(temp.key.equals(key)) {
//					value=temp.value;
//					break;
//				}
//				temp=temp.next;
//			}
//		}
		return value;
	}
	
	public void put(Object key,Object value) {
		//�������µĽڵ����
		Node2 newNode = new Node2();
		Node2 iterNode = new Node2();
		boolean keyRepeat=false;
		
		newNode.hash=myHash(key.hashCode(),table.length);
		newNode.key=key;
		newNode.value=value;
		newNode.next=null;
		
		Node2 temp = table[newNode.hash];
		
		if(temp==null) {
			//�˴�����Ԫ��Ϊ�գ���ֱ�Ӱ��½ڵ�Ž�ȥ
			table[newNode.hash]=newNode;
			size++;
		}else {
			//�˴�����Ԫ�ز�Ϊ�գ��������Ӧ�б�
			while(temp!=null) {
				if(temp.key.equals(key)) {
					keyRepeat=true;
					temp.value=value;
					break;
				}else {
					iterNode=temp;
					temp=temp.next;
				}
			}
			if(!keyRepeat) {				
				iterNode.next=newNode;
				size++;
			}
		}
		
	}
	
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		
		for(int i=0;i<table.length;i++) {
			Node2 temp = table[i];
			
			while(temp!=null) {
				sb.append(temp.key+":"+temp.value+" ");
				temp=temp.next;
			}
		}
		sb.setCharAt(sb.length()-1,'}');
		return sb.toString();
	}

	public static void main(String[] args) {
		MyHashMap03 m1=new MyHashMap03();
//		m1.put(10, "aa");
//		m1.put(20, "bb");
//		m1.put(30, "cc");
//		m1.put(20, "ss");
		
		
		m1.put(53, "hh");
		m1.put(69, "gg");
		m1.put(85, "aa");
		
		System.out.println(m1);
		System.out.println(m1.get(53));
	}
	
	
	
	
	public int myHash(int v,int length) {
//		System.out.println("length:"+length);
//		System.out.println("key.hashcode:"+v);
//		System.out.println("hash in myHash:"+(v&(length-1)));  //ֱ��λ���㣬Ч�ʸ�
//		System.out.println("hash in myHash:"+(v%length));  //ȡģ���㣬Ч�ʵ�
		return v&(length-1);
	}
	
}