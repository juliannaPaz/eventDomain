package com.event.domain.eventdispatcher.events;

import com.event.domain.eventdispatcher.entity.InvoiceResponse;
import com.event.domain.eventdispatcher.interfaces.Event;
import com.google.gson.Gson;

import java.time.LocalDateTime;

public class BenefitInvoiceRegistered extends Event {

    private LocalDateTime dateTimeOccurred;
    private InvoiceResponse invoiceResponse;

    public BenefitInvoiceRegistered() {
        super(EventType.BENEFIT_INVOICE_REGISTERED);
    }

    @Override
    public void registerEvent(final String payload) {
        this.dateTimeOccurred = LocalDateTime.now();
        this.invoiceResponse = convert(payload);
    }

    public LocalDateTime getDateTimeOccurred() {
        return dateTimeOccurred;
    }

    public InvoiceResponse getInvoiceResponse() {
        return invoiceResponse;
    }

    private InvoiceResponse convert(String payload){
        Gson gson = new Gson();
        return gson.fromJson(payload, InvoiceResponse.class);
    }

}
