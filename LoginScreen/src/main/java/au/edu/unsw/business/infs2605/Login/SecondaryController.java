package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController {
    
    Database database = new Database();
    
    @FXML
    TableView<Track> tracks;
    
    @FXML
    TableColumn<Track, String> track;
    
    @FXML
    TableColumn<Track, String> artist;
    
    @FXML
    TableColumn<Track, String> album;
    
    @FXML
    TableColumn<Track, String> genre;
    
    @FXML
    private void handleNavigationDisplay(ActionEvent event) throws IOException {
        App.setRoot("display");
    }
    
    
    @FXML
    public void initialize() throws SQLException {
        ObservableList<Track> tracksList = FXCollections.observableArrayList();
        tracksList = database.getTracks();
        
        tracks.setItems(tracksList);
        track.setCellValueFactory(new PropertyValueFactory<>("track"));
        artist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        album.setCellValueFactory(new PropertyValueFactory<>("album"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
    }
    
    
    
    
}