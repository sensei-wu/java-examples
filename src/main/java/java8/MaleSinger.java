package java8;

public interface MaleSinger {
    default void playChorus() {
        System.out.println("Playing Chorus by male singer");
    }

    default void playMalePart() {
        System.out.println("Playing male only part");
    }
}
