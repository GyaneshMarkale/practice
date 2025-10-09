package DesignPatterns.BuilderPattern;

public class Main {
    public static void main(String[] args)
    {
//        UrlBuilder urlBuilder1 = new UrlBuilder.Builder()
//                .setProtocol("https://")
//                .build();
//        System.out.println(urlBuilder1);

        User user = new User.userBuilder()
                .setName("name")
                .setRollNo(12)
                .build();
        System.out.println(user);
    }
}
