package Lesson6.isp1;

public class InternetPaymentService extends PaymentSrv implements CreditCardPaymentService,
        PhonePaymentService, WebMoneyPaymentService {
    @Override
    public void payWebMoney(int amount) { System.out.printf("InternetProvider pay by web money %d\n", amount); }

    @Override
    public void payCreditCard(int amount) { System.out.printf("InternetProvider pay by credit card %d\n", amount); }

    @Override
    public void payPhoneNumber(int amount) { System.out.printf("InternetProvider pay by phone number %d\n", amount); }
}
