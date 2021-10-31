package com.example.mcalc;

import org.junit.Assert;
import org.junit.Test;

public class MortgageModelTest {
    @Test
    public void computePaymentTest() {
        String p, a, i;
        p = "700000";
        a = "25";
        i = "2.75";
        String testcase = p + "," + a + "," + i;
        MortgageModel model = new MortgageModel(p,a,i);
        Assert.assertEquals(testcase,"$3,229.18",model.computePayment());
        p = "300000";
        a = "20";
        i = "4.5";
        String testcase1 = p + "," + a + "," + i;
        MortgageModel model1 = new MortgageModel(p,a,i);
        Assert.assertEquals(testcase1,"$1,897.95",model1.computePayment());

    }
}
