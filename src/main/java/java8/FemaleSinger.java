package java8;

public interface FemaleSinger {
    default void playChorus() {
        System.out.println("Playing Chorus by female singer");
    }

    default void playFemalePart() {
        System.out.println("Playing female only part");
    }
}
