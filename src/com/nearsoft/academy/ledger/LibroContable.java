package com.nearsoft.academy.ledger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibroContable {

    List<String> pathFiles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        LibroContable libroContable = new LibroContable();
        libroContable.getInfo();
    }

    public LibroContable() throws IOException {
        initFiles();
    }

    public List<String> getPaths(){
        return pathFiles;
    }

    public void initFiles() throws IOException {
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
        System.out.println(pathFiles.size());
        for(int i=0; i<pathFiles.size(); i++){
            nextFile = pathFiles.get(i).split(" ")[1];
            FileReader fr = new FileReader("../resources/"+nextFile);
            BufferedReader br = new BufferedReader(fr);
            String actualLine;
            while ((actualLine = br.readLine()) != null){
                System.out.println(actualLine);
            }
            br.close();
            fr.close();
        }
    }
}
