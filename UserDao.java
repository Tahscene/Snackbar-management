
package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    public static void save(User user){
        String Query= "insert into user(name,email, mobileNo ,address, password, question, answer, status) values('"+ user.getName()+"','"+ user.getEmail()+"','"+ user.getNo()+"','"+ user.getAdd()+"','"+ user.getPass()+"','"+ user.getQues()+"','"+ user.getAns()+"','false')";
        Operations.setDataOrDelete(Query, "Registered Successfully ! Wait for Admin Approval :)");
       
    }
    public static User login(String email, String password)
    {
        User user=null;
        try{
        ResultSet rs= Operations.getData("select *from user where email= '"+email+"' and password= '"+password+"'");
        while(rs.next()){
            user= new User();
            user.setStatus(rs.getString("status"));
        }
}
   catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
   } 
       return user;
}
   
    
   public static ArrayList<User> getAllRecords(String email){
       ArrayList<User> arrayList= new ArrayList<>();
       try{
       ResultSet rs=Operations.getData("select *from user where email like '%"+ email+ "%'");
       while(rs.next()){
           User user = new User();
             user.setId(rs.getInt("id"));
             user.setName(rs.getString("name"));
             user.setEmail(rs.getString("email"));
             user.setAdd(rs.getString("address"));
             user.setNo(rs.getString("mobileNo"));
            user.setStatus(rs.getString("status"));
            user.setQues(rs.getString("question"));
             arrayList.add(user);
           
       }
       }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
       return arrayList;
       
   }
    public static void changeStat(String email, String status){
        String query= "update user set status='"+status+"'where email='"+email+"'";
        Operations.setDataOrDelete(query,"Status Changed Successfully");
}
   public static User getSecurityQues(String email)
    {
        User user=null;
        try{
        ResultSet rs= Operations.getData("select *from user where email= '"+email+"'");
        while(rs.next()){
            user= new User();
            user.setQues(rs.getString("question"));
            user.setAns(rs.getString("answer"));
        }
        
}
    catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
   } 
        return user;
} 
  public static void update(String email, String password){
        String query= "update user set password= '"+password+"' where email='"+email+"'";
        Operations.setDataOrDelete(query,"Password Updated Successfully");
}   
    public static void changeSecurityQuestion(String email,String password, String question,String answer){
        try{
            ResultSet rs=Operations.getData("select *from user where email='"+email+"' and password='"+password+"'");
            if(rs.next()){
                update(email, question,answer);
            }
            else{
                JOptionPane.showMessageDialog(null,"Password is Wrong");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            
    }
    public static void update(String email,String question,String answer){
        String query = "update user set question='"+question+"',answer='"+answer+"'where email='"+email+"'";
        Operations.setDataOrDelete(query,"Security Question Changed Successfully");
    }
     public static void changePassword(String email,String oldPassword,String newPassword){
      try{
          ResultSet rs =Operations.getData("select *from user where email='"+email+"' and password='"+oldPassword+"'");
          if(rs.next()){
              update(email,newPassword);
          }
          else{
              JOptionPane.showMessageDialog(null,"Old Password is Wrong");
          }
      }   
      catch(Exception e){
          JOptionPane.showMessageDialog(null,e);
      }
    
     } 
    
    
}