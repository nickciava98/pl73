package PL73;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProgrammingLanguage {
	public static String codeLine; //Rigo (completo da scomforre)
    public static String function; //Comando
    public static String operator; //Operatore
    public static String word1; //Primo termine
    public static String word2; //Secondo Termine
    public static String bin = ""; //Bidone per le variabili
    public static int c; //Variabile utilizzata per i controlli
    public static int i; //Indice1
    public static int j; //Indice2
    public static int ncom; //Numero (indice) del array command inerente al rigo
    public static int nend = 0;
    public static boolean error = false;
    
    public static char alphabet[] = {
    		'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 
    		'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 
    		'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 
    		'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 
    		'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 
    		'Z', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
    		'8', '9'};
    
    public static String command[] = {
    		"var", "input", "println", "main", "if", "elif", 
    		"for", "while", "*", "do_while", "end"};
    
    public static String path1 = "sorgente.txt", 
    		path2 = "java.txt", write = "", read = "";
    
    public static void main(String[] args) throws IOException
    {  
        File f = new File(path1);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        File f2 = new File(path2);
        FileWriter fw = new FileWriter(f2, true); 
        
        //   fr.open();
        
        function = "";
        operator = "";
        word1 = "";
        word2 = "";
        codeLine = "";
        codeLine = br.readLine();
        
        // code = "var x = 22;";
        
        while(codeLine != null)
        {        
            if(codeLine.charAt((codeLine.length() - 1)) == ';') 
            {
                codeLine = codeLine.substring(0, (codeLine.length() - 1));
                codeLine += " ";
                
                i = 0;
            
                if(i < codeLine.length() 
                		&& error == false) 
                {
                    while(codeLine.charAt(i) == ' ')
                    {
                        i++;
                        
                        if(i >= codeLine.length()) 
                        {
                            error = true;
                        
                            break;
                        }
                    }
                }
                
                j = i;
                
                if(j < codeLine.length() 
                		&& error == false)
                {
                    while(codeLine.charAt(j) != ' ')
                    {
                        j++;
                    
                        if(j >= codeLine.length())
                        {
                            error = true;
                        
                            break;
                        }
                    }
                }
                
                function = codeLine.substring(i, j); //Acquisizione della funzione (primo termine) completata           
                i = j;
                ncom = 0;
                
                while(ncom < 11 
                		&& (!function.equals(command[ncom]))) 
                {
                    ncom++;
                }
                
                switch(ncom) 
                {
                    case 11:
                        error = true;
                        
                        System.out.println(
                        		"Funzione non presente nel database!");
                    
                        break;
                
                    case 0: // var
                        if(i < codeLine.length() 
                        		&& error == false) 
                        {
                            while(codeLine.charAt(i) == ' ')
                            {
                                i++;
                            
                                if(i >= codeLine.length()) 
                                {
                                    error = true;
                                
                                    break;
                                }
                            }
                        }
                        
                        j = i;
                        
                        if(j < codeLine.length() 
                        		&& error == false)
                        {
                            while(codeLine.charAt(j) != ' ' 
                            		&& codeLine.charAt(j) != '=')
                            {
                                j++;
                            
                                if(j >= codeLine.length()) 
                                {
                                    error = true;
                                
                                    break;
                                }
                            }
                        }
                        
                        word1 = codeLine.substring(i, j);
                        c = 0;
                        
                        for(int x = 0; x < word1.length(); x++) 
                        {
                            for(int y = 0; y < 62; y++) 
                            {
                                if(word1.charAt(x) == alphabet[y]) 
                                {
                                    c++;
                                }
                            }
                        }
                        
                        if(c != word1.length()) 
                        {
                            System.out.print(
                            		"Errore! Per il nome della variabile sono stati utilizzati dei caratteri non riconosciuti");
                        
                            error = true;
                        }
                        
                        if(error == false)
                        {
                            i = j;
                        
                            if(i < codeLine.length()) 
                            {
                                while(codeLine.charAt(i) == ' ')
                                {
                                    i++;
                                
                                    if(i >= codeLine.length()) 
                                    {
                                        error = true;
                                    
                                        break;
                                    }
                                }
                            }
                            
                            j = i;
                            
                            if(j < codeLine.length() 
                            		&& error == false)
                            {
                                while(codeLine.charAt(j) == '=')
                                {
                                    j++;
                                
                                    if(j >= codeLine.length()) 
                                    {
                                        error = true;
                                    
                                        break;
                                    }
                                }
                            }
                            
                            operator = codeLine.substring(i, j);
                        }
                        
                        if(error == false)
                        {
                            i = j;
                        
                            if(i < codeLine.length()) 
                            {
                                while(codeLine.charAt(i) == ' ')
                                {
                                    i++;
                                
                                    if(i >= codeLine.length()) 
                                    {
                                        error = true;
                                    
                                        break;
                                    }
                                }
                            }
                            
                            j = i;
                            
                            if(j < codeLine.length() 
                            		&& error == false) 
                            {
                                while(codeLine.charAt(j) != ' ')
                                {
                                    j++;
                                
                                    if(j >= codeLine.length())
                                    {
                                        error = true;
                                    
                                        break;
                                    }
                                }
                            }
                            
                            word2 = codeLine.substring(i, j);
                            
                            if(j < codeLine.length() 
                            		&& error == false) 
                            {
                                while((j < (codeLine.length() - 1)))
                                {
                                    j++;
                                
                                    if(codeLine.charAt(j) != ' ') 
                                    {
                                        error = true;
                                    
                                        break;
                                    }
                                }
                            }
                            
                            if(error == false) 
                            {
                                c = 0;
                            
                                for(int x = 0; x < word2.length(); x++)
                                {
                                    for(int y = 52; y < 62; y++) 
                                    {
                                        if(word2.charAt(x) == alphabet[y]) 
                                        {
                                            c++;
                                        }
                                    }
                                }
                                
                                if((bin.indexOf(word1)) != -1) 
                                {
                                    error = true;
                                
                                    System.out.println(
                                    		"Errore! Variabile già dichiarata.");
                                }
                                
                                else
                                {
                                    bin += word1 + " ";
                                }
                            }
                            
                            if(error == false) 
                            {
                                if(c == word2.length()) 
                                {
                                    // "int " + word1 + " = " + word2; 
                                    
                                    write = "";
                                    
                                    write = "int " + word1 + " = " + word2 + ";";
                                    fw.write(write);
                                    fw.write("\n");
                                
                                    System.out.println("int");
                                }
                                
                                else if((c == (word2.length() - 1)) 
                                		&& (word2.indexOf('.') > 0)) 
                                {
                                    // "float " + word1 + " = " + word2;
                                    
                                    write = "";
                                    
                                    write = "float " + word1 + " = " + word2 + ";";
                                    
                                    fw.write(write);
                                    fw.write("\n");
                                    
                                    System.out.println("float");
                                }
                                
                                else if(word2.equals("true") 
                                		|| word2.equals("false")) 
                                {
                                    // "boolean " + word1 + " = " + word2; 
                                    
                                    write = "";
                                    
                                    write = "boolean " + word1 + " = " + word2 + ";";
                                    
                                    fw.write(write);
                                    fw.write("\n");
                                    
                                    System.out.println("bool");
                                }
                                
                                else if((word2.charAt(0) == '"') 
                                		&& (word2.charAt((word2.length() - 1)) == '"')) 
                                {
                                    // "String " + word1 + " = " + word2; 
                                    
                                    write = "";
                                    
                                    write = "String " + word1 + " = " + word2 + ";";
                                    
                                    fw.write(write);
                                    fw.write("\n");
                                    
                                    System.out.println("string");
                                }
                                
                                else 
                                {
                                    error = true;
                                }
                            }
                        }
                    
                    break; 
                    
                    case 1: // input
                        if(i < codeLine.length() 
                        		&& error == false) 
                        {
                            while(codeLine.charAt(i) == ' ')
                            {
                                i++;
                                
                                if(i >= codeLine.length())
                                {
                                    error = true;
                                
                                    break;
                                }
                            }
                        }
                        
                        j = i;
                        
                        if(j < codeLine.length() 
                        		&& error == false)
                        {
                            while(codeLine.charAt(j) != ' ')
                            {
                                j++;
                            
                                if(j >= codeLine.length())
                                {
                                    error = true;
                                
                                    break;
                                }
                            }
                        }
                        
                        word1 = codeLine.substring(i, j);
                        
                        while(j < (codeLine.length() - 1))
                        {
                            j++;
                        
                            if(codeLine.charAt(j) != ' ') 
                            {
                                error = true;
                            
                                break;
                            }
                        }
                        
                        if((bin.indexOf(word1)) == -1) 
                        {
                            error = true;
                        
                            System.out.println(
                            		"Errore! Variabile non dichiarata.");
                        }
                        
                        if(error == false) 
                        {
                            System.out.println("input: " + word1); 
                            
                            write = "";
                            
                            write = "Scanner x = new Scanner(System.in); String s; s = x.nextLine();";
                            
                            fw.write(write);
                            fw.write("\n");
                        
                            // Inserisci nel file le istruzioni di acquisizione di ciò che è contenuto in word1
                        }
                    
                        break;
                        
                    case 2: // println
                        if(i < codeLine.length() 
                        		&& error == false) 
                        {
                            while(codeLine.charAt(i) == ' ')
                            {
                                i++;
                            
                                if(i >= codeLine.length())
                                {
                                    error = true;
                                
                                    break;
                                }
                            }
                        }
                        
                        j = i;
                        
                        if(j < codeLine.length() 
                        		&& error == false)
                        {
                            while(codeLine.charAt(j) != ' ')
                            {
                                j++;
                            
                                if(j >= codeLine.length()) 
                                {
                                    error = true;
                                
                                    break;
                                }
                            }
                        }
                        
                        word1 = codeLine.substring(i, j);
                        
                        while(j < (codeLine.length() - 1))
                        {
                            j++;
                        
                            if(codeLine.charAt(j) != ' ')
                            {
                                error = true;
                            
                                break;
                            }
                        }
                        
                        if((bin.indexOf(word1)) == -1)
                        {
                            error = true;
                        
                            System.out.println(
                            		"Errore! Variabile non dichiarata.");
                        }
                        
                        if(error == false) 
                        {
                            System.out.println(
                            		"println: " + word1);
                            
                            write = "";
                            
                            write = "System.out.println(word1);";
                            
                            fw.write(write);
                            fw.write("\n");
                        
                            // Inserisci nel file le istruzioni di stampa di ciò che è contenuto in word1
                        }
                    
                        break;
                        
                    case 10: //end
                        nend--;
                        
                        while(j < (codeLine.length() - 1))
                        {
                            j++;
                                
                            if(codeLine.charAt(j) != ' ') 
                            {
                                error = true;
                             
                                break;
                            }
                        }
                        
                        if(error == false) 
                        {
                            System.out.println("}");
                            
                            write = "";
                            
                            write = "}";
                            
                            fw.write(write);
                            fw.write("\n");
                            
                            // Inserisci nel file una parentesi graffa chiusa
                        }
                        
                        break;  
                }
            }
            
            else if((codeLine.indexOf("main") != -1) 
            		|| (codeLine.indexOf("if") != -1) 
            		|| (codeLine.indexOf("elif") != -1) 
            		|| (codeLine.indexOf("else") != -1) 
            		|| (codeLine.indexOf("for") != -1) 
            		|| (codeLine.indexOf("while") != -1) 
            		|| (codeLine.indexOf("*") != -1) 
            		|| (codeLine.indexOf("do_while") != -1)) 
            {
                i = 0;
                   
                if(i < codeLine.length() 
                		&& error == false) 
                {
                    while(codeLine.charAt(i) == ' ')
                    {
                        i++;
                            
                        if(i >= codeLine.length())
                        {
                            error = true;
                            
                            break;
                        }
                    }
                }
                
                j = i;
                
                if(j < codeLine.length() 
                		&& error == false) 
                {
                    while(codeLine.charAt(j) != ' ')
                    {
                        j++;
                    
                        if(j >= codeLine.length())
                        {
                            error = true;
                        
                            break;
                        }
                    }
                }
                
                function = codeLine.substring(i, j); //Acquisizione della funzione (primo termine) completata           
                i = j;
                ncom = 0;
                
                while(ncom < 11 
                		&& (!function.equals(command[ncom]))) 
                {
                    ncom++;
                }
                
                switch(ncom) 
                {
                    case 3:
                        nend++;
                        
                        while(j < (codeLine.length() - 1))
                        {
                            j++;
                        
                            if(codeLine.charAt(j) != ' ') 
                            {
                                error = true;
                            
                                break;
                            }
                        }
                        
                        if(error == false) 
                        {
                            System.out.println("main");
                            
                            write = "";
                            
                            write = "public static void main(){";
                            
                            fw.write(write);
                            fw.write("\n");
                        }
                    
                        break;
                    
                    case 4:
                        nend++;
                        
                        if(i < codeLine.length() 
                        		&& error == false)
                        {
                            while(codeLine.charAt(i) == ' ')
                            {
                                i++;
                            
                                if(i >= codeLine.length())
                                {
                                    error = true;
                                
                                    break;
                                }
                            }
                        }
                        
                        j = i;
                        
                        if(j < codeLine.length() 
                        		&& error == false) 
                        {
                            while(codeLine.charAt(j) != ' ' 
                            		&& codeLine.charAt(j) != '=')
                            {
                                j++;
                            
                                if(j >= codeLine.length())
                                {
                                    error = true;
                                
                                    break;
                                }
                            }
                        }
                        
                        word1 = codeLine.substring(i, j);
                        
                        if((bin.indexOf(word1)) == -1) 
                        {
                            error = true;
                        
                            System.out.println(
                            		"Errore! Variabile non dichiarata.");
                        }
                        
                        if(error == false)
                        {
                            i = j;
                        
                            if(i < codeLine.length())
                            {
                                while(codeLine.charAt(i) == ' ')
                                {
                                    i++;
                                
                                    if(i >= codeLine.length())
                                    {
                                        error = true;
                                    
                                        break;
                                    }
                                }
                            }
                            
                            j = i;
                            
                            if(j < codeLine.length() 
                            		&& error == false)
                            {
                                while(codeLine.charAt(j) == '>' 
                                		|| codeLine.charAt(j) == '<' 
                                		|| codeLine.charAt(j) == '=') 
                                {
                                    j++;
                                
                                    if(j >= codeLine.length()) 
                                    {
                                        error = true;
                                    
                                        break;
                                    }
                                }
                            }
                            
                            operator = codeLine.substring(i, j);
                        }
                        
                        if(error == false) 
                        {
                            i = j;
                         
                            if(i < codeLine.length() 
                            		&& error == false) 
                            {
                                while(codeLine.charAt(i) == ' ')
                                {
                                    i++;
                                
                                    if(i >= codeLine.length()) 
                                    {
                                        error = true;
                                    
                                        break;
                                    }
                                }
                            }
                            
                            j = i;
                            
                            if(j < codeLine.length() 
                            		&& error == false) 
                            {
                                while(codeLine.charAt(j) != ' ' 
                                		&& codeLine.charAt(j) != '=')
                                {
                                    j++;
                                
                                    if(j >= codeLine.length()) 
                                    {
                                        error = true;
                                    
                                        break;
                                    }
                                }
                            }
                            
                            word2 = codeLine.substring(i, j);
                            
                            if((bin.indexOf(word2)) == -1)
                            {
                                error = true;
                            
                                System.out.println(
                                		"Errore! Variabile non dichiarata.");
                            }
                            
                            while(j < (codeLine.length() - 1))
                            {
                                j++;
                            
                                if(codeLine.charAt(j) != ' ') 
                                {
                                    error = true;
                                
                                    break;
                                }
                            }
                            
                            if(error == false) 
                            {
                                System.out.println("if"); 
                                
                                write = "";
                                
                                write = "if (" + word1 + operator + word2 + ")";
                                
                                fw.write(write);
                                fw.write("\n");
                                // Inserisci nel file una condizione composta da word1 + operator + word2
                            }
                    
                            break;
                        
                            /* 5:
                                break;
                                
                            case 6:
                                break;
                                
                            case 7:
                                break;
                                
                            case 8:
                                break;
                                
                            case 9:
                                break;*/  
                        }
                }
            
                System.out.println("Errore: " + error);
        
                if(nend > 0) 
                {
                    System.out.println(
                    		"Bisogna chiudere alcune funzioni");
                }
            
                else if(nend < 0) 
                {
                    System.out.println(
                    		"Troppe funzioni chiuse");
                }
            }
            
            else
            {
                System.out.println(
                		"Errore! Terminare la stringa con un ';'");
            }
        
            codeLine = "";
            codeLine = br.readLine();
            // code=read;
        }
        
        fw.close();
        fr.close();
    }
}