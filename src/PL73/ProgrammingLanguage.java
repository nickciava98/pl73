package PL73;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProgrammingLanguage {
	public static String codeLine = ""; //line of source code, to analyze
    public static String function = ""; //function detected on the line
    public static String operator = ""; //operator detected on the line
    public static String word1 = ""; //first operand
    public static String word2 = ""; //second operand
    public static String bin = ""; //bin for variables detected
    public static int c; //controls index
    public static int i; //first index
    public static int j; //second index
    public static int ncom; //index of the array where lines commands stored
    public static int nend = 0;
    public static boolean error = false;
    public static char[] alphabet = {
    		'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 
    		'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 
    		'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 
    		'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 
    		'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 
    		'Z', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
    		'8', '9'};
    public static String[] command = {
    		"var", "input", "println", "main", "if", "elif", 
    		"for", "while", "*", "do_while", "end"};
    public static String path1 = "sorgente.txt", 
    		path2 = "java.txt", write = "", read = "";
    
    public static void main(String[] args) throws IOException {  
        File f = new File(path1);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        File f2 = new File(path2);
        FileWriter fw = new FileWriter(f2, true); 
                
        codeLine = br.readLine();
        
        while (codeLine != null) {        
            if (codeLine.length() > 0) {
            	if (codeLine.charAt(
            			codeLine.length() - 1) == ';') {
            		codeLine = codeLine.substring(0, 
            				codeLine.length() - 1);
            		codeLine += " ";
                
            		i = 0;
            
            		if (i < codeLine.length() & !error) 
            			while (codeLine.charAt(i) == ' ') {
            				i++;
                        
            				if (i >= codeLine.length()) {
            					error = true;
            					break;
            				}
            			}
            	
	                j = i;
	                
	                if (j < codeLine.length() & !error) 
	                    while (codeLine.charAt(j) != ' ') {
	                        j++;
	                    
	                        if (j >= codeLine.length()) {
	                            error = true;
	                            break;
	                        }
	                    }
	                
	                function = codeLine.substring(i, j); //Acquisizione della funzione (primo termine) completata           
	                i = j;
	                ncom = 0;	                
	                
	                while (ncom < 11 
	                		& !function.equals(command[ncom])) { 
	                    ncom++; 
	                }
	                
	                switch (ncom) {
	                    case 11:
	                        error = true;
	                        
	                        System.err.println(
	                        		"Function not detected in DB");
	                    
	                        break;
	                
	                    case 0: // var
	                        if (i < codeLine.length() & !error) 
	                            while (codeLine.charAt(i) == ' ') {
	                                i++;
	                            
	                                if (i >= codeLine.length()) {
	                                    error = true;
	                                    break;
	                                }
	                            }                        
	                        
	                        j = i;
	                        
	                        if (j < codeLine.length() & !error) 
	                            while (codeLine.charAt(j) != ' ' 
	                            		& codeLine.charAt(j) != '=') {
	                                j++;
	                            
	                                if (j >= codeLine.length()) {
	                                    error = true;
	                                    break;
	                                }
	                            }                        
	                        
	                        word1 = codeLine.substring(i, j);
	                        c = 0;
	                        
	                        for (int x = 0; x < word1.length(); x++) 
	                            for (int y = 0; y < 62; y++) 
	                                if (word1.charAt(x) == alphabet[y]) 
	                                    c++; 
	               
	                        if (c != word1.length()) {
	                            System.err.print(
	                            		"Error in variable declaration. Symbols not allowed");
	                        
	                            error = true;
	                        }
	                        
	                        if (!error) {
	                            i = j;
	                        
	                            if (i < codeLine.length()) 
	                                while (codeLine.charAt(i) == ' ') {
	                                    i++;
	                                
	                                    if (i >= codeLine.length()) {
	                                        error = true;
	                                        break;
	                                    }
	                                }
	                            
	                            j = i;
	                            
	                            if (j < codeLine.length() & !error) 
	                                while (codeLine.charAt(j) == '=') {
	                                    j++;
	                                
	                                    if (j >= codeLine.length()) {
	                                        error = true;
	                                        break;
	                                    }
	                                }
	                            
	                            operator = codeLine.substring(i, j);
	                        }
	                        
	                        if (!error) {
	                            i = j;
	                        
	                            if (i < codeLine.length()) 
	                                while (codeLine.charAt(i) == ' ') {
	                                    i++;
	                                
	                                    if (i >= codeLine.length()) {
	                                        error = true;
	                                        break;
	                                    }
	                                }
	                            
	                            j = i;
	                            
	                            if (j < codeLine.length() & !error) 
	                                while (codeLine.charAt(j) != ' ') {
	                                    j++;
	                                
	                                    if (j >= codeLine.length()) {
	                                        error = true;
	                                        break;
	                                    }
	                                }
	                            
	                            word2 = codeLine.substring(i, j);
	                            
	                            if (j < codeLine.length() & !error) 
	                                while (j < codeLine.length() - 1) {
	                                    j++;
	                                
	                                    if (codeLine.charAt(j) != ' ') {
	                                        error = true;
	                                        break;
	                                    }
	                                }
	                            
	                            if (!error) {
	                                c = 0;
	                            
	                                for (int x = 0; x < word2.length(); x++) 
	                                    for (int y = 52; y < 62; y++) 
	                                        if (word2.charAt(x) == alphabet[y]) 
	                                            c++;
	                                
	                                if (bin.indexOf(word1) != -1) {
	                                    error = true;
	                                
	                                    System.err.println(
	                                    		"Error. Variable already declared");
	                                }
	                                
	                                else
	                                    bin += word1 + " ";
	                            }
	                            
	                            if (!error) {
	                                if (c == word2.length()) {
	                                    write = "int " + word1 + " = " + word2 + ";";
	                                    
	                                    fw.write(write);
	                                    fw.write("\n");
	                                
	                                    System.out.println("int");
	                                }
	                                
	                                else if (c == (word2.length() - 1) 
	                                		& word2.indexOf('.') > 0) {
	                                    write = "float " + word1 + " = " + word2 + ";";
	                                    
	                                    fw.write(write);
	                                    fw.write("\n");
	                                    
	                                    System.out.println("float");
	                                }
	                                
	                                else if (word2.equals("true") | word2.equals("false")) {
	                                    write = "boolean " + word1 + " = " + word2 + ";";
	                                    
	                                    fw.write(write);
	                                    fw.write("\n");
	                                    
	                                    System.out.println("boolean detected");
	                                }
	                                
	                                else if (word2.charAt(0) == '"' 
	                                		& word2.charAt(word2.length() - 1) == '"') {
	                                    write = "String " + word1 + " = " + word2 + ";";
	                                    
	                                    fw.write(write);
	                                    fw.write("\n");
	                                    
	                                    System.out.println("string");
	                                }
	                                
	                                else 
	                                	error = true;
	                            }
	                        }
	                    
	                    break; 
	                    
	                    case 1: // input
	                        if (i < codeLine.length() & !error) 
	                            while (codeLine.charAt(i) == ' ') {
	                                i++;
	                                
	                                if (i >= codeLine.length()) {
	                                    error = true;
	                                    break;
	                                }
	                            }
	                        
	                        j = i;
	                        
	                        if (j < codeLine.length() & !error) 
	                            while (codeLine.charAt(j) != ' ') {
	                                j++;
	                            
	                                if (j >= codeLine.length()) {
	                                    error = true;
	                                    break;
	                                }
	                            }
	                        
	                        word1 = codeLine.substring(i, j);
	                        
	                        while (j < codeLine.length() - 1) {
	                            j++;
	                        
	                            if (codeLine.charAt(j) != ' ') {
	                                error = true;
	                                break;
	                            }
	                        }
	                        
	                        if (bin.indexOf(word1) == -1) {
	                            error = true;
	                        
	                            System.err.println(
	                            		"Error. Variable not declared");
	                        }
	                        
	                        if (!error) {
	                            System.out.println("input: " + word1); 
	                            
	                            write = "Scanner x = new Scanner(System.in); String s; s = x.nextLine();";
	                            
	                            fw.write(write);
	                            fw.write("\n");
	                        }
	                    
	                        break;
	                        
	                    case 2: // println
	                        if (i < codeLine.length() & !error) 
	                            while (codeLine.charAt(i) == ' ') {
	                                i++;
	                            
	                                if (i >= codeLine.length()) {
	                                    error = true;
	                                    break;
	                                }
	                            }
	                        
	                        j = i;
	                        
	                        if (j < codeLine.length() & !error) 
	                            while (codeLine.charAt(j) != ' ') {
	                                j++;
	                            
	                                if (j >= codeLine.length()) {
	                                    error = true;
	                                    break;
	                                }
	                            }
	                        
	                        word1 = codeLine.substring(i, j);
	                        
	                        while (j < codeLine.length() - 1) {
	                            j++;
	                        
	                            if (codeLine.charAt(j) != ' ') {
	                                error = true;
	                                break;
	                            }
	                        }
	                        
	                        if (bin.indexOf(word1) == -1) {
	                            error = true;
	                        
	                            System.err.println(
	                            		"Error. Variable not declared");
	                        }
	                        
	                        if (!error) {
	                            System.out.println(
	                            		"println: " + word1);
	                            
	                            write = "System.out.println(word1);";
	                            
	                            fw.write(write);
	                            fw.write("\n");
	                        }
	                    
	                        break;
	                        
	                    case 10: //end
	                        nend--;
	                        
	                        while (j < codeLine.length() - 1) {
	                            j++;
	                                
	                            if (codeLine.charAt(j) != ' ') {
	                                error = true;
	                                break;
	                            }
	                        }
	                        
	                        if (!error) {
	                            System.out.println("end");
	                            
	                            write = "}";
	                            
	                            fw.write(write);
	                            fw.write("\n");
	                        }
	                        
	                        break;  
	                }
	            }
	            
	            else if (codeLine.indexOf("main") != -1 
	            		| codeLine.indexOf("if") != -1 
	            		| codeLine.indexOf("elif") != -1 
	            		| codeLine.indexOf("else") != -1 
	            		| codeLine.indexOf("for") != -1 
	            		| codeLine.indexOf("while") != -1 
	            		| codeLine.indexOf("*") != -1 
	            		| codeLine.indexOf("do_while") != -1) {
	                i = 0;
	                   
	                if (i < codeLine.length() & !error) 
	                    while (codeLine.charAt(i) == ' ') {
	                        i++;
	                            
	                        if (i >= codeLine.length()) {
	                            error = true;
	                            break;
	                        }
	                    }
	                
	                j = i;
	                
	                if (j < codeLine.length() & !error) 
	                    while (codeLine.charAt(j) != ' ') {
	                        j++;
	                    
	                        if (j >= codeLine.length()) {
	                            error = true;
	                            break;
	                        }
	                    }
	                
	                function = codeLine.substring(i, j); //Acquisizione della funzione (primo termine) completata           
	                i = j;
	                ncom = 0;
	                
	                while (ncom < 11 
	                		& !function.equals(command[ncom])) {
	                    ncom++;
	                }
	                
	                switch(ncom) {
	                    case 3:
	                        nend++;
	                        
	                        while(j < codeLine.length() - 1) {
	                            j++;
	                        
	                            if(codeLine.charAt(j) != ' ') {
	                                error = true;
	                                break;
	                            }
	                        }
	                        
	                        if (!error) {
	                            System.out.println("main");
	                            
	                            write = "public static void main(){";
	                            
	                            fw.write(write);
	                            fw.write("\n");
	                        }
	                    
	                        break;
	                    
	                    case 4:
	                        nend++;
	                        
	                        if (i < codeLine.length() & !error) 
	                            while (codeLine.charAt(i) == ' ') {
	                                i++;
	                            
	                                if (i >= codeLine.length()) {
	                                    error = true;
	                                    break;
	                                }
	                            }
	                        
	                        j = i;
	                        
	                        if (j < codeLine.length() & !error) 
	                            while (codeLine.charAt(j) != ' ' 
	                            		& codeLine.charAt(j) != '=') {
	                                j++;
	                            
	                                if (j >= codeLine.length()) {
	                                    error = true;
	                                    break;
	                                }
	                            }
	                        
	                        word1 = codeLine.substring(i, j);
	                        
	                        if (bin.indexOf(word1) == -1) {
	                            error = true;
	                        
	                            System.err.println(
	                            		"Error. Variable not declared");
	                        }
	                        
	                        if (!error) {
	                            i = j;
	                        
	                            if (i < codeLine.length()) 
	                                while (codeLine.charAt(i) == ' ') {
	                                    i++;
	                                
	                                    if (i >= codeLine.length()) {
	                                        error = true;
	                                        break;
	                                    }
	                                }
	                            
	                            j = i;
	                            
	                            if (j < codeLine.length() & !error) 
	                                while (codeLine.charAt(j) == '>' 
	                                		| codeLine.charAt(j) == '<' 
	                                		| codeLine.charAt(j) == '=') {
	                                    j++;
	                                
	                                    if (j >= codeLine.length()) {
	                                        error = true;
	                                        break;
	                                    }
	                                }
	                            
	                            operator = codeLine.substring(i, j);
	                        }
	                        
	                        if (!error) {
	                            i = j;
	                         
	                            if (i < codeLine.length() & !error) 
	                                while (codeLine.charAt(i) == ' ') {
	                                    i++;
	                                
	                                    if (i >= codeLine.length()) {
	                                        error = true;
	                                        break;
	                                    }
	                                }
	                            
	                            j = i;
	                            
	                            if (j < codeLine.length() & !error) 
	                                while (codeLine.charAt(j) != ' ' 
	                                		& codeLine.charAt(j) != '=') {
	                                    j++;
	                                
	                                    if (j >= codeLine.length()) {
	                                        error = true;
	                                        break;
	                                    }
	                                }
	                            
	                            word2 = codeLine.substring(i, j);
	                            
	                            if (bin.indexOf(word2) == -1) {
	                                error = true;
	                            
	                                System.err.println(
	                                		"Error. Variable not declared");
	                            }
	                            
	                            while (j < codeLine.length() - 1) {
	                                j++;
	                            
	                                if (codeLine.charAt(j) != ' ') {
	                                    error = true;
	                                    break;
	                                }
	                            }
	                            
	                            if (!error) {
	                                System.out.println("if"); 
	                                
	                                write = "if (" + word1 + operator + word2 + ")";
	                                
	                                fw.write(write);
	                                fw.write("\n");
	                            }
	                    
	                            break;
	                        }
	                }
	            
	                System.err.println("Error: " + error);
	        
	                if (nend > 0) 
	                    System.err.println(
	                    		"Some functions are not closed");
	                
	                else if (nend < 0) 
	                    System.err.println(
	                    		"Too much functions closed");
	            }
	            
	            else
	            	System.err.println(
	                		"Error. No endline ';' detected");
	        
	            codeLine = br.readLine();
	        }
        }
        
        fw.close();
        fr.close();
    }
}