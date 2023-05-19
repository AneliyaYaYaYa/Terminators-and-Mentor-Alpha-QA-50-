package com.company.cosmetics.core.providers;

import com.company.cosmetics.core.contracts.Reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    
    private final Scanner scanner;
    
    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }
    
    public String readLine() {
        return scanner.nextLine();
    }
    
}
