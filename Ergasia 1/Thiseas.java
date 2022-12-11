import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Thiseas{
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("data.txt")); 
        
        // pairnei ta n kai m apo th 1h grammh
        String line = br.readLine();
        String[] splitted = line.split("\\s+");
        int m = Integer.parseInt(splitted[0]);
        int n = Integer.parseInt(splitted[1]);
        
        // pairnei tis suntetagmenes ths eisodou apo th 2h grammh
        line = br.readLine(); 
        String[] splitted1 = line.split("\\s+");
        int x = Integer.parseInt(splitted1[0]);
        int y = Integer.parseInt(splitted1[1]);

        char[][] details = new char[m][n]; 
        StringStack<Point> s = new StringStackImpl<Point>();

        // eisagei sto pinaka ta stoixeia tou text
        line = br.readLine();
        int count = 0;
        for(int i = 0; i < m; i++) 
        {
            String[] splitted3 = line.split("\\s+");
            
            for(int j = 0; j < n; j++)
            {
                details[i][j] = splitted3[j].charAt(0);
                if(details[i][j] == 'E') {count++;}
            }

            // elegxos gia tis sthles an isoutai me n
            if(splitted3.length != n)
            {
                System.out.println("Wrong Input");
                System.exit(0);
            }
            line = br.readLine();
        }
        
        //elegxos ths eisodou 
        if(count != 1) 
        {
            System.out.println("Wrong Input");
            System.exit(0); 
        }

        Point entrance = new Point(x, y, 'E');
        s.push(entrance);
        
        // pinakas visites elegxei an exoume elegksei to tile ksana
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                visited[i][j] = false;
            }
        }

        Point temp;
        while(!s.isEmpty())
        {
            temp = s.pop();
            visited[temp.getX()][temp.getY()] = true;
            
            //elegxos eksodou
            if(temp.getX() != x && temp.getY() != y && (temp.getX()==0 || temp.getX()==m-1 || temp.getY()==0 || temp.getY()==n-1))
            {
                System.out.println("Found the exit");
                System.out.println(temp.toString());
                System.exit(0);
            }

            //elegxos geitonwn
            if(temp.getX() >= 0 && temp.getX() < m && temp.getY()-1 >= 0 && temp.getY()-1 < n && !visited[temp.getX()][temp.getY()-1])
            {
                if(details[temp.getX()][temp.getY()-1] == '0')
                {
                    s.push(new Point(temp.getX(), temp.getY()-1, details[temp.getX()][temp.getY()-1]));
                }else {visited[temp.getX()][temp.getY()-1] = true;}
            }   
            if(temp.getX() >= 0 && temp.getX() < m && temp.getY()+1 >= 0 && temp.getY()+1 < n && !visited[temp.getX()][temp.getY()+1])
            {
                if(details[temp.getX()][temp.getY()+1] == '0')
                {
                    s.push(new Point(temp.getX(), temp.getY()+1, details[temp.getX()][temp.getY()+1]));
                }else {visited[temp.getX()][temp.getY()+1] = true;}
            }
            if(temp.getX()-1 >= 0 && temp.getX()-1 < m && temp.getY() >= 0 && temp.getY() < n && !visited[temp.getX()-1][temp.getY()])
            {
                if(details[temp.getX()-1][temp.getY()] == '0')
                {
                    s.push(new Point(temp.getX()-1, temp.getY(), details[temp.getX()-1][temp.getY()]));
                }else {visited[temp.getX()-1][temp.getY()] = true;}
            }
            if(temp.getX()+1 >= 0 && temp.getX()+1 < m && temp.getY() >= 0 && temp.getY() < n && !visited[temp.getX()+1][temp.getY()])
            {
                if(details[temp.getX()+1][temp.getY()] == '0')
                {
                    s.push(new Point(temp.getX()+1, temp.getY(), details[temp.getX()+1][temp.getY()]));
                }else {visited[temp.getX()+1][temp.getY()] = true;}
            }
            //elegxos an h stoiva einai adeia
            if(s.isEmpty()) {System.out.println("Exit not found");}
        }
    }
}
