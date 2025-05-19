package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class TestDrive
{
    public static void main(String[] args)
    {
        PaymentMethods payPal = new PayPal("Jonas", 100);
        payPal.PayMethod(payPal.GetAmount());

        PaymentMethods creditPay = new CreditPay("Tim", 69);
        creditPay.PayMethod(creditPay.GetAmount());

        PaymentMethods googlePay = new GooglePay("Leonard", 88.23, "GooglePay");
        googlePay.PayMethod(googlePay.GetAmount());
        googlePay.Refund();

        // paymentMethods.add(payPal);
        // paymentMethods.add(creditPay); Genutzt um das Array zu testen, siehe PaymentMethods






        Lul lol = new Lul();

        ArrayList<Object> test = new ArrayList<>();
        test.add(payPal);
        test.add(creditPay);
        test.add(googlePay);
        test.add(lol);


        for(int i = 0; i < test.size(); i++)
        {
            if(test.get(i) instanceof PaymentMethods)
            {
                System.out.println(test.get(i));
            }
            else System.out.println(test.get(i) + " keine valide Zahlungsmethode");
        }



    }
}
