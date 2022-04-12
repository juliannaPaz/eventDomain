package com.event.domain.eventdispatcher.events.handles;

import com.event.domain.eventdispatcher.entity.InvoiceResponse;
import com.event.domain.eventdispatcher.events.BenefitInvoiceRegistered;
import com.event.domain.eventdispatcher.interfaces.EventHandler;

public class UpdateCardTimelineHandler implements EventHandler<BenefitInvoiceRegistered> {

    @Override
    public void handle(final BenefitInvoiceRegistered event) {
        updateCardTimeline(event.getInvoiceResponse());
    }

    private void updateCardTimeline(InvoiceResponse invoiceResponse){
        //Implementa lógica aqui
        System.out.println("2 - Enviar atualização pro card-timeline ");
    }

}
