/**
 * Given a reference of a node in a connected undirected graph. Return a deep copy 
 * (clone) of the graph. Each node in the graph contains a value (int) and a list 
 * (List[Node]) of its neighbors.
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 * Test case format:
 * For simplicity, each node's value is the same as the node's index (1-indexed). 
 * For example, the first node with val == 1, the second node with val == 2, and 
 * so on. The graph is represented in the test case using an adjacency list. An 
 * adjacency list is a collection of unordered lists used to represent a finite 
 * graph. Each list describes the set of neighbors of a node in the graph.
 * The given node will always be the first node with val = 1. You must return the 
 * copy of the given node as a reference to the cloned graph.
 * 
 * Example 1:
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 
 * Constraints:
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 */

package queueStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
	
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int val) {
	        this.val = val;
	        this.neighbors = new ArrayList<Node>();
	    }
	    public Node(int val, ArrayList<Node> neighbors) {
	        this.val = val;
	        this.neighbors = neighbors;
	    }
	}

	public static void main(String[] args) {
		int[][] arr = {{2,4},{1,3},{2,4},{1,3}};
		CloneGraph c = new CloneGraph();
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		Node node = null;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(i + 1)) {
				node = map.get(i + 1);
			} else {
				node = c.new Node(i + 1);
				map.put(i + 1, node);
			}
			Node neighbor = null;
			for (int j = 0; j < arr[i].length; j++) {
				if (map.containsKey(arr[i][j])) {
					neighbor = map.get(arr[i][j]);
				} else {
					neighbor = c.new Node(arr[i][j]);
					map.put(arr[i][j], neighbor);
				}
				node.neighbors.add(neighbor);
			}
		}
		int len = arr.length;
		Node newNode = c.cloneGraph(node);
		map = new HashMap<Integer, Node>();
		c.putMap(len, node, map);
		c.printNeighbors(len, map);
		map = new HashMap<Integer, Node>();
		c.putMap(len, newNode, map);
		c.printNeighbors(len, map);
	}
	
	private void printNeighbors(int len, HashMap<Integer, Node> map) {
		for (int i = 0; i < len; i++) {
			Node n = map.get(i + 1);
			System.out.print("{ ");
			for (Node neighbor : n.neighbors) {
				System.out.print(neighbor.val + " ");
			}
			System.out.print("} ");
		}
		System.out.println();
	}
	
	private void putMap(int val, Node node, HashMap<Integer, Node> map) {
		map.put(val, node);
		for (Node neighbor : node.neighbors) {
			if (!map.containsKey(neighbor.val)) {
				putMap(neighbor.val, neighbor, map);
			}
		}
	}

	public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        return clone(node, map);
    }
	
	/**
	 * 使用一个HashMap来保存访问过的节点，键为原来的节点，值为复制的节点，每当遇到一个没有访问
	 * 过的节点，先复制原来的节点并加入到HashMap，然后递归遍历原来节点的邻节点
	 * @param node
	 * @param map
	 * @return
	 */
	private Node clone(Node node, HashMap<Node, Node> map) {
		if (node == null) {
			return null;
		}
		if (map.containsKey(node)) {
			return map.get(node);
		}
		Node newNode = new Node(node.val);
		map.put(node, newNode);
		for (Node neighbor : node.neighbors) {
			newNode.neighbors.add(clone(neighbor, map));
		}
		return newNode;
	}
	
}
