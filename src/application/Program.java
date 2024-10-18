package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Set<LogEntry> set = new HashSet<>();//the fastest option to count the users and do not accept repetition 
			
			String line = br.readLine();
			while (line != null) {
			
				String[] fields = line.split(" "); //split vector
				String username = fields[0];//1st field (name)
				Date moment = Date.from(Instant.parse(fields[1]));//2nd field (date)
				
				set.add(new LogEntry(username, moment));//do not accept repeated names SET
				
				line = br.readLine();
			}	
			System.out.println("Total users: " + set.size());

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
