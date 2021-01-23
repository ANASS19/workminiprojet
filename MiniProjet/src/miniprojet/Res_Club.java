/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;
import java.sql.*;
public class Res_Club {
    //atrribut connection
    Connection con;
    Statement ps;
    //atribut activite
    String club;
    String cin;
    String nom;
    String prenom ;
    double login;
    double mot_de_pass;
    //atribut login
    String Act_name;
    String dat_demd;
    String dat_end;
    //atribue login
    
    public Res_Club(){
        try{
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
            ps=con.createStatement();}catch(Exception e){ System.out.println(e);}  
    }
    
    public void Login(int login,int mot_de_pass){
        try{
        ResultSet rs=ps.executeQuery("select "+login+","+mot_de_pass+"  from responsable_de_club where login="+login+" and mot_de_pass="+mot_de_pass+" ");
        System.out.println("successful !");
        }catch(Exception e){ System.out.println(e);}
    }
    public void Affiche(){
        try{
        ResultSet rs=ps.executeQuery("select * from activite where statut is null");
        while(rs.next()){
            System.out.println(rs.getString("club")+"|"+rs.getString("activite")+"|"+rs.getString("date_start")+rs.getString("date_end")+"|"+rs.getString("type_act")+"|"+rs.getString("statut"));
        }
        }catch(Exception e){ System.out.println(e);}
    }
    public void Demande(String Act_name,String dat_demd,String dat_end,String club){
        try{
        ResultSet rs=ps.executeQuery("insert into activite values("+"'"+Act_name+"',"+"'"+dat_demd+"',"+"'"+dat_end+"',"+"'"+club+"')");
        }catch(Exception e){ System.out.println(e);}
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Res_Club resC=new Res_Club();
        resC.Login(2222,2222);
        resC.Affiche();
        
    }
}
