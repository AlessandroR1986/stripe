package com.strippayments.strippayments.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfo {

    private String currency;
    private long amount;
    private String receiptEmail;
}
