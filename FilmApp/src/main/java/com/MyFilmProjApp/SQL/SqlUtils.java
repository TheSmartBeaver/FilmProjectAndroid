package com.MyFilmProjApp.SQL;

import com.gluonhq.charm.down.Platform;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.*;
//import com.mysql.jdbc.Driver;

public class SqlUtils {

    private int lport;
    private String rhost;
    private int rport;

    private void SqlUtilsDriver(){
        try {
            Class c = null;
            if (Platform.isAndroid()) {
                c = Class.forName("org.sqldroid.SQLDroidDriver");
            } else if (Platform.isIOS()) {
                c = Class.forName("SQLite.JDBCDriver");
            } else if (Platform.isDesktop()) {
                c = Class.forName("org.sqlite.JDBC");
            } else if (System.getProperty("os.arch").toUpperCase().contains("ARM")) {
                c = Class.forName("org.sqlite.JDBC");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error class not found " + e);
        }
    }

    private Session connect() {
        String host = "51.38.69.145";
        int port = 62322;
        String user = "victor";
        String password = "rotciv";


        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            lport = 3306;
            rhost = "localhost";
            rport = 63306;
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            int assinged_port = session.setPortForwardingL(lport, rhost, rport);
            System.out.println("localhost:" + assinged_port + " -> " + rhost + ":" + rport);
            return session;
        } catch (Exception e) {
            System.err.print(e);
        }
        System.out.println("ECHEC CONNEXION !!!!");
        return null;
    }

    /**
     * Permet à un utilisateur de s'inscrire
     * @param  identif
     * @param password
     * @param mail
     * @param gender Utiliser String de constante
     * @param age Utiliser String de constante
     * @param job Utiliser String de constante
     */
    public void signIn(String identif, String password, String mail, String gender, String age, String job){
        Session ses = connect();
        Connection con = connectDB();
        String requete = "INSERT INTO account VALUES (\""+identif+"\",\""+password+"\",\""+mail+"\",\""+gender+"\",\""+age+"\",\""+job+"\")";

        String reqIdentif = "SELECT username FROM account WHERE username = \""+identif+"\"";
        String reqMail = "SELECT email FROM account WHERE email = \""+mail+"\"";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(reqIdentif);
        ResultSet rset = ps.executeQuery();
        if(rset.next()) {
            System.out.println("Username déjà pris !");
            return ;
        }
            ps = con.prepareStatement(reqMail);
            rset = ps.executeQuery();
            if(rset.next()) {
                System.out.println("Mail déjà pris !");
                return ;
            }

            Statement stmt = con.createStatement();
            int nbMaj = stmt.executeUpdate(requete);
            System.out.println("nbMaj :"+nbMaj);
        con.close(); ses.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * Permet à un utilisateur inscrit de se loguer
     * @param identif Pseudo utilisateur
     * @param password mdp utilisateur
     * @return true si authentification succès, false sinon
     */
    public boolean logIn(String identif, String password){
        Session ses = connect();
        Connection con = connectDB();
        String reqIdentif = "SELECT password FROM account WHERE username = \""+identif+"\"";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(reqIdentif);
            ResultSet rset = ps.executeQuery();
            if(rset.next()) {
                if(rset.getString("password").equals(password)) {
                    System.out.println("Login Succès !!");
                    return true;
                }
                else {
                    System.out.println("Login Echec !!");
                    return false;
                }
            }
                else
                System.out.println("Utilisateur inconnu");
            con.close(); ses.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Retourne un Objet Connection qui va permettre de communiquer avec la DB MySql
     * @return connexion à la DB
     */
    private Connection connectDB() {
        Connection con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://" + rhost + ":" + lport + "/";

        String db = "movieWebsite";
        String dbUser = "victor";
        String dbPasswd = "DBrotciv";

        try {
            //Class.forName(driver);
            SqlUtilsDriver();
            con = DriverManager.getConnection(url + db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", dbUser, dbPasswd);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
