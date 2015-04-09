/**
 * 
 * This class represents a special kind of a doubly-linked list of 
 * Strings, called a SkipiList. A SkipiList is composed of Nodes 
 * (a nested class of SkipiList). In addition to the data (String), 
 * each Node has one pointer to the next Node in the list, and another 
 * pointer to the prev-prev Node in the list (hence the name ''skipi''). 
 * The only data members the class contains are the head and the tail of the list.
 * 
 * 
 * @author mishelle
 *
 */



public class SkipiList {

	public static class Node {
		/**
		 * The Node data.
		 */ 
		private final String data;
		/**
		 * Link to the next Node.
		 */ 
		private Node next;
		/**
		 * skipBack (prev-prev) Node in the list
		 */
		private Node skipBack;

		/**
		 * Constructor for Node.
		 * 
		 * @param data - The data the Node holds
		 * @param next - The next Node in the list
		 * @param skipBack - the skipBack (prev-prev) Node in the list
		 * @throws NullPointerException if data is null
		 */
		public Node(java.lang.String data, 
				Node next, Node skipBack){
			this.data = data;
			this.next = next;
			this.skipBack = skipBack;	
		}


		/**
		 * Returns the Node this Node is pointing to.
		 * @return The Node this node is pointing to
		 */
		public Node getNext(){
			return next;
		}
		/**
		 * Returns the data of this Node.
		 * @return The data 
		 */
		public String getData(){
			return data;
		}
		/**
		 * Sets the Node that will follow this Node to the one given in the parameter.
		 * @param next the Node that will now follow this Node
		 */
		public void setNext(Node next){
			this.next = next;
		}

		/**
		 * Returns the prev-prev (skipBack) Node.
		 * @return the prev-prev (skipBack) Node.
		 */
		public Node getSkipBack(){
			return skipBack;
		}

		/**
		 * Sets the Node that will be the prev-prev (skipBack) Node of this Node.
		 * 
		 * @param s - the prev-prev (skipBack) Node
		 */
		public void setSkipBack(Node s){
			this.skipBack = s;
		}
	}



	/**
	 * Link to the head Node.
	 */ 
	Node head;

	/**
	 * Link to the tail.
	 */
	Node tail;


	/**
	 * Default constructor. Constructs an empty list.
	 */
	public SkipiList(){
		head = tail = null;
	}

	/**
	 * Adds an item to the beginning of a list.
	 * 
	 * @param data - the item to add
	 * @throws java.lang.NullPointerException - if data is null
	 */
	public void addFirst(java.lang.String data){
		if(data==null){ 
			throw new NullPointerException("data");
		}
		Node temp = new Node(data, head, null);
		if(head==null){
			head = tail = temp;
		}
		else{
			if(head.getNext() == null){
				head = temp;
			}
			else{
				head.next.setSkipBack(temp);
				head = temp;
			}
		}

	}

	/**
	 * Adds an item to the end of a list.
	 * 
	 * @param data
	 * @throws java.lang.NullPointerException - if data is null
	 */
	public void addLast(java.lang.String data){
		if(data==null){ 
			throw new NullPointerException("data");
		}
		Node tempTail = new Node(data, null, null);
		if(head == null){
			head = tail =  tempTail;
		}
		else{
			if(head.getNext()==null){
				tail = tempTail;
				head.next = tail;
			}
			else{
				if(tail.skipBack == null){
					tempTail.setSkipBack(head);
					tail.next = tempTail;
					tail = tempTail;
				}
				else{
					Node temp2 = new Node(data,null, tail.getSkipBack().getNext());
					tail.next = temp2;
					tail = temp2;
				}

			}
		}
	}

	/**
 /**
	 * Returns a string representation of the list. The representation has the list
	 * elements between "[]", separated by commas. For example, if the list contains the
	 * elements "Dan", "Ran", "Ann", and "Zan", the String representation would be "[Dan,Ran,Ann,Zan]".
	 * 
	 * @return A string representation of the list
	 */
	public String toString(){
		StringBuilder ans = new StringBuilder("[");
		Node tmp = head;
		while (tmp != null){
			ans.append(tmp.data);
			tmp = tmp.next;
			if (tmp != null)
				ans.append(",");
		}
		ans.append("]");
		return ans.toString();
	}

	/**
	 * Returns a string representation of the list, from the end to the beginning. 
	 * The representation should be the list element between "[]", separated by commas, 
	 * in a reversed order. For example, if the list contains the elements "Dan", "Ran", 
	 * "Ann", and "Zan", the String representation would be "[Zan,Ann,Ran,Dan]". 
	 * You are not allowed to use the toString() method in implementing this method
	 * 
	 * @return
	 */
	public java.lang.String backString(){
		StringBuilder ans = new StringBuilder("[");
		Node tmp = tail;
		while (tmp != null){
			ans.append(tmp.data);
			if(tmp.getSkipBack()==null){
				if(tmp == head.next){
					tmp = head;
				}
				else{
					tmp=null ;
				}
			}
			else{
				tmp = tmp.getSkipBack().getNext();
			}
			if (tmp != null)
				ans.append(",");
		}
		ans.append("]");
		return ans.toString();
	}

	/**
	 * Removes the first Node from the list and return its data.
	 * 
	 * @return The data of the removed node
	 */
	public java.lang.String removeFirst(){
		if(head == null){
			return null;
		}
		else{
			String data = head.getData();
			if(head.getNext() == null){
				head = tail = null;
			}
			else{
				if(head.getNext().getNext()==null){
					head = head.getNext();
				}
				else {
					head = head.getNext();
					head.getNext().setSkipBack(null);
				}

			}

			return data;
		}

	}

	/**
	 * Removes the last Node from the list and return its data.
	 * 
	 * @return The data of the removed node
	 */
	public java.lang.String removeLast(){
		if(head == null){
			return null;
		}
		else {
			String data = tail.getData();
			if(head.getNext() == null){
				head = tail = null;
			}
			else{
				if(head.getNext().getNext()==null){
					head.setNext(null);
					tail = head;
				}
				else{
					if(head.getNext().getNext().getNext()== null){
						head.getNext().setNext(null);
						tail = head.getNext();
					}
					else{
						tail = tail.getSkipBack().next;
						tail.setNext(null);
					}
				}
			}
			return data;
		}
	}

	/**
	 * Removes a given Node from the list, and returns its data. Assumes the 
	 * given node is in the list. Runs in O(1).
	 * 
	 * @param n - the Node to be removed
	 * @return the removed Node's data
	 */
	public String removeElement(Node n){ 

		if(n == tail){
			return removeLast();
		}
		if (n==head){
			return removeFirst();
		}
		String nodeData = n.data;

		if (n.next.next==null){
			n.next.skipBack.setNext(n.next);
			n.next.setSkipBack(n.skipBack);
		}
		else{
			n.next.next.skipBack=n.next.skipBack;
			n.next.skipBack.setNext(n.next);
			n.next.setSkipBack(n.skipBack);
		}
		return nodeData;

	}

	/**
	 * Removes from the list the fist Node whose data equals the given parameter.
	 * 
	 * @return true iff the data was found and removed
	 */
	public boolean removeElement(java.lang.String data){
		SkipiList.Node node = head;

		while (node!=null){
			if (node.getData().equals(data)){
				removeElement(node);
				return true;
			}
			node=node.next;

		}
		return false;
	}
}

