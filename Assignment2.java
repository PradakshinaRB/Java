package sample;

public class StringVsStringBuilder {
    public static void main(String[] args) {
        int n = 100000;

        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += i; 
        }
        long endTime = System.currentTimeMillis();
        long stringTime = endTime - startTime;
        System.out.println("Time taken by String concatenation: " + stringTime + " ms");

       
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i); 
        }
        endTime = System.currentTimeMillis();
        long stringBuilderTime = endTime - startTime;
        System.out.println("Time taken by StringBuilder concatenation: " + stringBuilderTime + " ms");
    }
}
