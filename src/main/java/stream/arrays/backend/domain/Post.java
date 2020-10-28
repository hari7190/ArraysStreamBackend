package stream.arrays.backend.domain;

import org.springframework.data.annotation.Id;

public class Post {
    @Id
    private int id;
    private String content;
    private String title;
    private String author;
    private String images;
    private String date;
    private boolean isReady;

    public Post(int id, String content, String title, String author, String images, String date, boolean isReady) {
        this(content, title, author, images, date, isReady);
        this.id = id;
    }

    public Post(String content, String title, String author, String images, String date, boolean isReady) {
        this.content = content;
        this.title = title;
        this.author = author;
        this.images = images;
        this.date = date;
        this.isReady = isReady;
    }

    public Post() {}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", images='" + images + '\'' +
                ", date='" + date + '\'' +
                ", isReady=" + isReady +
                '}';
    }
}
