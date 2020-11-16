package stream.arrays.backend.domain;

import org.springframework.data.annotation.Id;

public class Subscriber {
    @Id
    private int id;
    private String email;
    private boolean isProcessed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Subscriber() {
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public Subscriber(int id, String email, boolean isProcessed) {
        this.id = id;
        this.email = email;
        this.isProcessed = isProcessed;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", isProcessed=" + isProcessed +
                '}';
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }
}
