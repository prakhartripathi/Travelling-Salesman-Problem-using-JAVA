import java.util.Scanner;
class tsp{
	int visited[] = new int[10];
	static int a[][] = new int[10][10];
	int n;
	static int size;
	int cost, trav;
	public void visited(){
		int i;
		for(i=0;i<size;i++)
			this.visited[i] = 0;
		this.trav =1;
	}
	public int least(int c){
		int i,nc = 999;
		int min = 999, kmin=0;
		for(i=0;i<size;i++){
			if((a[c][i]!=0)&&(this.visited[i]==0)){
				if(a[c][i] < min){
					min = a[i][0] + a[c][i];
					kmin = a[c][i];
					nc = i;
				}
			}
		}
		if(min!=999){
			this.cost += kmin;
			trav++;
		}
		return nc;
	}
	public void mincost(int city){
		int i,ncity;
		visited[city] = 1;
		System.out.print(" "+(city+1));
		ncity = least(city);
		if(ncity==999){
			return;
		}
		this.mincost(ncity);
	}
	public void put(){
		System.out.print("\nminimum cost ="+this.cost+" traversed till "+this.trav);

	}
	public static void main(String args[]){
		int i,j;
		System.out.println("Enter the number of vertices = ");
		Scanner input = new Scanner(System.in);
		size = input.nextInt();
		System.out.println("Enter the cost matrix");
		for(i=0;i<size;i++){
			for(j=0;j<size;j++){
				a[i][j] = input.nextInt();
			}
		}
		System.out.println("matrix is");
		for(i=0;i<size;i++){
			for(j=0;j<size;j++){
				System.out.print(" "+a[i][j]);
			}
			System.out.println();
		}
		tsp[] ob = new tsp[size];
		for(int z = 0;z<size;z++){
			ob[z] = new tsp();
			ob[z].visited();
			ob[z].cost=0;
			System.out.println();
			ob[z].mincost(z);
			System.out.println();
			ob[z].put();
		}
		int minimum = 999;
		int z;
		for(z=0;z<size;z++){
			if(ob[z].cost<minimum&&ob[z].trav==size){
				minimum = ob[z].cost;
			}
		}
		System.out.print("\n minimum cost for traveral ="+minimum);
	}
}