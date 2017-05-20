package fun;

public class ChristmasTree {

    public static void main(String[] args) {

        final int width = 17;

        int starCount = 1;
        int spaceCount = width - starCount;

        while(starCount <= width) {

            for (int j = 0; j < spaceCount/2; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < starCount; k++) {
                System.out.print("*");
            }

            for (int j = 0; j < spaceCount/2; j++) {
                System.out.print(" ");
            }

            starCount += 2;
            spaceCount -= 2;

            System.out.println();

        }

    }
}
