package com.event.domain.eventdispatcher.events.handles;

import com.event.domain.eventdispatcher.entity.Benefit;
import com.event.domain.eventdispatcher.events.BenefitRegistered;
import com.event.domain.eventdispatcher.interfaces.EventHandler;
import com.google.gson.Gson;

public class RequestWalletMovementHandler implements EventHandler<BenefitRegistered> {

    @Override
    public void handle(final BenefitRegistered event) {
        System.out.println("--- Dados da Campanha ---");
        System.out.println(new Gson().toJson(event.getBenefit()));

        System.out.println("Para o evento " + event.getEventType());
        requestWalletMovementCode(event.getBenefit());
    }

    private void requestWalletMovementCode(Benefit benefit){
        //Implementa lógica aqui
        System.out.println("1 - Enviar solicitação de criação de movimento agrupado para wallet ");
    }

}
