package problems;

import java.io.File;
import java.util.Scanner;

public class DirectorySize{
	public static void main(String[] args) {
		System.out.println("Enter a directory or file: ");
		Scanner input = new Scanner(System.in);
		String directory = input.nextLine();
		System.out.print(getSize(new File(directory)) + " bytes");
	}
	
	public static long getSize(File file) {
		long size = 0;
		
		if(file.isDirectory()) {
			File[] list = file.listFiles();
			if(list != null) {
				for(File item:list) {
					size += getSize(item);
				}
			}
		}
		
		else {
			size += file.length();
		}
		return size;
	}
}