package com.linkedlist;

public class DoubleLinkedListTest {
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		
		list.addNode(new LinkedListNode(1,"String1"));
		list.addNode(new LinkedListNode(2,"String2"));
		list.addNode(new LinkedListNode(3,"String3"));
		list.addNode(new LinkedListNode(4,"String4"));
		list.addNode(new LinkedListNode(5,"String5"));
		
		list .deleteNode(3);
		list.updateNode(new LinkedListNode(5,"UpdateString1"));
		list.listNode();
	}
}


class DoubleLinkedList {
	//��������,ֻ��Ҫһ��������ͷ�ڵ㼴��,
	private LinkedListNode head = new LinkedListNode(0,"");
	
	//��ѯͷ�ڵ�
	public LinkedListNode getHead() {
		return this.head;
	}
	
	//�����ڵ�
	public void addNode(LinkedListNode newNode) {
		LinkedListNode curNode = head;
		//��ͷ�ڵ�һֱ����ѯ���ɲ���λ��
		while(true) {
			if(curNode.next != null) {
				curNode = curNode.next;
			}else {
				curNode.next = newNode;
				newNode.pre = curNode;
				System.out.println("����˽ڵ�"+curNode+'!');
				break;
			}
		}
		System.out.println("��ӽڵ����̽�����");
	}
	
	//չʾ���нڵ�
	public void listNode() {
		LinkedListNode curNode = head;
		if(curNode.next == null) {
			System.out.println("��ǰ��������Ϊ�գ�");
		}
		//�ҵ���һ�����ݽڵ�
		curNode = curNode.next;
		while(true) {
			if(curNode.next != null) {
				System.out.println(curNode);
				curNode = curNode.next;
			}else {
				System.out.println(curNode);
				break;
			}
		}
	}
	
	//���ݽڵ�numberֵɾ���ڵ�
	public void deleteNode(int number) {
		LinkedListNode curNode = head;
		boolean checkedNode = false;
		//��������ڵ�
		while(true) {
			if(curNode.next != null) {
				System.out.println(curNode);
				if(curNode.next.number == number) {
					checkedNode = true;
					break;
				}
				curNode = curNode.next;
			}else {
				break;
			}
		}
		if(checkedNode) {
			//�д�ɾ���ڵ�
			curNode.next = curNode.next.next;
			System.out.println("��ɾ���Ľڵ��Ѿ�ɾ����");
		}else {
			System.out.println("��ǰ����û�д�ɾ���Ľڵ㣡");
		}
	}
	
	
	//���ݽڵ�����ֵ
	public void updateNode(LinkedListNode newNode) {
		LinkedListNode curNode = head;
		boolean checkedNode = false;
		//��������ڵ�
		while(true) {
			if(curNode.next != null) {
				System.out.println(curNode);
				if(curNode.next.number == newNode.number) {
					checkedNode = true;
					break;
				}
				curNode = curNode.next;
			}else {
				break;
			}
		}
		if(checkedNode) {
			//�д�ɾ���ڵ�
			curNode.next.number = newNode.number;
			curNode.next.name = newNode.name;
			System.out.println("�ڵ���Ϣ�Ѿ��޸�");
		}else {
			System.out.println("û�п����޸ĵĽڵ�!");
		}
	}
	
}


class LinkedListNode{
	//�ڵ�ֵ
	public int number;
	public String name;

	//ָ����һ���ڵ�
	public LinkedListNode next;
	public LinkedListNode pre;
	
	public LinkedListNode(int number,String name) {
		this.number = number;
		this.name = name;
	}

	@Override
	public String toString() {
		return "DoubleLinkedListNode [number=" + number + ", name=" + name + "]";
	}
}
