package com.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.CarDetails;
import com.dao.CarDao;

public class TestClass {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/common/context.xml");
		CarDao cd=(CarDao)context.getBean(CarDao.class);
	    
	    
	    System.out.println("Welcome to Mullet Joe's Gently Used Autos..!");
	    
		Scanner sc=new Scanner(System.in);
	    int ch;
	    while(true)
	    {
	      System.out.println("1.Add/Insert");
	      System.out.println("2.update");
	      System.out.println("3.delete");
	      System.out.println("4.List/Show");
	     // System.out.println("5.Sum");
	      System.out.println("5.Quit");
          System.out.println("Enter Your Choice:");
          ch=sc.nextInt();
          
          switch(ch)
		  {
		   case 1: 
			   System.out.println("Enter The Car deatails...");
			   System.out.println("Enter Car Maker:");
			   String cMake=sc.next();
			   System.out.println("Enter Car Model:");
			   String cmodel=sc.next();
			   System.out.println("Enter The car year:");
			   int cyear=sc.nextInt();
			   System.out.println("Enter The car $ price :");
			   double carprice=sc.nextDouble();
		
			   cd.insert(new CarDetails(cMake,cmodel, cyear, carprice));
		   break;
		
		   case 2:
				System.out.println("Update The Car deatails...");
				System.out.println("Which car data You update:");
				String ucm=sc.next();
				System.out.println("Enter The car model:");
				String ucmodel=sc.nextLine();
				System.out.println("Enter The car year:");
				int ucyear=sc.nextInt();
				System.out.println("Enter The car $ price :");
				double ucarprice=sc.nextDouble();
		        int status=cd.update(new CarDetails(ucm,ucmodel,ucyear,ucarprice)); 
	            System.out.println(status); 
	       break;
		
		   case 3:	   
			   CarDetails cdd=new CarDetails();
			   System.out.println("Which car data You update:");
			   String deletecar=sc.next();
			   cdd.setMake(deletecar);
			   int delete=cd.delete(cdd);
			   System.out.println(delete);
		   break;
		
		   case 4:
			   List<CarDetails> list=cd.getCardata();  
			    for(CarDetails e:list)  
			        System.out.println(e);  
		   break;  
		
		  /* case 5:
			   
			  int sumd=cd.sum(new carDetails()); 
			  System.out.println(sumd); 
			   break;
			   */
			   
	       case 5:  System.exit(1);
		   		default : System.out.println("Invalid Choice \n");
		  }
	    }
	}
}
