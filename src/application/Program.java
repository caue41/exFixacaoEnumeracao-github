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
		
 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirth = sdf.parse(sc.next());
		System.out.print("Status: ");
		String orderStatus = sc.next();
		System.out.print("How many items to this order?");
		int itemsQuantity = sc.nextInt();
		Date x = new Date();
		Date momentDate = sdf.parse("x");
		
		Order order = new Order(momentDate, OrderStatus.valueOf(orderStatus), new Client(clientName, clientEmail, clientBirth));
		
		for(int i = 1; i <= itemsQuantity; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int itemQuantity = sc.nextInt();
			Product itemProduct = new Product(productName, productPrice);
			OrderItem orderItemData = new OrderItem(itemQuantity, itemProduct.getPrice(), itemProduct);
		}
		
		System.out.println("ORDER SUMARY:");
		System.out.print("Order moment: " + order.getMoment());
		System.out.print("Order status" + order.getStatus());
		System.out.print("Client: " + order.getClient().getName() + order.getClient().getBirthDate() + " - " + order.getClient().getEmail());
		System.out.println("Order items:");
		//falta fazer p for search do to String
		
		sc.close();
	}

}


/*Date x1 = new Date();
System.out.println(sdf.format(x));

ou 

Date x2 = new Date(System.currentTimeMillis());*/