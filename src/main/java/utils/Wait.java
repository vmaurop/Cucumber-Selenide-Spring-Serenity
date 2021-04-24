package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public final class Wait {

    private Wait() {
        throw new IllegalStateException("Wait class");
    }

    public static void untilIsDisplayed(SelenideElement selenideElement, int sec) {
        await().atMost(sec, SECONDS).until(selenideElement::isDisplayed);
    }

    public static void untilIsDisplayed(ElementsCollection elementsCollection, int sec) {
        await().atMost(sec, SECONDS).until(() -> !elementsCollection.isEmpty());
    }

    public static void untilNotDisplayed(SelenideElement selenideElement, int sec) {
        await().atMost(sec, SECONDS).until(() -> !selenideElement.isDisplayed());
    }

    public static void untilNotDisplayed(ElementsCollection elementsCollection, int sec) {
        await().atMost(sec, SECONDS).until(elementsCollection::isEmpty);
    }

    public static void forSec(int sec) {
        Selenide.sleep(TimeUnit.MILLISECONDS.convert(sec, TimeUnit.SECONDS));
    }

}


