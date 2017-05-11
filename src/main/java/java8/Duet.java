package java8;

//By implementing two interfaces with default methods of the same signature, class Duet faces Diamond inheritance problem
public class Duet implements MaleSinger, FemaleSinger {
    //Java forces you to resolve the conflict yourself by overriding the problematic method
    @Override
    public void playChorus() {
        MaleSinger.super.playChorus(); //Delegate to the interface is still possible using this syntax
        FemaleSinger.super.playChorus();
    }

    private void sing() {
        playFemalePart();
        playMalePart();
        playChorus();
    }

    public static void main(String[] args) {
        new Duet().sing();
    }
}
