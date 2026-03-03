package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    public void startGrocery(){

        int choice;

        do{
            System.out.println("Yapılmasını istediğiniz işlemi seçin: (0 = Çıkış , 1 = Ekleme ,2 = Çıkarma)");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;
                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
            }
        }while (choice != 0);

        //Scanner ı kapatıyoruz.
        scanner.close();
    }

    public static void addItems(String itemstoAdd){
        String [] splitItems = itemstoAdd.split(",");
        for(String item : splitItems){
            item = item.trim();
            if(checkItemIsInList(item)){
                System.out.println("Girilen ürün listede mevcut: " + item);
            }else{
                groceryList.add(item);
            }
        }
        sortItems();
    }

    public static void removeItems(String itemsToRemove){
        String [] splitItems = itemsToRemove.split(",");
        for(String item : splitItems){
            item = item.trim();

            if(!checkItemIsInList(item)){
                System.out.println("Girilen ürün listede mevcut değil: " + item);
            }else{
                groceryList.remove(item);
            }
        }
        sortItems();
    }

    public static boolean checkItemIsInList(String item){
        return groceryList.contains(item);
    }

    public static void printSorted(){
        sortItems();
        System.out.println("Mevcut pazar listesi: ");
        for(String item : groceryList){
            System.out.println(item);
        }
    }

    public   static  void sortItems(){
        Collections.sort(groceryList);
    }
}
