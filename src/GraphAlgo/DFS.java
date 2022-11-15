/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphAlgo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class DFS {
    public static boolean searchpath(int[][] maze, int x,int y,List<Integer> path){
        if(maze[x][y]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        
        if(maze[x][y]==0){
            maze[x][y]=2;
            
            int[] dRow={1,0,-1,0};
            int[] dCol={0,1,0,-1};
            
            for(int d=0; d<dRow.length; d++){
                int newRow=x+dRow[d];
                int newCol=y+dCol[d];
                
                 if(newRow>=0 && newRow<maze.length && newCol>=0 && newCol<maze[0].length && searchpath(maze,newRow,newCol,path)){
                     path.add(x);
                     path.add(y);
                     return true;
                 }
            }  
        }
        return false;
    }
    public static void main(String[] args){
        
        DFS obj = new DFS();
        int[][] maze = {
            {0,0,1},
            {0,1,9},
            {0,0,0},
        };
        List<Integer> path = new ArrayList<Integer>();
        boolean reach = obj.searchpath(maze, 0, 0, path);
        System.out.println(reach);
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
    }
}
