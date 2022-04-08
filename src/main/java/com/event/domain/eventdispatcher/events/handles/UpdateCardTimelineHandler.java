package com.event.domain.eventdispatcher.events.handles;

import com.event.domain.eventdispatcher.entity.InvoiceResponse;
import com.event.domain.eventdispatcher.events.BenefitRegisteredInvoice;
import com.event.domain.eventdispatcher.interfaces.EventHandler;

public class UpdateCardTimelineHandler implements EventHandler<BenefitRegisteredInvoice> {

    @Override
    public void handle(final BenefitRegisteredInvoice event) {
        updateCardTimeline(event.getInvoiceResponse());
    }

    private void updateCardTimeline(InvoiceResponse invoiceResponse){
        //Implementa lógica aqui
        System.out.println("2 - Enviar atualização pro card-timeline ");
    }

}
