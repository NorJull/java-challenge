package challenge.contest;

public class LastUser {

    public static int totalUsers(int lastUserId){
        return lastUserId - (lastUserId/13);
    }
    static int solution(int n) {
        return n - (n/13);
    }

    public static void main(String[] args) {
        System.out.println(solution(27));
    }
}
