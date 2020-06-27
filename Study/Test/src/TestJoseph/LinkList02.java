package TestJoseph;

/**
 * ������������remove������
 * ����JAVAȡ����ָ�룬���Բ���Ҫͷָ��
 * @author Yin
 *
 */
public class LinkList02 {
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
		LinkList02 list = new LinkList02();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		
		list.remove(7);
		
		System.out.println(list.getSize());
		System.out.println(list);
	}
	
}