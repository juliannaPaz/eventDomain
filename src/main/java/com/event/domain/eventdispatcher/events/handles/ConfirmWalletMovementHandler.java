package com.event.domain.eventdispatcher.events.handles;

import com.event.domain.eventdispatcher.entity.InvoiceResponse;
import com.event.domain.eventdispatcher.events.BenefitRegisteredInvoice;
import com.event.domain.eventdispatcher.interfaces.EventHandler;
import com.google.gson.Gson;

public class ConfirmWalletMovementHandler implements EventHandler<BenefitRegisteredInvoice> {

    @Override
    public void handle(final BenefitRegisteredInvoice event) {
        System.out.println("--- Dados da Retorno do Invoice ---");
        System.out.println(new Gson().toJson(event.getInvoiceResponse()));

        System.out.println("Para o evento " + event.getEventType());
        confirmWalletMovementCode(event.getInvoiceResponse());
    }

    private void confirmWalletMovementCode(InvoiceResponse invoiceResponse){
        //Implementa lógica aqui
        System.out.println("1 - Enviar confirmação de movimento agrupado para wallet ");
    }

}
