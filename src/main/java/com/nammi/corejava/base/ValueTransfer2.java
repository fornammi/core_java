package com.nammi.corejava.base;

class Demo{  
    int a;  
    public Demo(int a){  
        this.a=a;  
    }  
}  
public class ValueTransfer2{  
    public static void main(String args[]){  
        Demo d1=new Demo(1);  
        Demo d2=new Demo(2);  
        System.out.println("before funcion: d1.a is "+d1.a);  
        System.out.println("before funcion: d2.a is "+d2.a);  
        function(d1,d2);  
        System.out.println("after funcion: d1.a is "+d1.a);  
        System.out.println("after funcion: d2.a is "+d2.a);  
    }
    
    /*private static void function(Demo d1,Demo d2){  
        int a;  
        a = d1.a;  
        d1.a = d2.a;  
        d2.a = a;  
    }*/
    
    private static void function(Demo d1,Demo d2){
        Demo temp;
        temp = d1;
        d1 = d2;
        d2 = temp;
    }
}