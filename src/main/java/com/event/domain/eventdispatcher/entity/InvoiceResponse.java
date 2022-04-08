package com.event.domain.eventdispatcher.entity;

public class InvoiceResponse {
    private String consumer;
    private String invoiceId;
    private String gatewayTransactionId;

    public InvoiceResponse(final String consumer, final String invoiceId, final String gatewayTransactionId) {
        this.consumer = consumer;
        this.invoiceId = invoiceId;
        this.gatewayTransactionId = gatewayTransactionId;
    }

    public String getConsumer() {
        return consumer;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getGatewayTransactionId() {
        return gatewayTransactionId;
    }

}
