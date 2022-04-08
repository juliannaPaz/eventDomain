package com.event.domain.eventdispatcher.events.handles;

import com.event.domain.eventdispatcher.entity.InvoiceResponse;
import com.event.domain.eventdispatcher.events.BenefitRegisteredInvoice;
import com.event.domain.eventdispatcher.interfaces.EventHandler;

public class NotifyConsumerAppHandler implements EventHandler<BenefitRegisteredInvoice> {

    @Override
    public void handle(final BenefitRegisteredInvoice event) {
        notifyConsumerApp(event.getInvoiceResponse());
    }

    private void notifyConsumerApp(InvoiceResponse invoiceResponse){
        //Implementa lógica aqui
        System.out.println("3 - Enviar notificação pro usuário pelo APP ");
    }

}
