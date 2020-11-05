/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author YXTing
 */
public class Database {
    public void initialise() throws SQLException {
        //write the four lines which connect your program to the database
        Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement st = conn.createStatement();
        String createUsersQuery = "CREATE TABLE IF NOT EXISTS Users "
                + "("
                + "ID INTEGER PRIMARY KEY autoincrement, "
                + "USERNAME TEXT NOT NULL, "
                + "PASSWORD TEXT NOT NULL "
                + ");";
        st.execute(createUsersQuery);
        
        String insertUser1 = "INSERT OR IGNORE INTO Users (ID, USERNAME, PASSWORD) "
                          + "VALUES (1, 'Pretentious', 'Hipster');";
        st.execute(insertUser1);
        String insertUser2 = "INSERT OR IGNORE INTO Users (ID, USERNAME, PASSWORD) "
                          + "VALUES (2, 'P', 'H');";
        st.execute(insertUser2);
                
        String createTracksQuery = "CREATE TABLE IF NOT EXISTS Tracks "
                + "("
                + "ID INTEGER PRIMARY KEY autoincrement, "
                + "TRACK TEXT NOT NULL, "
                + "ARTIST TEXT NOT NULL, "
                + "ALBUM TEXT NOT NULL, "
                + "GENRE TEXT NOT NULL "
                + ");";
        st.execute(createTracksQuery);
        
        String insertTrack1 = "INSERT OR IGNORE INTO Tracks (ID, TRACK, ARTIST, ALBUM, GENRE) "
                            + "VALUES (1, 'Glacier', 'DJ ABC', 'Frozen Chimps', 'EDM');";
        st.execute(insertTrack1);
        String insertTrack2 = "INSERT OR IGNORE INTO Tracks (ID, TRACK, ARTIST, ALBUM, GENRE) "
                            + "VALUES (2, 'Foot Roll', 'LIL X', 'Gray', 'Rap');";
        st.execute(insertTrack2);
        String insertTrack3 = "INSERT OR IGNORE INTO Tracks (ID, TRACK, ARTIST, ALBUM, GENRE) "
                            + "VALUES (3, 'Solid', 'Duke Bronze', 'Saxline', 'RnB');";
        st.execute(insertTrack3);
        String insertTrack4 = "INSERT OR IGNORE INTO Tracks (ID, TRACK, ARTIST, ALBUM, GENRE) "
                            + "VALUES (4, 'Breeze', 'DJ ABC', 'Frozen Chimps', 'EDM');";
        st.execute(insertTrack4);

        st.close();
        conn.close();
    }
    
    public boolean login(String username, String password) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement st = conn.createStatement();
        String query = "SELECT * FROM Users WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'";
        System.out.println(query);
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            st.close();
            conn.close();
            return true;
        } else {
            st.close();
            conn.close();
            return false;
        }
    }
    
    public ObservableList<Track> getTracks() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement st = conn.createStatement();
        String query = "SELECT TRACK, ARTIST, ALBUM, GENRE FROM Tracks";
        ResultSet rs = st.executeQuery(query);
        ObservableList<Track> tracksList = FXCollections.observableArrayList();
        while (rs.next()) {
            tracksList.add(new Track(rs.getString("track"), rs.getString("artist"), rs.getString("album"), rs.getString("genre")));
        }
        st.close();
        conn.close();
        return tracksList;
    }
}
