import synthesizer.GuitarString;

public class GuitarHero {
    private static final double BASE = 440.0;

    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        synthesizer.GuitarString[] gs = new synthesizer.GuitarString[keyboard.length()];

        for(int i = 0; i < gs.length; i++){
            double concert = BASE * Math.pow(2, (i - 24)/12.0);
            synthesizer.GuitarString string = new synthesizer.GuitarString(concert);
            gs[i] = string;
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    gs[index].pluck();
                }
            }
            double sample = 0.0;
            for(int i = 0; i < gs.length; i++){
                sample += gs[i].sample();
            }
            StdAudio.play(sample);
            for(int i = 0; i < gs.length; i++){
                gs[i].tic();
            }
        }
    }
}
