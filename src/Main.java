import post.*;
import author.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Author> authorList = new ArrayList<>();
    static List<Post> postList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        loop1:
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("게시판 서비스를 이용합니다.");
            System.out.printf("1. 회원가입\n2. 회원목록조회\n3. 회원상세조회\n4. 게시글작성\n5. 게시글목록조회\n6. 게시글조회\n그외번호. 종료\n");
            switch (Integer.parseInt(br.readLine())) {
                case 1:
                    sign();
                    break;
                case 2:
                    author_inquiry_all();
                    break;
                case 3:
                    author_inquiry();
                    break;
                case 4:
                    write();
                    break;
                case 5:
                    post_inquiry_all();
                    break;
                case 6:
                    post_inquiry();
                    break;
                default:
                    break loop1;
            }
        }
    }

    public static void sign() throws IOException {
        System.out.println("이름을 입력해주십시오");
        String userName = br.readLine();
        System.out.printf("이메일을 입력해주십시오\n이메일형식 : hoho@hoho.com\n");
        String userEmail = br.readLine();
        boolean check = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", userEmail);
        while (!check) {
            System.out.printf("형식에 맞지 않습니다,\n이메일을 다시 입력해주십시오\n이메일형식 : hoho@hoho.com\n");
            userEmail = br.readLine();
            check = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", userEmail);
        }
        System.out.println("비밀번호를 입력해주십시오");
        String userPassword = br.readLine();
        authorList.add(new Author(userName, userEmail, userPassword));
    }

    public static void author_inquiry_all() {
        if (!authorList.isEmpty()) {
            for (Author a : authorList) {
                System.out.println("사용자 ID : " + a.getId());
                System.out.println("사용자 EMAIL : " + a.getEmail());
                System.out.println("---------next---------");
            }
        } else {
            System.out.println("회원이 없습니다.");
        }
    }

    public static void author_inquiry() throws IOException {
        System.out.printf("이메일을 입력해주십시오\n이메일형식 : hoho@hoho.com\n");
        String userEmail = br.readLine();
        boolean check = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", userEmail);
        while (!check) {
            System.out.printf("형식에 맞지 않습니다,\n이메일을 다시 입력해주십시오\n이메일형식 : hoho@hoho.com\n");
            userEmail = br.readLine();
            check = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", userEmail);
        }
        if(!authorList.isEmpty()) {
            for (Author a : authorList) {
                if (a.getEmail().equals(userEmail)) {
                    System.out.println("사용자 ID : " + a.getId());
                    System.out.println("사용자 NAME : " + a.getName());
                    System.out.println("사용자 EMAIL : " + a.getEmail());
                    System.out.println("사용자 PASSWORD : " + a.getPassword());
                }
            }
        }
    }

    public static void write() throws IOException {
        System.out.printf("이메일을 입력해주십시오\n이메일형식 : hoho@hoho.com\n");
        String userEmail = br.readLine();
        boolean check = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", userEmail);
        while (!check) {
            System.out.printf("형식에 맞지 않습니다,\n이메일을 다시 입력해주십시오\n이메일형식 : hoho@hoho.com\n");
            userEmail = br.readLine();
            check = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", userEmail);
        }
        Author author=null;
        if(!authorList.isEmpty()) {
            for (Author a : authorList) {
                if (a.getEmail().equals(userEmail)) {
                    author = a;
                }
            }
        }
        System.out.println("제목을 입력해주십시오");
        String postTitle = br.readLine();
        System.out.println("내용을 입력해주십시오");
        String postContents = br.readLine();
        postList.add(new Post(postTitle,postContents,author));
    }

    public static void post_inquiry_all() {
        if (!postList.isEmpty()) {
            for (Post p : postList) {
                System.out.println("게시글 ID : " + p.getId());
                System.out.println("게시글 제목 : " + p.getTitle());
                System.out.println("---------next---------");
            }
        } else {
            System.out.println("게시글이 없습니다.");
        }
    }

    public static void post_inquiry() throws IOException {
        System.out.printf("이메일을 입력해주십시오\n이메일형식 : hoho@hoho.com\n");
        String userEmail = br.readLine();
        boolean check = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", userEmail);
        while (!check) {
            System.out.printf("형식에 맞지 않습니다,\n이메일을 다시 입력해주십시오\n이메일형식 : hoho@hoho.com\n");
            userEmail = br.readLine();
            check = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", userEmail);
        }
        if(!postList.isEmpty()) {
            for (Post p : postList) {
                if (p.getAuthor().getEmail().equals(userEmail)) {
                    System.out.println("저자 NAME : " + p.getAuthor().getName());
                    System.out.println("글 ID : " + p.getId());
                    System.out.println("글 제목 : " + p.getTitle());
                    System.out.println("글 내용 : " + p.getContents());
                    System.out.println("---------next---------");
                }
            }
        }
    }

}