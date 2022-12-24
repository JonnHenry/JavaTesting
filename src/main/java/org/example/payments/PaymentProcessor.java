package org.example.payments;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PaymentProcessor {

    PaymentGateway paymentGateway;

    public boolean makePayment(double amount){
        PaymentResponse paymentResponse = paymentGateway.requestPayment(new PaymentRequest(amount));
        return paymentResponse.getStatus() == PaymentResponse.PaymentStatus.OK;
    }
}
