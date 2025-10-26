import java.util.Scanner;
public class Main 
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		portfolio_stocks p1=new portfolio_stocks();
		stocks s1=new stocks();

		int while_hook=1;
		while(while_hook!=0)
		{
			System.out.println(" \n Type 0 to Exit \n Type 1 to List Stocks\n Type 2 to show your portfolio \n Type 3 to Buy Stocks \n Type 4 to Sell Stocks");
			System.out.println(" Type 5 to calculate overall Portfolio value ");
			int val=input.nextInt();
			switch(val)
			{
			case 0:
				//exit
				while_hook=0;
				break;
			case 1:
				// List Stocks
				System.out.println("Listing Available Stocks");
				p1.printAvailableStock();
				break;
			case 2:
				//Show Portfolio
				System.out.println("Portfolio Live Update!");
				p1.printStockArray();
				break;
			case 3:
				//Buy Stock
				System.out.println("Listing Available Stocks");
				p1.printAvailableStock();
				System.out.println("Type the number of stock you want to buy");
				int buy_stock_num=input.nextInt();
				System.out.println("Type the qty of stock you want to buy");
				int buy_stock_qty=input.nextInt();
				System.out.println("Type 1 to confirm and 0 to reject");
				int buy_stock_confirm=input.nextInt();
				if(buy_stock_confirm==1)
				{
					//buy
					p1.buyStock(buy_stock_num,buy_stock_qty);
				}else
				{
					System.out.println("Stock Buying Terminated!");
				}
				break;
			case 4:
				//Sell Stock
				System.out.println("Portfolio Live Update");
				p1.printStockArray();
				System.out.println("Type the number of stock you want to sell");
				int sell_stock_num=input.nextInt();
				System.out.println("Type the qty of the stock you want to sell");
				int sell_stock_qty=input.nextInt();
				System.out.println("Type 1 to confirm and 0 to reject");
				int sell_stock_confirm=input.nextInt();
				if(sell_stock_confirm==1)
				{
					//sell
					p1.sellStock(sell_stock_num,sell_stock_qty);
				}
				else
				{
					System.out.println("Stock Selling Terminated!");
				}
				break;
			case 5:
				System.out.println("Calculating Overall Portfolio Value");
				p1.calculateOverallPortfolioValue();
				break;
			default:
				System.out.println("Type Again");
			}
			p1.updateStockPrice();
		}
	}
}
class portfolio_stocks 
{
	stock[] stock_bought=create_stock_array();
	private int count=0;
	stocks s1=new stocks();
	balance b1=new balance();

	public static stock[] create_stock_array()
	{
		stock[] stock_bought=new stock[100];
		for(int i=0;i<stock_bought.length;i++)
		{
			stock_bought[i]=new stock();
		}
		return stock_bought;
	}
	public void printStockArray(){
		for(int i=0;i<count;i++)
		{
			System.out.printf("(%d)%s\n",i+1,stock_bought[i].toString());
		}
	}
	public void updateStockPrice()
	{
		if(Math.round(Math.random())==1)
		{
			s1.apple.updateCurrentPrice(s1.apple.get_current_price()+(int)(Math.random()*10));
		}
		else
		{
			s1.apple.updateCurrentPrice(s1.apple.get_current_price()-(int)(Math.random()*10));
		}
		if(Math.round(Math.random())==1)
		{
			s1.google.updateCurrentPrice(s1.google.get_current_price()+(int)(Math.random()*10));

		}
		else
		{
			s1.google.updateCurrentPrice(s1.google.get_current_price()-(int)(Math.random()*10));

		}
		if(Math.round(Math.random())==1)
		{
			s1.nividia.updateCurrentPrice(s1.nividia.get_current_price()+(int)(Math.random()*10));
		}
		else
		{
			s1.nividia.updateCurrentPrice(s1.nividia.get_current_price()-(int)(Math.random()*10));
		}
		if(Math.round(Math.random())==1)
		{
			s1.tesla.updateCurrentPrice(s1.tesla.get_current_price()+(int)(Math.random()*10));
		}
		else
		{
			s1.tesla.updateCurrentPrice(s1.tesla.get_current_price()+(int)(Math.random()*10));
		}
		
		
	}
	public void printAvailableStock()
	{
		System.out.println("(1)"+s1.apple.toString()+"\n"+"(2)"+s1.google.toString()+"\n"
		+ "(3)"+s1.nividia.toString()+"\n"+"(4)"+s1.tesla.toString());
	}

	public void sellStock(int stock_num,int qty)
	{
		if(stock_bought[stock_num-1].getStockName()=="Apple")
		{
			//apple
			//stock feed update 
			s1.apple=new stock(s1.apple.getStockName(),s1.apple.get_current_price(),s1.apple.getQuantity()+qty);
			//portfolio delete
			stock_bought[stock_num-1]=new stock(stock_bought[stock_num-1].getStockName(),stock_bought[stock_num-1].get_current_price(),stock_bought[stock_num-1].getQuantity()-qty);

		}
		else if(stock_bought[stock_num-1].getStockName()=="Google")
		{
			//apple
			//stock feed update 
			s1.google=new stock(s1.google.getStockName(),s1.google.get_current_price(),s1.google.getQuantity()+qty);
			//portfolio delete
			stock_bought[stock_num-1]=new stock(stock_bought[stock_num-1].getStockName(),stock_bought[stock_num-1].get_current_price(),stock_bought[stock_num-1].getQuantity()-qty);

		}
		else if(stock_bought[stock_num-1].getStockName()=="Nividia")
		{
			//apple
			//stock feed update 
			s1.nividia=new stock(s1.nividia.getStockName(),s1.nividia.get_current_price(),s1.nividia.getQuantity()+qty);
			//portfolio delete
			stock_bought[stock_num-1]=new stock(stock_bought[stock_num-1].getStockName(),stock_bought[stock_num-1].get_current_price(),stock_bought[stock_num-1].getQuantity()-qty);

		}
		else if(stock_bought[stock_num-1].getStockName()=="Tesla")
		{
			//apple
			//stock feed update 
			s1.tesla=new stock(s1.tesla.getStockName(),s1.tesla.get_current_price(),s1.tesla.getQuantity()+qty);
			//portfolio delete
			stock_bought[stock_num-1]=new stock(stock_bought[stock_num-1].getStockName(),stock_bought[stock_num-1].get_current_price(),stock_bought[stock_num-1].getQuantity()-qty);

		}
		else
		{
			System.out.println("Error! Wrong name Entered");
		}

	}
	public void buyStock(int stock_num,int qty)
	{
		if(stock_num==1&&(s1.apple.get_current_price()*qty<b1.get_current_balance()&& qty<=s1.apple.getQuantity()))
		{
			//apple
			
				//authenticate
				stock_bought[count++]=new stock(s1.apple.getStockName(),s1.apple.get_current_price(),qty);
				s1.apple=new stock(s1.apple.getStockName(),s1.apple.get_current_price(),s1.apple.getQuantity()-qty);
		}	
		else if (stock_num==2&&(s1.google.get_current_price()*qty<b1.get_current_balance()&& qty<=s1.google.getQuantity()))
		{
			//google
				//authenticate
				stock_bought[count++]=new stock(s1.google.getStockName(),s1.google.get_current_price(),qty);
				s1.google=new stock(s1.google.getStockName(),s1.google.get_current_price(),s1.google.getQuantity()-qty);
		}
		else if (stock_num==3&&(s1.nividia.get_current_price()*qty<b1.get_current_balance()&& qty<=s1.nividia.getQuantity()))
		{
				//authenticate
				stock_bought[count++]=new stock(s1.nividia.getStockName(),s1.nividia.get_current_price(),qty);
				s1.nividia=new stock(s1.nividia.getStockName(),s1.nividia.get_current_price(),s1.nividia.getQuantity()-qty);
		}
		else if (stock_num==4&&(s1.tesla.get_current_price()*qty<b1.get_current_balance()&& qty<=s1.tesla.getQuantity()))
		{
			//tesla
				//authenticate
				stock_bought[count++]=new stock(s1.tesla.getStockName(),s1.tesla.get_current_price(),qty);
				s1.tesla=new stock(s1.tesla.getStockName(),s1.tesla.get_current_price(),s1.tesla.getQuantity()-qty);
		}
		else{
			System.out.println("Error in buying Stock ! Decrease the Stock Quantity");
		}
	}
	public void calculateOverallPortfolioValue()
	{
		
		int stock_value=0;
		for(int i=0;i<=count;i++)
		{
			stock_value+=stock_bought[i].get_current_price()*stock_bought[i].getQuantity();
		}	
		System.out.println("Current Total Portfolio Value is :₹"+stock_value);
	}

}


class stocks 
{
	stock apple=new stock("Apple",170,25);
	stock google=new stock("Google",150,20);
	stock nividia=new stock("Nividia",250,45);
	stock tesla=new stock("Tesla",125,10);

	public String getStocks()
	{
		return "(1)"+apple.toString()+"\n"+"(2)"+google.toString()+"\n"
		+ "(3)"+nividia.toString()+"\n"+"(4)"+tesla.toString();
	}
	// public void updateStock(String name,int current_price,int quantity)
	// {
	// 	if(name=="apple")
	// 	{
	// 		apple=new stock(name,current_price,quantity);
	// 	}
	// 	else if(name=="nividia")
	// 	{
	// 		nividia=new stock(name,current_price,quantity);
	// 	}
	// 	else if (name=="google")
	// 	{
	// 		google=new stock(name,current_price,quantity);
	// 	}
	// 	else if(name=="tesla")
	// 	{	
	// 		tesla=new stock(name,current_price,quantity);
	// 	}
	// 	else
	// 	{
	// 		System.out.println("Error in stock name!");
	// 	}
	// }
}

class stock 
{
	String name;
	int current_price;
	int quantity;

	public stock()
	{

	}
	public stock(String name,int current_price,int quantity)
	{
		this.name=name;
		this.current_price=current_price;
		this.quantity=quantity;
	}
	public void updateName(String name)
	{
		this.name=name;
	}
	public void updateQty(int quantity)
	{
		this.quantity=quantity;
	}
	public void updateCurrentPrice(int current_price)
	{
		this.current_price=current_price;
	}
	public int get_current_price()
	{
		return this.current_price;
	}
	public String getStockName()
	{
		return this.name;
	}
	public int getQuantity()
	{
		return this.quantity;
	}
	public void buyStock(int quantity)
	{
		this.quantity=this.quantity-1;
	}
	public void sellStock(int quantity)
	{
		this.quantity=this.quantity+1;
	}
	public String toString()
	{
		return this.name +"  ₹"+this.current_price+"  qty="+this.quantity;
	}

}


class balance  
{
	private int current_balance=30000;
	private int initial_balance=current_balance;

	public balance()
	{

	}
	public balance(boolean buy,String name,int price,int qty_num)
	{
		//check current_balance value>price*qty_num in the function
		// if(buy==true)
		// {
		// 	//buy
		// 	current_balance=current_balance-price*qty_num;
		// 	update_portfolio(buy,name,price,qty_num);
		// }
		// else
		// {
		// 	//sell
		// 	current_balance=current_balance+price*qty_num;
		// 	update_portfolio(buy,name,price,qty_num);
		// }
	}
	public int get_current_balance()
	{
		return current_balance;
	}
	public int get_initial_balance()
	{
		return initial_balance;
	}
}
