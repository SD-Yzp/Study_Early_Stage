package P1;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *���������ڶ���
 *��ȷ��Ӧ���� 
 * @author Yin
 *
 */
public class MyCalendar2 {
	public static void main(String[] args) {
		String str = "2019-8-30";
		String[] date = str.split("-");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1])-1;
		int day = Integer.parseInt(date[2]);
		Calendar c = new GregorianCalendar(year,month,day);
		
		int days = c.getActualMaximum(Calendar.DATE);//��ñ��µ����ֵ
		
		//��������Ϊ���µ�һ��
		c.set(Calendar.DATE,1);
		int startDay = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(startDay);
		
		//��ӡ������һ��
		System.out.print("��\tһ\t��\t��\t��\t��\t��\n");
		
		//ͨ����һ������ǰ�߿ճ����ĸ���
		for(int i=1;i<startDay;i++)
		{
			System.out.print(" \t");
		}
		
		//��ӡ����ÿһ��
		int count = 1;
		boolean flag = true;
		while(count<=days)
		{
			if(flag)
			{				
				for(int i=0;i<7-startDay+1;i++)
				{
					if(i==7-startDay) 
					{					
						System.out.print(count+"\n");
					}
					else
					{
						System.out.print(count+"\t");
					}
					count++;
				}
				flag=!flag;
			}
			else 
			{				
				for(int i=0;i<7&&count<=days;i++)
				{
					if(i==6) 
					{					
						System.out.print(count+"\n");
					}
					else
					{
						System.out.print(count+"\t");
					}
					count++;
				}
			}
		}
	}
}