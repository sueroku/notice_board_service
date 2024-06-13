package author;

public class Author {
    static Long total_id = 0L;
    private Long id;
    private String name;
    private String email;
    private String password;

    public Author(String name, String email, String password){
        this.id = total_id;
        total_id+=1;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    Author(){}

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
