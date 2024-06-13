package post;

import author.Author;

public class Post {
    static Long total_id =0L;
    private Long id;
    private String title;
    private String contents;
    private Author author;

    public Post(String title, String contents, Author author){
        this.id = total_id;
        total_id+=1;
        this.title = title;
        this.contents = contents;
        this.author = author;
    }
    Post(){}

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContents() {
        return this.contents;
    }

    public Author getAuthor() {
        return this.author;
    }
}
