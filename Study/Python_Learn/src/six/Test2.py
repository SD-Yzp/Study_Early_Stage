# coding=gbk
s = '''˫�� ���߹� ���� ���� ��ң�� ���� ������ ���ַ��� �Ƿ� ��� ���߹� ����
       ���� ���� ������ ���� ���� Ľ�ݸ� ���� Ľ�ݸ� ��ܽ �Ƿ� ����� ��ܽ
       ���ַ��� С��Ů ��� Ľ�ݸ� ÷���� ��Ī�� ���߹� ���޼� ÷���� ����
       ���� ����Ⱥ ��ҩʦ ���� ���� ���ַ��� ������ ������ ������ �Ƿ� �Ƿ�
       ���� �Ƿ� ���ַ��� Ԭ���� ���޼� ���� ���� ��Ī�� ���� ���� ��ܽ ������
       �Ƿ� ���� ÷���� ˫�� ���� �¼��� Ԭ���� ��ܽ ��ܽ ���� ���� ���ַ���
       ������ Ľ�ݸ� ������ ���� ���� ����� ��ҩʦ Ԭ���� ���� ���պ��� ������
       ��Ī�� ���� ��ң�� �Ƿ� ��ң�� ���պ��� ��ܽ ���� ���޼� ��� Ľ�ݸ�
       ��ң�� ���� ˫�� �Ƿ� ��ܽ ���� ��Ī�� �¼��� ��� ������ ���� ������
       ���߹� ΤС�� ���� ÷���� ���� ����ɺ ���պ��� �Ƿ� ���� ��� ��� Ľ�ݸ�
       ���� ��� ���� ���� ������ ������ ���� ������ ���� ���� ���ַ��� ����
       ������ ����� ���� ��ܽ ΤС�� ��ҩʦ ���� ΤС�� ���ַ��� ���� ����� ����
       ���߹� Ԭ���� ˫�� ���� ���� лѷ ���� ���� ÷���� ���޼� ���� ������
       ���պ��� ˫�� ��ң�� лѷ ���պ��� ������ ���ַ��� ������ ˫�� ���� ����
       ���� ˫�� ��Ī�� ���� ������ ���ַ��� ���޼� ���� ������ ���� �����
       лѷ ÷���� ������ ���� Ԭ���� ������ ������ ���� лѷ ��� ���� ����
       ˫�� ���ʦ̫ ���� ���޼� �¼��� ���� ���� ��ҩʦ ��ң�� ������ ����
       ��ң�� ���պ��� ���ַ��� ˫�� ���� ���߹� ��ܽ ���� ����'''
from collections import Counter
words = s.split()
c = Counter(words)
print(c.most_common(1)[0][0])