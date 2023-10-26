
import java.util.Scanner;
public class Coffee {

	private int RemainingCoffee=100;
	private int RemainingMilk=100;
	
	private int requiredMilkforlatte=10;
	
	private int requiredcoffeeforlatte=10;
	
	private int requiredcoffeeforespresso=20;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Boolean exit=true;
		do {
			
			
			System. out. println("********Welcome to coffee making machine************"); 
			
			Coffee coffee=new Coffee();
			if(coffee.AdminOrCOnsumenr()==1)
			{
				//its for consumer
				System.out.println("Which coffee you want to make?\n 1.Latte\n 2.Espresso\n");
				Scanner coffeType=new Scanner(System.in);
				int temp=coffeType.nextInt();
				if(temp==1)
				{
					//for latte
					coffee.MakeLatte(coffee);
				}
				else if(temp==2)
				{
					//espresso
					coffee.MakeEspresso(coffee);
				}
				
			}
			else if(coffee.AdminOrCOnsumenr()==2)
			{
				//its for admin 
				
			}
    			
			System.out.println("Press z to exit\nAny other key tomake coffee again");
			Scanner x=new Scanner(System.in);
			String str=x.nextLine(); 
			if((str.equals("z"))||(str.equals("Z")))
			{
				
				System. exit(0);
				 
			}
		}while(true);
		
		
		
		
		
	}
	
	public void AdminRefiling(Coffee coffee)
	{
		System.out.println("Refiling coffee machine");
		coffee.RemainingCoffee=100;
		coffee.RemainingMilk=100;
		
	}
	public void AdminCleaning(Coffee coffee)
	{
		System.out.println("Cleaning up coffee machine");
		AdminRefiling(coffee);
		System.out.println("Refilled coffee machine");
	}
	public void CheckMatrial(Coffee coffee) {
		
		System.out.println("Remaining milk is"+coffee.RemainingMilk+"%\nRemaing coffee is"+coffee.RemainingCoffee+"%");
		
	}
	public Boolean Payment(String value)
	{
		 Boolean paymentstatus=false;
		if(value=="Latte") {
			//charge 2 pounds
			System.out.println("Please enter money in machine");
			Scanner s=new Scanner(System.in);
			int money=s.nextInt();
			
			if(money==2)
			{
				System.out.println("Thanks for paying getting your coffee ready");
				paymentstatus= true;
			}
			else if(money>2)
			{
				money-=2;
				System.out.println("Thanks for paying Please get your change\nGetting your coffee ready");
				paymentstatus= true;
			}
			else {
				System.out.println("Not enough money");
				paymentstatus= false;
			}
		}
		else if(value=="Espresso")
		{
			//charge 1 pound
			System.out.println("Please enter money in machine");
			Scanner s=new Scanner(System.in);
			int money=s.nextInt();
			
			if(money==1)
			{
				System.out.println("Thanks for paying getting your coffee ready");
				paymentstatus= true;
			}
			else if(money>1)
			{
				money--;
				System.out.println("Thanks for paying Please get your change\nGetting your coffee ready");
				paymentstatus= true;
			}
			else {
				System.out.println("Not enough money");
				paymentstatus= false;
			}
		}
		
			return paymentstatus;	
	}
	
	public void MakeLatte(Coffee coffee)
	{
		if((coffee.RemainingCoffee>=coffee.requiredcoffeeforlatte)&&(coffee.RemainingMilk>=coffee.requiredMilkforlatte) )
		{
			if(Payment("Latte"))
			{
				coffee.RemainingCoffee-=coffee.requiredcoffeeforlatte;
				coffee.RemainingMilk-=coffee.requiredMilkforlatte;
				System.out.println("Your coffee is ready please take it");
				
			}
			else {
				System.out.println("You didn't enter required money");
			}
		}
		else {
			System.out.println("Sorry Not enough coffee in machine to make coffee");
		}
	}
	
	public void MakeEspresso(Coffee coffee)
	{
		if(coffee.RemainingCoffee>=coffee.requiredcoffeeforespresso)
		{
			if(Payment("Espresso"))
			{
				coffee.RemainingCoffee-=coffee.requiredcoffeeforespresso;
				System.out.println("Your coffee is ready please take it");
				
			}
			else {
				System.out.println("You didn't enter required money");
			}
		}
		else {
			System.out.println("Sorry Not enough coffee in machine to make coffee");
		}
	}
	

	public int AdminOrCOnsumenr()
	{
		
		System.out.println("Press 1 for making coffee\nPress 2 if you are admin\n");
		Scanner obj=new Scanner(System.in);
		int temp=obj.nextInt();
		return temp;
		
	}
}
