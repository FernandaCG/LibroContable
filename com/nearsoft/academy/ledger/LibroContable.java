package com.nearsoft.academy.ledger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nearsoft.academy.ledger.util.RegularExpression;
import com.nearsoft.academy.ledger.entity.Transaction;
import com.nearsoft.academy.ledger.entity.Account;

public class LibroContable {

    List<String> pathFiles = new ArrayList<>();
    List<Transaction> Operations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        LibroContable libroContable = new LibroContable();
        //libroContable.printCommand();
        libroContable.getInfoToStructure();
    }

    public LibroContable() throws IOException {
        initFiles();
    }

    public List<String> getPaths(){
        return pathFiles;
    }

    public void printCommand() throws IOException {
        String nextFile=null;
        for(int i=0; i<pathFiles.size(); i++){
            nextFile = pathFiles.get(i).split(" ")[1];
            FileReader fr = new FileReader("../resources/"+nextFile);
            BufferedReader br = new BufferedReader(fr);
            String actualLine;
            while ((actualLine = br.readLine()) != null){
                if(!actualLine.contains(";")){
                    System.out.println(actualLine);
                }
            }
            br.close();
            fr.close();
        }
    }

    public void initFiles() throws IOException {
        //Leer del argumento de linea de comando -f
        FileReader fr = new FileReader("../resources/index.ledger");
        BufferedReader br = new BufferedReader(fr);
        String actualLine;
        while ((actualLine = br.readLine()) != null){
            pathFiles.add(actualLine);
        }
        br.close();
        fr.close();
    }

    public void getInfoToStructure() throws IOException {
        String nextFile=null;
        Pattern patternDate;
        Matcher matcher;
        Account[] accounts = new Account[2];
        for(int i=0; i<pathFiles.size(); i++){
            nextFile = pathFiles.get(i).split(" ")[1];
            FileReader fr = new FileReader("../resources/"+nextFile);
            BufferedReader br = new BufferedReader(fr);
            String actualLine;

            while ((actualLine = br.readLine()) != null){
                patternDate = Pattern.compile(RegularExpression.DATE);
                matcher = patternDate.matcher(actualLine);
                if(matcher.find()){
                    Transaction transaction = new Transaction();
                    transaction.setDate(actualLine.substring(matcher.start(), matcher.end()));
                    transaction.setDescription(actualLine.substring(matcher.end()+1));

                    actualLine = br.readLine();
                    patternDate = Pattern.compile(RegularExpression.ACC2);
                    matcher = patternDate.matcher(actualLine);
                    matcher.find();
                    String cuenta = actualLine.substring(matcher.start(), matcher.end());
                    Account ac = new Account();
                    ac.setAccount(cuenta.split(":")[0]);
                    ac.setSubaccount(cuenta.substring(ac.getAccount().length()+1));
                    patternDate = Pattern.compile(RegularExpression.AMMOUNT);
                    matcher = patternDate.matcher(actualLine);
                    matcher.find();
                    //Double a=0.0;
                    System.out.println("Patron: "+actualLine.substring(matcher.start(), matcher.end()));
                    ac.setAmount(actualLine.substring(matcher.start(), matcher.end()));
                    accounts[0] = ac;

                    actualLine = br.readLine();
                    patternDate = Pattern.compile(RegularExpression.ACC2);
                    matcher = patternDate.matcher(actualLine);
                    matcher.find();
                    String cuenta2 = actualLine.substring(matcher.start(), matcher.end());
                    Account ac1 = new Account();
                    ac1.setAccount(cuenta2.split(":")[0]);
                    ac1.setSubaccount(cuenta2.substring(ac1.getAccount().length()+1));
                    patternDate = Pattern.compile(RegularExpression.AMMOUNT);
                    matcher = patternDate.matcher(actualLine);
                    if(matcher.find()){
                        ac1.setAmount(actualLine.substring(matcher.start(), matcher.end()));
                    }
                    accounts[1] = ac1;
                    transaction.setAccounts(accounts);
                    Operations.add(transaction);
                }
            }
            System.out.println("Operations:\n"+Operations);
            br.close();
            fr.close();
        }

    }
}
