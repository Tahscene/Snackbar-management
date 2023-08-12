
package dao;

import javax.swing.JOptionPane;


public class Tables {
    
          public static void main(String[] args) {
        try{
            
           String userTable= "create table user(id int AUTO_INCREMENT primary key, name varchar(200), email varchar(200), mobileNo varchar(10), address varchar(200),password varchar(200), question varchar(200), answer varchar(200),status varchar(20), UNIQUE(email))"; 
            String adminDetails= "insert into user(name, email,MobileNo, address,password, question,answer,status) values('Admin', 'admin@gmail.com', '1234567890', 'Bean Haven', 'admin','Where is the snackbar located?', 'Dhanmondi', 'true' )"; 
            String categoryTable= "create table category(id int AUTO_INCREMENT primary key, name varchar(200))";
             String productTable= "create table product(id int AUTO_INCREMENT primary key, name varchar(200), category varchar(200), price varchar(200))";
              String billTable= "create table bill(id int primary key, name varchar(200),mobileNo varchar(10), email varchar(200),date varchar(50), total varchar(200), createdBy varchar(200) )";
             
        
           Operations.setDataOrDelete(userTable, "User Table Created Successfully !");
           Operations.setDataOrDelete(adminDetails, "Admin Details Added Successfully !");
           Operations.setDataOrDelete(categoryTable, "Category Table Created Successfully !");
           Operations.setDataOrDelete(productTable, "Product Table Created Successfully !");
           Operations.setDataOrDelete(billTable, "Bill Table created successfully !");
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,  e);
        }
    }   
}
