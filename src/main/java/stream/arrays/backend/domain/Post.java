package stream.arrays.backend.domain;

import org.springframework.data.annotation.Id;

public class Post {
    @Id
    private int id;
    private String content;
    private String title;
    private String author;
    private String images;

    public Post(int id, String content, String title, String author, String images) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.author = author;
        this.images = images;
    }

    public Post() {
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
                '}';
    }
}
