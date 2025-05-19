package org.example;

public class PayPal extends  PaymentMethods
{
    private String paypal;

    public PayPal(String holder, double amount)
    {
        super(holder, amount);
    }

    @Override
    public void PayMethod(double amount)
    {
        System.out.println( GetHolder() + " paid " + df.format(GetAmount()) + " EUR using PayPal.");
    }

    @Override
    public void Refund() {
        System.out.println( GetHolder() + " received a refund of " + df.format(GetAmount()) + " EUR via PayPal.");
    }
}
