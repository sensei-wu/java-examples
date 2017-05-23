package fun;

public class ChristmasTree {

    public static void main(String[] args) {

        final int width = 17;

        int starCount = 1;
        int spaceCount = width - starCount;

        while(starCount <= width) {

            String space = "";
            for (int j = 0; j < spaceCount/2; j++) {
                space += " ";
            }

            System.out.print(space);

            String star = "";
            for (int k = 0; k < starCount; k++) {
                star += "*";
            }

            System.out.print(star);

            starCount += 2;
            spaceCount -= 2;

            System.out.println();

        }
    }
}
