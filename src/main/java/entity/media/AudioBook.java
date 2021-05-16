package entity.media;

import java.sql.SQLException;

public class AudioBook extends Media{
    private String author;
    private String format;
    private  String language;
    private  String accent;
    private int lengthInMinutes;

    public AudioBook(int id, String title, int quantity, String category, String imageUrl, int price, String type, String author, String format, String language, String accent, int lengthInMinutes) throws SQLException {
        super(id, title, quantity, category, imageUrl, price, type);
        this.author = author;
        this.format = format;
        this.language = language;
        this.accent = accent;
        this.lengthInMinutes = lengthInMinutes;
    }

    public AudioBook() throws SQLException {
    }

    public AudioBook(int id, String title, String category, int price, int quantity, String type) throws SQLException {
        super(id, title, category, price, quantity, type);
    }

    public AudioBook(int id, String title, int quantity, String category, String imageUrl, int price, String type) throws SQLException {
        super(id, title, quantity, category, imageUrl, price, type);
    }

}
