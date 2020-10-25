package com.linkedlist;

public class JosephCircleTest {
	public static void main(String[] args) {
		// ����һ�ѿ����������������ͱ����Ƿ�ok
		JosephCircle circleSingleLinkedList = new JosephCircle();
		circleSingleLinkedList.addNode(25);// ����5���ڵ�
		circleSingleLinkedList.showCircle();
		//����һ�ѽڵ��Ȧ�Ƿ���ȷ
		circleSingleLinkedList.count(1, 5, 25);
	}
}


//Լɪ��
class JosephCircle{
	//Լɪ���׽ڵ�
	private Joseph first = null;
	
	//������ֵ����˳��ڵ㣬�������Լɪ��
	public void addNode(int  number) {
		//���ݲ�����Ҫ���޷����
		if (number < 1) {
			System.out.println("number��ֵ����ȷ");
			return;
		}
		//��ʼ�� ��ǰ�ڵ�
		Joseph curNode = null;
		for(int index = 1;index < number ;index ++) {
			Joseph newNode  = new Joseph(index);
			if(index == 1) {
				//��һ��ʵ��ڵ�,���ҹ�����
				first = newNode;
				first.setNext(first);
				curNode = first;
			}else {
				curNode.setNext(newNode);
				newNode.setNext(first);
				curNode = newNode;
			}
		}
		
	}
	
	//��ʾԼɪ����Ϣ
	public void showCircle() {
		if(first == null) {	//�ջ�
			System.out.println("Լɪ��Ϊ�գ�");
			return;
		}
		//�����鿴Լɪ������
		Joseph curNode  = first;
		while (true) {
			System.out.printf("�ڵ�ı�� %d \n", curNode.getNo());
			if (curNode.getNext() == first) {// ˵���Ѿ��������
				break;
			}
			curNode = curNode.getNext(); // curNode����
		}
	}
	
	/*
	 * @param startNo ��ʼλ��
	 * @param countNo �������
	 * @param startNo Լɪ�򻷽ڵ����
	 */
	public void count(int startNo,int countNo,int nums) {
		// �ȶ����ݽ���У��
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("������������ ����������");
			return;
		}
		
		// ����Ҫ������ָ��,�����ڵ��Ȧ
		Joseph helper = first;
		// ���󴴽�һ������ָ��(����) helper , ����Ӧ��ָ����������������ڵ�
		while (true) {
			if (helper.getNext() == first) { // ˵��helperָ�����С���ڵ�
				break;
			}
			helper = helper.getNext();
		}
		
		
		//�ڵ�countǰ������ first ��  helper �ƶ� k - 1��
		for(int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		
		//��С������ʱ����first �� helper ָ��ͬʱ ���ƶ�  m  - 1 ��, Ȼ���Ȧ
		//������һ��ѭ��������֪��Ȧ��ֻ��һ���ڵ�
		while(true) {
			if(helper == first) { //˵��Ȧ��ֻ��һ���ڵ�
				break;
			}
			//�� first �� helper ָ��ͬʱ ���ƶ� countNum - 1
			for(int j = 0; j < countNo - 1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			//��ʱfirstָ��Ľڵ㣬����Ҫ��Ȧ��С���ڵ�
			System.out.printf("�ڵ�%d��Ȧ\n", first.getNo());
			//��ʱ��firstָ���С���ڵ��Ȧ
			first = first.getNext();
			helper.setNext(first); //
		}
		System.out.printf("�������Ȧ�еĽڵ���%d \n", first.getNo());
	}
}

//Լɪ�� �ڵ�
class Joseph{
	public int number;
	
	public Joseph next;
	
	public Joseph(int number) {
		this.number = number;
	}
	
	public int getNo() {
		return this.number;
	}
	
	public void setNo(int number) {
		this.number = number;
	}
	
	public Joseph getNext() {
		return this.next;
	}
	
	public void setNext(Joseph next) {
		this.next = next;
	}
}