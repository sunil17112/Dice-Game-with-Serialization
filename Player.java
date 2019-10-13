import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Set;
import org.junit.runner.JUnitCore;

import javax.crypto.spec.DESedeKeySpec;
class GameWinnerException extends Exception{
	public GameWinnerException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
class NoExtraTiles extends Exception{
	public NoExtraTiles(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
public class Player extends Dice implements Serializable {
	private int snakebite;
	private int vulturebite;
	private int cricketbite;
	private int trampoline;
	private int move;
	private int tile;
	private final String name;
	private final int max;
	private Tile[] arr;
	public Player(int n,String s,Tile[] arr) throws GameWinnerException ,NoExtraTiles,IOException,ClassNotFoundException{
		// TODO Auto-generated constructor stub
		super();
		this.snakebite=0;
		this.vulturebite=0;
		this.cricketbite=0;
		this.trampoline=0;
		this.max=n;
		this.move=0;
		this.tile=1;
		this.name=s;
		this.arr=arr;
		this.play();
	}
	
	public String getName() {
		return name;
	}
	public int getTile() {
		return tile;
	}
	public void setTile(int tile) {
		this.tile = tile;
	}
	private int getMove(){
		return move;
	}
	private void setMove(int move) {
		this.move = move;
	}
	private String Info(int t,int roll) throws NoExtraTiles{// exception handle
		if(t+roll>this.max) {
			throw new NoExtraTiles("Can't go beyond the MaxLimit");
			
			//return ", landed on Tile-" + Integer.toString(this.tile); 
		}
		else {
			//System.out.println(this.tile);
			setTile(t+roll);
			//this.tile=t+roll;
			//System.out.println(this.tile);
			return ", landed on Tile-" + Integer.toString(this.tile);
			
		}
	}
	private int getSnakebite() {
		return snakebite;
	}
	private int getVulturebite() {
		return vulturebite;
	}
	private int getCricketbite() {
		return cricketbite;
	}
	private int getTrampoline() {
		return trampoline;
	}
	
	public void GetClass(Tile t) {
		// TODO Auto-generated method stub
		if(t instanceof Snake) {
			this.snakebite++;
		}
		else if(t instanceof Vulture) {
			this.vulturebite++;
		}
		else if(t instanceof Cricket) {
			this.cricketbite++;
		}
		else if(t instanceof Trampoline) {
			this.trampoline++;
		}
	
	}
	/*public void deserialize()throws IOException, ClassNotFoundException ,NoExtraTiles,GameWinnerException{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream (
			new FileInputStream("C:\\Users\\SUNIL KUMAR\\eclipse-workspace\\practice\\src\\practice\\out.txt"));
			Player p1 = (Player) in.readObject();
			p1.play();
			//System.out.println(s1.name);
			
		} 
		finally {
			in.close();
		}
	}*/
	public void serialize()throws IOException,ClassNotFoundException,NoExtraTiles,GameWinnerException {
		//Manager s1 = new Manager("Amy");
		Scanner sc=new Scanner(System.in);
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream (
			new FileOutputStream("C:\\Users\\SUNIL KUMAR\\eclipse-workspace\\practice\\src\\practice\\"+this.name+".txt"));
			out.writeObject(this);	
		} 
		finally {
			out.close();
		}
	}

	public void play()throws GameWinnerException ,NoExtraTiles,IOException,ClassNotFoundException{
		if(this.tile!=1) {
			this.tile+=10;
		}
		System.out.println("Game Started ======================>");
		boolean Done=false;
		while(!Done) {
			try {
				
				Scanner sc=new Scanner(System.in);
				if(this.tile>=(0.25*max)&&this.tile<(0.25*max)+10){
					System.out.println("you want to continue the game or save the game");
					System.out.println("1 For continue");
					System.out.println("2 For save");
					int a=sc.nextInt();
					if(a==2) {
						serialize();
						break;
					}
					
				}
				if(this.tile>=(0.5*max)&&this.tile<(0.5*max)+10){
					System.out.println("you want to continue the game or save the game");
					System.out.println("1 For continue");
					System.out.println("2 For save");
					int a=sc.nextInt();
					if(a==2) {
						serialize();
						break;
					}
				}
				if(this.tile>=(0.75*max)&&this.tile<(0.75*max)+10) {
					System.out.println("you want to continue the game or save the game");
					System.out.println("1 For continue");
					System.out.println("2 For save");
					int a=sc.nextInt();
					if(a==2) {
						serialize();
						break;
					}
				}
				if(this.tile==1) {
					int roll=super.roll();
					setMove(getMove()+1);
					if(roll!=6) {
						
						System.out.println("[Roll-" + this.move + "]: " + this.name + " rolled "+  roll + " at Tile-" + this.tile +", OOPs you need 6 to start");
						
					}
					else {
						System.out.println("[Roll-" + this.move + "]: " + this.name + " rolled "+  roll + " at Tile-" + this.tile +". You are out of the cage! You get a free roll");
						if(this.tile==max) {
							throw new GameWinnerException(this.name + " win the game");
						}
						int r=super.roll();
						setMove(getMove()+1);
						int ini=this.tile;
						try {
							
							String s=Info(this.tile, r);
							System.out.println("[Roll-" + this.move + "]: " + this.name + " rolled "+  r + " at Tile-" + ini + s);
							
						}
						catch(NoExtraTiles e) {
							System.out.println(e.getMessage());
							System.out.println("[Roll-" + this.move + "]: " + this.name + " rolled "+  r + " at Tile-" + ini + ",landed to Tile-" + this.tile);
						}
					}
				}
				else {
					if(this.tile==max) {
						throw new GameWinnerException(this.name + " win the game");
					}
					System.out.println("Trying to shake the Tile-" + this.tile);
					int d=arr[this.getTile()-1].damage(max);
					this.GetClass(arr[this.getTile()-1]);
					//this.tile=this.tile+d;
					setTile(getTile()+d);
					System.out.println(this.name + " moved to Tile-" + this.tile);
					
					
					if(this.tile!=1) {
						int roll=super.roll();
						setMove(getMove()+1);
						int ini=this.tile;
						try {
							String s=Info(this.tile, roll);
							System.out.println("[Roll-" + this.move + "]: " + this.name + " rolled "+  roll + " at Tile-" + ini + s);
							
						}
						catch(NoExtraTiles e) {
							System.out.println(e.getMessage());
							System.out.println("[Roll-" + this.move + "]: " + this.name + " rolled "+  roll + " at Tile-" + ini + ",landed to Tile-" + this.tile);
						}
					}
					
					
				}
			}
			catch(GameWinnerException e) {
				System.out.println(e.getMessage());
				System.out.println("Total Moves :" + getMove());
				System.out.println("Total SnakeBite :" + getSnakebite());
				System.out.println("Total VultureBite :" + getVulturebite());
				System.out.println("Total CricketBite :" + getCricketbite());
				System.out.println("Total TrampolineBite :" + getTrampoline());
				Done=true;
			}
		}
	}
}
