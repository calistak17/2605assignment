/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

/**
 *
 * @author YXTing
 */
public class Track {
    private String track;
    private String artist;
    private String album;
    private String genre;
    
    public Track(String track, String artist, String album, String genre) {
        this.track = track;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }
    
    public String getTrack() {
        return track;
    }
    public String getArtist() {
        return artist;
    }
    public String getAlbum() {
        return album;
    }
    public String getGenre() {
        return genre;
    }
}
