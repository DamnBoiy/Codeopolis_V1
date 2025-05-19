package org.example;

public class CreditPay extends PaymentMethods
{

    public CreditPay(String holder, double amount)
    {
        super(holder, amount);
    }

    @Override
    public void PayMethod(double amount)
    {
        System.out.println( GetHolder() + " paid " + df.format(GetAmount()) + " EUR by credit card.");
    }

    @Override
    public void Refund() {
        System.out.println( GetHolder() + " received a refund of " + df.format(GetAmount()) + " EUR by credit card.");
    }
}
