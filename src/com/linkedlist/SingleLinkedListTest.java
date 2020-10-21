package com.linkedlist;

public class SingleLinkedListTest {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		
		list.addNode(new Node(1,"String1"));
		list.addNode(new Node(2,"String2"));
		list.addNode(new Node(3,"String3"));
		list.addNode(new Node(4,"String4"));
		list.addNode(new Node(5,"String5"));
		
		list .deleteNode(3);
		list.updateNode(new Node(5,"UpdateString1"));
		list.listNode();
	}
}

class SingleLinkedList {
	//��������,ֻ��Ҫһ��������ͷ�ڵ㼴��,
	private Node head = new Node(0,"");
	
	//��ѯͷ�ڵ�
	public Node getHead() {
		return this.head;
	}
	
	//�����ڵ�
	public void addNode(Node newNode) {
		Node curNode = head;
		//��ͷ�ڵ�һֱ����ѯ���ɲ���λ��
		while(true) {
			if(curNode.next != null) {
				curNode = curNode.next;
			}else {
				curNode.next = newNode;
				System.out.println("����˽ڵ�"+newNode+'!');
				break;
			}
		}
		System.out.println("��ӽڵ����̽�����");
	}
	
	//չʾ���нڵ�
	public void listNode() {
		Node curNode = head;
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
		Node curNode = head;
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
	public void updateNode(Node newNode) {
		Node curNode = head;
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

class Node{
	//�ڵ�ֵ
	public int number;
	public String name;

	//ָ����һ���ڵ�
	public Node next;
	
	public Node(int number,String name) {
		this.number = number;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [number=" + number + ", name=" + name + "]";
	}
}
