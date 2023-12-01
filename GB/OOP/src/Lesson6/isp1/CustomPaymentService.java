package Lesson6.isp1;

public class CustomPaymentService extends PaymentSrv implements WebMoneyPaymentService, CreditCardPaymentService {
    @Override
    public void payWebMoney(int amount) { System.out.printf("CustomProvider pay by web money %d\n", amount); }

    @Override
    public void payCreditCard(int amount) { System.out.printf("CustomProvider pay by credit card %d\n", amount); }
}
