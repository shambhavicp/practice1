package jdbc_maven_eb9_users;

import java.util.Scanner;

public class UsersMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		boolean exit = true;

		Users users = new Users();
		UsersCRUD crud = new UsersCRUD();

		
		do {
			System.out.println(" 1.signUp \n 2.login \n 3.exit");
			System.out.println("enter your choice ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("enter the id");
				int id = scanner.nextInt();

				System.out.println("enter the username");
				String userName = scanner.next();

				System.out.println("enter the email");
				String email = scanner.next();

				System.out.println("enter the password");
				String password = scanner.next();

				System.out.println("enter the address");
				String address = scanner.next();

				users.setId(id);
				users.setUserName(userName);
				users.setEmail(email);
				users.setPassword(password);
				users.setAddress(address);
				
				crud.saveUsers(users);
			}
				break;
			case 2: {
				System.out.println("enter the email");
				String email = scanner.next();

				System.out.println("enter the password");
				String password = scanner.next();
				
				users.setEmail(email);
				users.setPassword(password);

				boolean saved = crud.loginUsers(users);

				if (saved == true) {
					System.out.println("logged in successfully");
				
					boolean exits=true;
					do {
						System.out.println("which password u want to display or reset");
						System.out.println(" 1.Facebook Password \n 2.Instagram Password \n 3.Snapchat Password \n 4.Whatsapp Password \n 5.Twitter Password \n 6.Exit");
						System.out.println("enter your choice ");
						int choice1 = scanner.nextInt();
						
						switch(choice1) {
						case 1:{
							System.out.println(" 1.display \n 2.set or reset");
							System.out.println("enter your choice");
							int choice2= scanner.nextInt();
							
							switch(choice2) {
							case 1:{
								crud.displayFacebookPassword(users);
								
							}
							break;
							case 2:{
								
								System.out.println("enter the password");
								String facebookPassword=scanner.next();
								
								users.setFacebookPassword(facebookPassword);
								crud.resetFacebookPassword(users);
								
							}
							}
						}
						break;
						
						case 2:{
							System.out.println(" 1.display \n 2.set or reset");
							System.out.println("enter your choice");
							int choice2= scanner.nextInt();
							
							switch(choice2) {
							case 1:{
								crud.displayInstagramPassword(users);
								
							}
							break;
							case 2:{
								
								System.out.println("enter the password");
								String instagramPassword=scanner.next();
								users.setInstagramPassword(instagramPassword);
								crud.resetInstagramPassword(users);							
								
							}
							}
							
							
						}
						break;
						
						case 3:{
							
							System.out.println(" 1.display \n 2.set or reset");
							System.out.println("enter your choice");
							int choice2= scanner.nextInt();
							
							switch(choice2) {
							case 1:{
								crud.displaySnapchatPassword(users);
								
							}
							break;
							case 2:{
								
								System.out.println("enter the password");
								String snapchatPassword=scanner.next();
								users.setSnapchatPassword(snapchatPassword);
								
								crud.resetSnapchatPassword(users);
								
							}
							}
							
						}
						break;
						
						case 4:{
							
							System.out.println(" 1.display \n 2.set or reset");
							System.out.println("enter your choice");
							int choice2= scanner.nextInt();
							
							switch(choice2) {
							case 1:{
								crud.displayWhatsappPassword(users);
								
							}
							break;
							case 2:{
								
								System.out.println("enter the password");
								String whatsappPassword=scanner.next();
								users.setWhatsappPassword(whatsappPassword);
							
								crud.resetWhatsappPassword(users);
								
							}
							}
						}
						break;
						
						case 5:{
							
							
							System.out.println(" 1.display \n 2.set or reset");
							System.out.println("enter your choice");
							int choice2= scanner.nextInt();
							
							switch(choice2) {
							case 1:{
								crud.displayTwitterPassword(users);
								
							}
							break;
							case 2:{
								
								System.out.println("enter the password");
								String twitterPassword=scanner.next();
								users.setTwitterPassword(twitterPassword);
								
								crud.resetTwitterPassword(users);
								
							}
							}
						}
						break;
						
						case 6:exits=false;
						System.out.println("logged out successfully");
						}

						
					}while(exits);
					
					
				} else {
					System.out.println("invalid");
				}

			}
			break;
			case 3:exit=false;
			System.out.println("Thank you");

			}
		} while (exit);

	}

}
