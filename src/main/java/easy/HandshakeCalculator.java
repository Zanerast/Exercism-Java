package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {
    List<Signal> calculateHandshake(int number) {
        List<Signal> handshake = new ArrayList<>();
        if ((number & 1) == 1) handshake.add(Signal.WINK);
        if ((number & 2) > 1) handshake.add(Signal.DOUBLE_BLINK);
        if ((number & 4) > 1) handshake.add(Signal.CLOSE_YOUR_EYES);
        if ((number & 8) > 1) handshake.add(Signal.JUMP);
        if ((number & 16) > 1) Collections.reverse(handshake);
        return handshake;
    }
}

enum Signal {
    WINK, DOUBLE_BLINK, CLOSE_YOUR_EYES, JUMP;
}

