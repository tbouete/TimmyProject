package view;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import agency.Visit;

public interface Command {
	public void execute();
	
	public static Date parseDate(){
		Date ret;
		
		Scanner sc = new Scanner(System.in);
		int day = -1;
		while(day < 0 && day > 31){
			System.out.println("Please enter the day of this date : ");
			try{
				if(sc.hasNextInt()) day = sc.nextInt() - 1;
			}catch(InputMismatchException e){
				System.out.println("You must enter an integer !" + "\n");
			}catch(NoSuchElementException e){
				e.printStackTrace();
			}catch(IllegalStateException e){
				e.printStackTrace();
			}
		}
		
		int month = -1;
		while(month < 0 && month > 12){
			System.out.println("Please enter the month of this date : ");
			try{
				if(sc.hasNextInt()) month = sc.nextInt() - 1;
			}catch(InputMismatchException e){
				System.out.println("You must enter an integer !" + "\n");
			}catch(NoSuchElementException e){
				e.printStackTrace();
			}catch(IllegalStateException e){
				e.printStackTrace();
			}
		}
		
		int year = -1;
		while(year < 0 && year > 2050){
			System.out.println("Please enter the year of this date : ");
			try{
				if(sc.hasNextInt()) day = sc.nextInt() - 1;
			}catch(InputMismatchException e){
				System.out.println("You must enter an integer !" + "\n");
			}catch(NoSuchElementException e){
				e.printStackTrace();
			}catch(IllegalStateException e){
				e.printStackTrace();
			}
		}
		
		ret = new Date(year, month, day);
		return ret;
	}
}
