package com.blueyonder.day8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysCalculator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1="",str2="";
		System.out.println("Enter the Starting Date : ");
		str1=sc.next();
		System.out.println("Enter the Ending Date : ");
		str2=sc.next();
		try {
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyy");
			LocalDate startDate=LocalDate.parse(str1,formatter);
			LocalDate endDate=LocalDate.parse(str2,formatter);
			if(startDate.getDayOfMonth()<=0 && startDate.getDayOfMonth()>31) {
				System.out.println("Invalid Date");
			}
			else if(startDate.getMonthValue()<=0 && startDate.getMonthValue()>32) {
				System.out.println("Invalid Month");
			}
			else if(startDate.getYear()<=0) {
				System.out.println("Invalid Year");
			}
			else{
				long days=ChronoUnit.DAYS.between(startDate, endDate);
				System.out.println("Number of Days : "+days);
			}
		}
		catch(DateTimeParseException e) {
			System.out.println("Invalid Date Format");
		}
	}

}
