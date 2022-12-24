package org.example.payments;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    enum PaymentStatus{
        OK,ERROR
    }

    private PaymentStatus status;

}
