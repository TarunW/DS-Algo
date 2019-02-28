package com.app.ds;

public class Node<T> {
		public T data;
		public Node nextNode;

		public Node(T data) {
			this.data = data;
			nextNode = null;
		}
	}
