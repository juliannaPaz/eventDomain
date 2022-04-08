package com.event.domain.eventdispatcher.events.handles;

import com.event.domain.eventdispatcher.entity.Benefit;
import com.event.domain.eventdispatcher.events.BenefitRegistered;
import com.event.domain.eventdispatcher.interfaces.EventHandler;

public class RequestCashbackInvoiceHandler implements EventHandler<BenefitRegistered> {

    @Override
    public void handle(final BenefitRegistered event) {
        requestCashbackInvoice(event.getBenefit());
    }

    private void requestCashbackInvoice(Benefit benefit){
        //Implementa lógica aqui
        System.out.println("2 - Publicar no tópico card-benefits_cashback-invoice-request o payload do contrato.");
    }


}
