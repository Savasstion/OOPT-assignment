public class Staff {
     private String loginID;
     private String password;
     
     public Staff(String loginID, String password){
          this.loginID = loginID;
          this.password = password;             
     }
     
     public boolean login(String inloginid ,String inpsw){
         return loginID.equals(inloginid) && password.equals(inpsw);
     }
}
