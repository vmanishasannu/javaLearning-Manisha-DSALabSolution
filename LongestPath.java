package com.greatLearning;

import java.util.ArrayList;

public class LongestPath {
	static class Node{
		Node left;
		Node right;
		int data;
	};

	static Node createNode(int data){
		Node tempNode = new Node();

		tempNode.data = data;
		tempNode.left = null;
		tempNode.right = null;

		return tempNode;
	}

	public static ArrayList<Integer> getLongPath(Node root){
		if(root == null){
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}
		
		ArrayList<Integer> right = getLongPath(root.right);		
		ArrayList<Integer> left = getLongPath(root.left);
		
		if(right.size() < left.size()){
			left.add(root.data);
		}
		else{
			right.add(root.data);
		}
		return (left.size() > right.size() ? left :right);
	}
	public static void main(String[] args) {

		Node root = createNode(100);
		root.left = createNode(20);
		root.right = createNode(130);
		root.left.left = createNode(10);
		root.left.right = createNode(50);
		root.right.left=createNode(110);
		root.right.right=createNode(140);
		root.left.left.left = createNode(5);
		
		ArrayList<Integer> output = getLongPath(root);
		int n = output.size();
		
		System.out.print("Longest path "+output.get(n - 1));
		for(int i = n - 2; i >= 0; i--){
			System.out.print(" -> " + output.get(i));
		}
	}

}

