package model;

public class Slack {
    private Integer id;
    private String webhook;

    public Slack(Integer id, String webhook) {
        this.id = id;
        this.webhook = webhook;
    }

    public Slack() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    @Override
    public String toString() {
        return "Slack{" + "id=" + id + ", webhook=" + webhook + '}';
    }
    
    
}
