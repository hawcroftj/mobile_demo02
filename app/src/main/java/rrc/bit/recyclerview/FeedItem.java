package rrc.bit.recyclerview;

// Defines a basic feed item for use in a RecyclerView
public class FeedItem {
    private String title, content;
    private int image;

    public FeedItem(String title, String content, int image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public String getTitle() { return title; }

    public String getContent() { return content; }

    public int getImage() { return image; }
}
