package com.nearsoft.academy.ledger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.nearsoft.academy.ledger.Entity.Transaction;

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
        getInfo();
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

    public void getInfo() throws IOException {
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

    public void getInfoToStructure() throws IOException {
        String nextFile=null;
        Transaction transaction = new Transaction();
        for(int i=0; i<pathFiles.size(); i++){
            nextFile = pathFiles.get(i).split(" ")[1];
            FileReader fr = new FileReader("../resources/"+nextFile);
            BufferedReader br = new BufferedReader(fr);
            String actualLine;
            while ((actualLine = br.readLine()) != null){
                if(!actualLine.contains(";") && actualLine.contains("/")){
                    transaction.setAccount(actualLine.split(" ")[0]);
                }
            }
            br.close();
            fr.close();
            System.out.println("Transactions"+transaction.getAccount());
        }
    }
}
