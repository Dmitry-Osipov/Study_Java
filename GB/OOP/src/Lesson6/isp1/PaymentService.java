package Lesson6.isp1;

public interface PaymentService {
    void payWebMoney(int amount);

    void payCreditCard(int amount);

    void payPhoneNumber(int amount);
}
