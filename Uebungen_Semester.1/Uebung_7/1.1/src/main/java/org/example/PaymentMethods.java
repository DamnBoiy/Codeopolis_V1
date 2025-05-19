package org.example;
import java.text.DecimalFormat;

public abstract class PaymentMethods
{
    DecimalFormat df = new DecimalFormat("####0.00");
    /* ArrayList<Object> paymentMethods = new ArrayList<>(); */
    private String holder;
    private double amount = 0.0;

    public PaymentMethods(String holder, double amount)
    {
        this.holder = holder;
        this.amount = amount;
    }

    public String GetHolder()
    {
        return holder;
    }
    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double GetAmount()
    {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /* public void GetPaymentMethod()
    {
        for(int i = 0; i < paymentMethods.size(); i++)
        {
            if(paymentMethods.get(i) instanceof PayPal)
            {
               PaymentMethods payPal = (PayPal)paymentMethods.get(i);
            }
            else if(paymentMethods.get(i) instanceof CreditPay)
            {
                PaymentMethods creditPay = (CreditPay)paymentMethods.get(i);
            }
        }
    }*/

    public abstract void PayMethod(double amount);

    public abstract void Refund();
}
