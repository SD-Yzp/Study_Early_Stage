package TestJoseph;

/**
 * Լɪ�򻷵����棬��ӡ��ÿ��ɾ���Ľڵ��element
 * ѭ����������get����
 * @author Yin
 *
 */
public class JosephCircle03 {
	private Node first;
	private Node last;
	private int size;
	
	
	
	public void add(Object obj) {
		Node node = new Node(obj);		
		
		if(first==null) {
			node.next=first;
			first=node;
			last=node;
		}else {
			node.next=first;
			last.next=node;
			last=node;
			
		}
		size++;
	}
		
	
	public String get(int index) {
		Node temp=first;
		for(int i=0;i<index;i++) {
			temp=temp.next;
		}
		return (String) temp.element;
	} 
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		
		Node temp = first;		
		for(int i=0;i<size;i++) {
			sb.append(temp.element+",");
			temp=temp.next;
		}
		
		sb.setCharAt(sb.length()-1, ']');
		
		return sb.toString();
	}


	public void remove(int index) {
		if(index<0||index>=size) {
			throw new RuntimeException("�±�Խ�磡");
		}
		
		Node temp1 = first;
		Node temp2 = last;
		if(index==0) {    //�����ж��Ƿ�Ϊ��һ���ڵ�����һ���ڵ㣬��Ȼɾ��������⣬��Ϊ��û�иı�list�е�first��last�Ľڵ�
			last.next=first.next;
			first=first.next;
		}else if(index==size-1){
			for(int i=0;i<index;i++) {
				temp1=temp1.next;   //Ҫɾ���Ľڵ�
				temp2=temp2.next;   //Ҫɾ���ڵ����һ���ڵ�
			}	
			temp2.next=temp1.next;
			last=temp2;
		}else{			
			for(int i=0;i<index;i++) {
				temp1=temp1.next;   //Ҫɾ���Ľڵ�
				temp2=temp2.next;   //Ҫɾ���ڵ����һ���ڵ�
			}	
			temp2.next=temp1.next;
		}
		
		size--;
	}
	
	
	public int getSize() {
		return size;
	}


	public static void main(String[] args) {
		JosephCircle03 list = new JosephCircle03();
		
		//������ʮһ���ˣ������ֱ�ʾ
		for(int i=1;i<=41;i++) {
			list.add(""+i);  //������ת��Ϊ�ַ���
		} 
			
		int sum=-1;  //��ʼΪ-1����Ϊ�±꿪ʼΪ0
		while(list.getSize()>2) {
			for(int i=0;i<3;i++) {
				sum++;
			}
			//��֤ÿ���Ƴ���������������
			if(sum>list.getSize()-1) {
				sum-=list.getSize();
			}
			
			System.out.println("����Ҫ�Ƴ�������Ϊ��"+list.get(sum));
			list.remove(sum);
			sum--;  //ÿ���Ƴ����ݺ�-1����Ϊ������ɾ�����ݺ����к�ߵĽڵ��±�-1
		}
		System.out.println("����ʣ�������Ϊ��"+list);
	}	
}