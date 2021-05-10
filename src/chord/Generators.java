package chord;

public class Generators {

    public static int generateStart(int m, int n, int i) {  return (n + (1 << i)) % (1 << m);
    }
}
