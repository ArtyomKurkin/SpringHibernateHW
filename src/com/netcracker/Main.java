package com.netcracker;

import com.netcracker.config.SpringConfig;
import com.netcracker.service.BookService;
import com.netcracker.service.CustomerService;
import com.netcracker.service.PurchaseService;
import com.netcracker.service.ShopService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;



public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        BookService service1 = (BookService) context.getBean("bookService");
        CustomerService service2 = (CustomerService) context.getBean("customerService");
        ShopService service3 = (ShopService) context.getBean("shopService");
        PurchaseService service4 = (PurchaseService) context.getBean("purchaseService");
        secondTask(service1,service2,service4);
        thirdTask(service1,service2,service3);
        fourthTask(service4);
        fifthTask(service1,service2,service3,service4);

    }


    private static void secondTask(BookService service1, CustomerService service2, PurchaseService service3){
        System.out.println("The second task:");
        System.out.println("A:");
        System.out.println("All titles:");
        System.out.println(service1.getAllTitle());
        System.out.println("All costs:");
        System.out.println(service1.getAllCost());
        System.out.println("B, all districts:");
        System.out.println(service2.getAllDist());
        System.out.println("C, all months");
        System.out.println(service3.getAllMonths());
        System.out.println("_____________________");
    }

    private static void thirdTask(BookService service1, CustomerService service2, ShopService service3){
        System.out.println("The third task:");
        System.out.println("A");
        System.out.println(service2.getCustomFromNizh());
        System.out.println("B");
        System.out.println(service3.getShopFromSormAndSov());
        System.out.println("C");
        System.out.println(service1.getSpecialBook());
        System.out.println("_____________________");
    }

    private static void fourthTask(PurchaseService service1){
        System.out.println("The fourth task:");
        System.out.println("A");
        System.out.println(service1.getInfo());
        System.out.println("B");
        System.out.println(service1.getFullInfo());
        System.out.println("_____________________");
    }

    private static void fifthTask(BookService service1, CustomerService service2, ShopService service3, PurchaseService service4){
        System.out.println("The fifth task:");
        System.out.println("A");
        System.out.println(service4.getTopPurchases());
        System.out.println("B");
        System.out.println(service4.getLatePurchases());
        System.out.println("C");
        System.out.println(service4.getSpecialShops());
        System.out.println("D ");
        System.out.println(service4.getSpecialPurchases());

        System.out.println("_____________________");
    }


}
