import java.util.Arrays;
import java.util.Vector;

public class MinStepsKnight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    int N = 30;  
	    int knightPos[] = {1, 1};  
	    int targetPos[] = {30, 30}; 
	        System.out.println(minStepsToReachTarget(knightPos, targetPos, N)); 

	}
	static class Cell{
		int x,y,distance;
		public Cell(int x , int y , int dis) {
			this.x=x;
			this.y=y;
			this.distance=dis;
		}
	}
	
	static boolean isInside(int x , int y ,int N) {
		if(x>=1 &&  x<=N && y>=1 && y<=N)
			return true;
		return false;
	}
	
	static int minStepsToReachTarget(int[] knightInitPos , int[] targetPos , int N) {
		
		// x and y direction, where a knight can move  
	    int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};  
	    int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1}; 
	    
	    //Queue for BFS of unweighted graph to get the shortest path
	    Vector<Cell> que= new Vector<>();
		
	    que.add(new Cell(knightInitPos[0],knightInitPos[1],0));
	    Cell t;
	    int x,y;
	    
	    boolean visited[][] = new boolean[N+1][N+1];
	    for(int i=0;i<visited.length;i++) {
	    	Arrays.fill(visited[i], false);
	    }
	    

	    // visit starting state 
	    visited[knightInitPos[0]][knightInitPos[1]] = true;
	    
	    while(!que.isEmpty()) {
	    	t = que.firstElement();
	    	que.remove(0);
	    	if(t.x==targetPos[0] && t.y == targetPos[1]) {
	    		return t.distance;
	    	}
	    	
	    	// loop for all reachable states  
	        for (int i = 0; i < 8; i++)  
	        {  
	            x = t.x + dx[i];  
	            y = t.y + dy[i];  
	  
	            // If reachable state is not yet visited and  
	            // inside board, push that state into queue  
	            if (isInside(x, y, N) && !visited[x][y]) 
	            {  
	            	visited[x][y] = true;  
	                que.add(new Cell(x, y, t.distance + 1));  
	            }  
	        }  
	        
	    }
		
	    return Integer.MAX_VALUE; 
	}

}
