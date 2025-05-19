package org.example;

public class GooglePay extends PaymentMethods
{
    private String googlePay;

    public GooglePay(String holder, double amount, String googlePay)
    {
        super(holder, amount);
        this.googlePay = googlePay;
    }

    public String getGooglePay() {
        return googlePay;
    }

    public void setGooglePay(String googlePay) {
        this.googlePay = googlePay;
    }


    @Override
    public void PayMethod(double amount)
    {
        System.out.println( GetHolder() + " paid " + df.format(GetAmount()) + " EUR using Google Pay");
    }

    @Override
    public void Refund() {
        System.out.println( GetHolder() + " received a refund of " + df.format(GetAmount()) + " EUR via Google Pay.");
    }



}
