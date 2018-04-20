public class test {
    public static void main(String[] args) {
        int[] b = {1,2,3,4,5,6,7};
        int[] c = new int[b.length];
        for(int i = 0; i < b.length; i++) c[(b.length - 1) - i] = b[i];
        for(int i = 0; i < c.length; i++){
            // System.out.println(b[i]);
            System.out.println(c[i]);
        }

    }
}
