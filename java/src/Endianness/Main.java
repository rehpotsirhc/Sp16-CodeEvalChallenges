package Endianness;

import java.nio.ByteOrder;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {


    public static void main(String[] args) {


        if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
            System.out.println("BigEndian");
        } else {
            System.out.println("LittleEndian");
        }

    }
}
