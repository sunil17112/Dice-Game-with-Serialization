import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public final class Game { // class Immutable
	
	private final int numsnake;
	private final int numvulture;
	private final int numwhite;
	private final int numcricket;
	private final int numtrampolin;
	private final Tile[] arr; 
	private  final ArrayList<String>s;
	
	public Game(int n,String name)throws NoExtraTiles,GameWinnerException ,OutOfMemoryError,IOException,ClassNotFoundException{
		// TODO Auto-generated constructor stub
		
		Random rand=new Random();
		
		this.arr=new Tile[n];
		this.s=new ArrayList<String>();
		this.numwhite=n/4+1;
		this.numsnake=rand.nextInt(2*(n-this.numwhite)/3+1);
		this.numvulture=rand.nextInt(2*(n-this.numwhite-this.numsnake)/3+1);
		this.numcricket=rand.nextInt(n-this.numwhite-this.numvulture-this.numsnake+1);
		this.numtrampolin=n-this.numcricket-this.numsnake-this.numvulture-this.numwhite;
		Random_Generator(n);
		System.out.println("start the game with " + name + " at Tile =1");
		System.out.println("Control transferred to Computer for rolling the Dice from " + name);
		Scanner sc=new Scanner(System.in);
		boolean Done=false;
		int s=0;
		while(!Done) {
			try {
				System.out.println("Enter 1 For Start the Game ");
				
				s=sc.nextInt(); // use exception handling
				if(s==1) {
					
					Done=true;
					
				}
				else {
					System.out.println("Invaid Integer");
					System.out.println("Try Again");
					sc.nextLine();
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Invaid Integer");
				System.out.println("Try Again");
				sc.nextLine();
			}
		}
		new Player(n, name,arr);
		
	
	}
	public int get_check(String str) throws IOException, ClassNotFoundException ,NoExtraTiles,GameWinnerException,NullPointerException{
		ObjectInputStream in = null;
		Player p1;
		try {
			in = new ObjectInputStream (
			new FileInputStream("C:\\Users\\SUNIL KUMAR\\eclipse-workspace\\practice\\src\\practice\\"+str+".txt"));
			p1 = (Player) in.readObject();
			return p1.getTile();
			
		}
		finally {
			in.close();
			
		}
	}
	
	public static void deserialize(String str)throws IOException, ClassNotFoundException ,NoExtraTiles,GameWinnerException,NullPointerException{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream (
			new FileInputStream("C:\\Users\\SUNIL KUMAR\\eclipse-workspace\\practice\\src\\practice\\"+str+".txt"));
			Player p1 = (Player) in.readObject();
			
			System.out.println("Player name :" + p1.getName());
			System.out.println("Current tile :" + (p1.getTile()+10));
			p1.play();
			
		}
		
		finally {
			in.close();
		}
		
	}
	private void Random_Generator(int n) throws NoExtraTiles,GameWinnerException,OutOfMemoryError{
		
		
		for(int i=0;i<=this.numwhite;i++) {
			s.add("W");
		} 
		for(int i=0;i<=this.numsnake;i++) {
			s.add("S");
		}
		for(int i=0;i<=this.numcricket;i++) {
			s.add("C");
		}
		for(int i=0;i<=this.numvulture;i++) {
			s.add("V");
		}
		for(int i=0;i<=this.numtrampolin;i++) {
			s.add("T");
		}
		Collections.shuffle(s);
		
		for(int i=0;i<n;i++) {
			if(s.get(i).equals("W")) {
				arr[i]=new White(i+1,n);
			}
			else if(s.get(i).equals("S")) {
				arr[i]=new Snake(i+1,n);
			}
			else if(s.get(i).equals("V")) {
				arr[i]=new Vulture(i+1,n);
			}
			else if(s.get(i).equals("C")) {
				arr[i]=new Cricket(i+1,n);
			}
			else {
				arr[i]=new Trampoline(i+1,n);
			}
		}
		
		
		
		
	}
		
	public static void main(String[] args) throws NoExtraTiles,GameWinnerException,OutOfMemoryError,IOException,ClassNotFoundException{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		boolean Done=false;
		
		int n=0;
	
		while(!Done) {
			try {
				System.out.print("Enter the total number of tiles : ");
				n=sc.nextInt(); // use exception handling
				System.out.println("");
				Done=true;
			}
			catch(InputMismatchException e) {
				System.out.println("Invaid Integer");
				System.out.println("Try Again");
				sc.nextLine();
			}
		}
		if(n<=0) {
			System.out.println("End the Game");
		}
		else {
			System.out.print("Enter the player name : ");
			String name=sc.next();// exception handling
			System.out.println("");
			boolean sr=true;
			while(sr) {
				try {
					System.out.println("do you want to resume your game or start the new game");
					System.out.println("1 for resume the game");
					System.out.println("2 for new game");
					int a=sc.nextInt();
					sr=false;
					if(a==1) {
						try{
							deserialize(name);
						}
						catch(Exception e) {
							System.out.println("No game is saved for this player");
						}
						
					}
					else if(a==2) {
						new Game(n,name);
					}
					else {
						throw new InputMismatchException();
					}
					
					
				}
				catch(InputMismatchException e) {
					System.out.println("select the valid integer");
					sc.nextLine();
				}
				catch(OutOfMemoryError e) {
					System.out.println("Out Of Memory");
					System.out.println("end the Game");
				}
			}
			
			System.out.println("End the game");
		}
		
		
		

	}

}
