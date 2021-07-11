public class GoogleTest {

	class Travel {
		Node startNode;
		int nodeCount=0;
		Node treeMapping() {
			Node H = new Node(null,null,"H");
			Node F = new Node(null,null,"F");
			Node S = new Node(null,null,"S");
			Node U = new Node(null,null,"U");
			Node Z = new Node(null,null,"Z");
			Node K = new Node(null,null,"K");

			H.left = F;
			H.right = S;
			F.left = U;
			S.left = Z;
			S.right = K;
			
			return H;
		}
		
		void setStartNode(Node start) {
			this.startNode = start;
		}
		
		void A_Course(Node node) {
			
			if(node!=null) {
				A_Course(node.left);
				if(nodeCount == 5) {
					System.out.print(node.name);
				}
				if(nodeCount<5) {
					System.out.print(node.name + "->");nodeCount++;
				}
				A_Course(node.right);
			}
		}
		class Node{
			Node left;
			Node right;
			String name;
			
			Node(Node l,Node r,String name){
				this.left = l;
				this.right = r;
				this.name = name;
			}
		}
	}
	
	
	public static void main(String[] args) {
		GoogleTest winner = new GoogleTest();
		Travel travel = winner.new Travel();
		travel.setStartNode(travel.treeMapping());
		travel.A_Course(travel.startNode);
	}

}
