package ru.netology.sqlbanklogin.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;

public class VerificationPage {
    private final SelenideElement codeField = $("[data-test-id=code] input");
    private final SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");
    public void verifyVerificationPageVisibility(){
        codeField.shouldBe(Condition.visible);
    }
    public void verifyErrorNotification(String expectedText){
        errorNotification.shouldBe(Condition.exactText(expectedText)).shouldBe(Condition.visible);
    }
    public void verify(String verificationCode){
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
    public DashboardPage validVerify(String verificationCode){
        verify(verificationCode);
        return new DashboardPage();
    }
}
