
/**
 * 
 * This class contains static methods that operate on single-linked lists.
 *
 * @author mishelle
 */



public class ListUtil extends List {



	/**
	 * Merges two sorted (in ascending order) lists into one new sorted list in an 
	 * ascending order. The resulting new list is created using new nodes (copies of 
	 * the nodes of the given lists). Assumes both lists are sorted in ascending order. 
	 * The original lists should not be modified.
	 * 
	 *  @param first - the first list to merge
	 *  @param second - the second list to merge
	 *  @return the merged list
	 *  
	 */
	public static List mergeLists(List first, List second) {
		List mergeList = new List();
		if(first==null){
			throw new NullPointerException("first"); 
		}
		if(second==null){
			throw new NullPointerException("second"); 

		}
		List.Node node1 = first.head;
		List.Node node2 = second.head;

		// merges two lists with equals length.
		while(node1!=null && node2!=null){
			if(node1.getData().compareTo(node2.getData())<=0){
				mergeList.addFirst(node1.getData());
				node1 = node1.getNext(); 
			}
			else{

				mergeList.addFirst(node2.getData());
				node2 = node2.getNext();
			}
		}

		// merges two lists with different length 
		while(node1!=null){
			mergeList.addFirst(node1.getData());
			node1 = node1.getNext(); 
		}
		while(node2!=null){
			mergeList.addFirst(node2.getData());
			node2 = node2.getNext(); 
		}

		reverse(mergeList);

		return mergeList;
	}



	/**
	 * Reverses the given list (so the head becomes the last element, and every element 
	 * points to the element that was previously before it). Runs in O(n). No new object is created.
	 * 
	 * @param list - the list
	 */
	public static void reverse(List list){
		if(list==null){
			throw new NullPointerException("list"); 
		}
		List.Node temp = null;
		while(list.head!=null){
			List.Node saveValue = list.head.getNext();
			list.head.setNext(temp);
			temp = list.head;
			list.head = saveValue;
		}
		list.head = temp;
	}

	/**
	 * Checks if the given list contains a cycle. A list contains a cycle if at some point a Node in the 
	 * list points to a Node that already appeared in the list. Note that the cycle does not 
	 * necessarily contain all the nodes in the list. The original list should not be modified.
	 * 
	 * @param list - the list
	 * @return true if the list contains a cycle
	 */
	public static boolean containsCycle(List list){
		if(list==null){
			throw new NullPointerException("list"); 
		}
		List.Node turtle = list.head;
		List.Node rabbit = list.head;
		while(turtle!= null && rabbit!=null){
			turtle = turtle.getNext();
			if(rabbit.getNext()!=null){
				rabbit = rabbit.getNext().getNext();
			}
			else{
				return false;
			}
			if(turtle == rabbit){
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the given list is a palindrome. A list is a palindrome if 
	 * for j=1...n/2 (where n is the number of elements in the list) the element
	 * in location j equals to the element in location n-j. Note that you should 
	 * compare the data stored in the nodes and not the node objects themselves. 
	 * The original list should not be modified.
	 * 
	 * @param list - the list
	 * @return true if the list is a palindrome
	 */
	public static boolean isPalindrome(List list){
		if(list==null){
			throw new NullPointerException("list"); 
		}
		List oppositeList = new List(list);
		reverse(oppositeList);
		List.Node listNode = list.head;
		List.Node oppositeNode = oppositeList.head; 
		while(listNode!=null){
			if(!oppositeNode.getData().equals(listNode.getData())){
				return false;
			}
			oppositeNode = oppositeNode.getNext();
			listNode = listNode.getNext();
		}
		return true;

	}


	/**
	 * Checks if the two given lists intersect. Two lists intersect if at some point they start to share nodes. 
	 * Once two lists intersect they become one list from that point on and can no longer split apart. 
	 * Assumes that both lists does not contain cycles. Note that two lists might intersect even if 
	 * their lengths are not equal. No new object is created, and niether list is modified.
	 * 
	 * @param first - the first list
	 * @param second - The second list
	 * @return true iff the lists intersect
	 */
	public static boolean haveIntersection(List first, List second){
		if(first==null){
			throw new NullPointerException("first"); 
		}
		if(second==null){
			throw new NullPointerException("second"); 
		}
		List.Node node1 = first.head;
		List.Node node2 = second.head;

		if (node1==null || node2==null){
			return false;
		}

		while(node1.getNext()!=null){
			node1 = node1.getNext();
		}
		while(node2.getNext()!=null){
			node2 = node2.getNext(); 
		}
		if(node1==node2){
			return true;
		}
		return false;	
	}

	/*
	 * finds the middle of the list.
	 */
	private static List.Node getMiddle(List list){
		List.Node turtle = list.head;
		List.Node rabbit = list.head.getNext();
		while(rabbit!=null && rabbit.getNext()!= null){
		rabbit = rabbit.getNext().getNext();
		turtle = turtle.getNext();
		}
		return turtle;
		}

	
	/* Merges two sorted (in ascending order) lists into one new sorted list in an 
	 * ascending order by changing only the references.
	 */
	public static List mergeSortLists(List first, List second) {
		List merge = new List();
		List.Node saveValue = null; 

		while(first.head!=null && second.head!=null){
		
			if(first.head.getData().compareTo(second.head.getData())<=0){
				saveValue = first.head;
				first.head = first.head.getNext();
				saveValue.setNext(merge.head);
				merge.head = saveValue;
			}
			else{
				saveValue = second.head;
				second.head = second.head.getNext();
				saveValue.setNext(merge.head);
				merge.head = saveValue;
			}
		}
		while(second.head!=null){
			saveValue = second.head;
			second.head = second.head.getNext();
			saveValue.setNext(merge.head);
			merge.head = saveValue;
		}
		while(first.head!=null){
			saveValue = first.head;
			first.head = first.head.getNext();
			saveValue.setNext(merge.head);
			merge.head = saveValue;
		}
		
		reverse(merge);
		return merge;

	}

	/**
	 * Sorts the given list using the merge-sort algorithm. Resulting list 
	 * should be sorted in ascending order. Resulting list should contain the 
	 * same node objects it did originally, and should be stable, i.e., nodes 
	 * with equal data should be in the same order they were in in the original 
	 * list. You may create a constant number of new to help sorting.
	 * 
	 * @param list - the list
	 */
	public static void mergeSort(List list){
		if(list==null){
			throw new NullPointerException("list");
		}
		if(list.head==null){
			return;
		}
		if(list.head.getNext()==null){
			return ;
		}
		List part1 = new List();
		List part2 = new List();
		List.Node middle = getMiddle(list);
		
		part2.head = middle.getNext();
		middle.setNext(null);
		part1.head = list.head;
		
		
		mergeSort(part1);
		mergeSort(part2);
		list.head = mergeSortLists(part1, part2).head;

	}

}