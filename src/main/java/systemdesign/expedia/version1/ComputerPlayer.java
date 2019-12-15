package systemdesign.expedia.version1;

import java.util.concurrent.ThreadLocalRandom;
//import org.apache.commons.codec.binary.Hex;

/**
 * @author  Jeff Cai
 *
 * @date    03/19/2019
 * @version 1.0
 *
 */
public class ComputerPlayer extends Player {

    private int min;
    private int max;

    public ComputerPlayer(int id, String name, int min, int max) {
        super(id, name);
        this.min = min;
        this.max = max;
    }

    public int getRandom () {
        return (int) Math.floor(Math.random() * (max - min) + min);
    }

    public int getRealRandom() {
        int ints = ThreadLocalRandom.current().nextInt(max);
        return ints;
    }

    public static void main (String[] args) {
        ComputerPlayer computer = new ComputerPlayer(-1,"Computer Player O",0 , 3);
        for (int i = 0; i < 3; i++) {
            System.out.print(computer.getRandom() + " , ");
        }
        System.out.println("\n===================================");
        for (int i = 0; i < 3; i++) {
            System.out.print(computer.getRealRandom() + " , ");
        }
    }

    /*public String generateSecretToken() {
        SecureRandom secRandom = new SecureRandom();

        byte[] result = new byte[32];
        secRandom.nextBytes(result);
        return Hex.encodeHexString(result);
    }*/
}
