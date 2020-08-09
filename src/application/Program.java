package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.num.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
 		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
 		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirth = sdf1.parse(sc.next());
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.next();
		System.out.print("How many items to this order? ");
		int itemsQuantity = sc.nextInt();
		Date x = new Date();
		
		Order order = new Order(x, OrderStatus.valueOf(orderStatus), new Client(clientName, clientEmail, clientBirth));
		
		for(int i = 1; i <= itemsQuantity; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer itemQuantity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem it = new OrderItem(itemQuantity, productPrice, product );
			order.addItem(it);
		}
		
		System.out.println();
		System.out.println(order);
		
		
		/*System.out.println();
		System.out.println("ORDER SUMARY:");
		System.out.println("Order moment: " + sdf2.format(order.getMoment()));
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " 
								+ order.getClient().getName() 
								+ " (" + sdf1.format(order.getClient().getBirthDate()) 
								+ ")" 
								+ " - " 
								+ order.getClient().getEmail());
		System.out.println("Order items:");
		
		for(int i = 0; i < itemsQuantity; i++) {
			orderItemData.toString();
			System.out.print(orderItemData);
		}
		
		System.out.printf("Total price: $%.2f%n", order.total());*/
				
		
		sc.close();
	}

}