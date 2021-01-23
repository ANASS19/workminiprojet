/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

import java.sql.*;

/**
 *
 * @author JAD
 */
public class Res_para {
    //atrribut connection
    Connection con;
    Statement ps;
    //atribue class
    String cin;
    String nom;
    String prenom ;
    double login;
    double mot_de_pass;
    
    public Res_para(){
        try{
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
            ps=con.createStatement();}catch(Exception e){ System.out.println(e);}  
    }
    
    
    public void Login(double login,double mot_de_pass){
        try{
        ResultSet rs=ps.executeQuery("select "+login+","+mot_de_pass+"  from responsable_de_club where login="+login+" and mot_de_pass="+mot_de_pass+" ");
        }catch(Exception e){ System.out.println(e);}
    
    }
    public void Affichetous(){
    try{
        ResultSet rs=ps.executeQuery("select * from activite");
        while(rs.next()){
            System.out.println(rs.getString("club")+"|"+rs.getString("activite")+"|"+rs.getString("date_start")+rs.getString("date_end")+"|"+rs.getString("type_act")+"|"+rs.getString("statut"));
        }
        }catch(Exception e){ System.out.println(e);}}
    public void Affichelistdatente(){
        try{
        ResultSet rs=ps.executeQuery("select  club,activite,date_start,date_end,type_act,statut from activite where statut='En Attente'");
        while(rs.next()){
            System.out.println(rs.getString("club")+"|"+rs.getString("activite")+"|"+rs.getString("date_start")+rs.getString("date_end")+"|"+rs.getString("type_act")+"|"+rs.getString("statut"));
        }
        }catch(Exception e){ System.out.println(e);}}
    public void Validee(String activite){
        try{
            if(activite=="En Attente"){
            ResultSet rs=ps.executeQuery("update activite set statut='VALIDE' where activite='"+activite+"");}
            else{
                ResultSet rs=ps.executeQuery("update activite set statut='NON VALIDE' where activite='"+activite+"'");
            }
            //lie avec graphique
            }catch(Exception e){ System.out.println(e);}
    }       
    public static void main(String[] args) {
        // TODO code application logic here
        Res_para res=new Res_para();
        res.Login(1111,1111);
        res.Affichetous();
        res.Affichelistdatente();
        //res.validee(); 5assek bel graphique trage3 nom de demand li raykon activite
        String activite="En Attente";
        res.Validee(activite);
        
        
    }
    
}
