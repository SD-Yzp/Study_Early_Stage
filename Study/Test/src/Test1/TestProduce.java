package Test1;

public class TestProduce {
    public static void main(String[] args) {
        SyncStack sStack = new SyncStack();// ���建��������
        Shengchan sc = new Shengchan(sStack);// ���������̣߳�
        Xiaofei xf = new Xiaofei(sStack);// ���������̣߳�
        sc.start();
        xf.start();
    }
}
 
class Mantou {// ��ͷ
    int id;
 
    Mantou(int id) {
        this.id = id;
    }
}
 
class SyncStack {// ������(�൱�ڣ���ͷ��)
    int index = 0;
    Mantou[] ms = new Mantou[10];
 
    public synchronized void push(Mantou m) {
        while (index == ms.length) {//˵����ͷ������
            try {
               //wait���̻߳Ὣ���е����ͷţ���������״̬��
               //����������Ҫ�����߳̾Ϳ��Ի������
                this.wait();
                //����ĺ�����ִ�д˷������߳���ͣ����������״̬��
                //����������������ͷ����������
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ms[index] = m;
        index++;
        // �����ڵ�ǰ����ȴ����еȴ��ĵ�һ���̡߳�
        //notifyAll���������ڵ�ǰ����ȴ����еȴ��������̡߳�
        // ��������ѵĻ����Ժ��������̶߳������ȴ��̣߳�û���˻��ѡ�
        this.notify();
    }
 
    public synchronized Mantou pop() {
        while (index == 0) {//�����ͷ���ǿյģ�
            try {
                //�����ͷ���ǿյģ�����ͣ�������̣߳���Ϊûʲô�����ѵ����
                this.wait();                //�������߳��������������ѣ�
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        index--;
        this.notify();
        return ms[index];
    }
}
 
class Shengchan extends Thread {// �������߳�
    SyncStack ss = null;
 
    public Shengchan(SyncStack ss) {
        this.ss = ss;
    }
 
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("������ͷ��" + i);
            Mantou m = new Mantou(i);
            ss.push(m);
        }
    }
}
 
class Xiaofei extends Thread {// �������̣߳�
    SyncStack ss = null;
 
    public Xiaofei(SyncStack ss) {
        this.ss = ss;
    }
 
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Mantou m = ss.pop();
            System.out.println("������ͷ��" + i);
 
        }
    }
}