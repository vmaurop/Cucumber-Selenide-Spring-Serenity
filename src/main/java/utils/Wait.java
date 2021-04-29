package utils;

import com.codeborne.selenide.Selenide;

import java.util.concurrent.TimeUnit;

public final class Wait {

    private Wait() {
        throw new IllegalStateException("Wait class");
    }

    public static void forSec(int sec) {
        Selenide.sleep(TimeUnit.MILLISECONDS.convert(sec, TimeUnit.SECONDS));
    }

}


