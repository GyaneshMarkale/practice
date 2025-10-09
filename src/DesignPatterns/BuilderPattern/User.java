package DesignPatterns.BuilderPattern;

public class User {
    private final String name;
    private final int rollNo;
    private final String email;

    private User(userBuilder userBuilder)
    {
        this.name = userBuilder.name;
        this.rollNo = userBuilder.rollNo;
        this.email = userBuilder.email;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", email='" + email + '\'' +
                '}';
    }

    static class userBuilder {
        private  String name;
        private  int rollNo;
        private  String email;

//        public userBuilder(String name, int rollNo, String email)
//        {
//            this.name = name;
//            this.rollNo = rollNo;
//            this.email = email;
//        }

        public userBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public userBuilder setRollNo(int rollNo) {
            this.rollNo = rollNo;
            return this;
        }

        public userBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build(){
            User user = new User(this);
            return user;
        }

    }
}
