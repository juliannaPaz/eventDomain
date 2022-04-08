package com.event.domain.eventdispatcher;

import com.event.domain.eventdispatcher.entity.Benefit;
import com.event.domain.eventdispatcher.entity.InvoiceResponse;
import com.event.domain.eventdispatcher.events.BenefitRegistered;
import com.event.domain.eventdispatcher.events.BenefitRegisteredInvoice;
import com.event.domain.eventdispatcher.events.EventType;
import com.event.domain.eventdispatcher.events.dispatcher.CashbackInvoiceDispatcher;
import com.event.domain.eventdispatcher.events.handles.ConfirmWalletMovementHandler;
import com.event.domain.eventdispatcher.events.handles.NotifyConsumerAppHandler;
import com.event.domain.eventdispatcher.events.handles.RequestCashbackInvoiceHandler;
import com.event.domain.eventdispatcher.events.handles.RequestWalletMovementHandler;
import com.event.domain.eventdispatcher.events.handles.UpdateCardTimelineHandler;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
class EventDispatcherApplicationTests {

	@Test
	@DisplayName("Quando o benefício for registrado na base, Então execute os eventos de movimento agrupado e requisição de inclusão na fatura ")
	void whenRegisteredBenefitThenExecuteHandler(){

		// Configuração dos eventos
		var eventBenefitRegisteredDispatcher = new CashbackInvoiceDispatcher();
		var requestMovementWallet = new RequestWalletMovementHandler();
		var requestCashbackInvoice = new RequestCashbackInvoiceHandler();

		eventBenefitRegisteredDispatcher.register(EventType.BENEFIT_REGISTERED, requestMovementWallet);
		eventBenefitRegisteredDispatcher.register(EventType.BENEFIT_REGISTERED, requestCashbackInvoice);

		//Evento ocorrendo
		var event = new BenefitRegistered();
		var benefit = new Benefit(UUID.randomUUID(), "Volta Grana", new BigDecimal(2.50));
		event.registerEvent(new Gson().toJson(benefit));
		eventBenefitRegisteredDispatcher.notify(event);
	}

	@Test
	@DisplayName("Quando o invoice registrar o pedido de inclusão cashback, Então execute os eventos de confirmar movimento agrupado e atualizar timeline" +
		"e enviar notificação ")
	void whenConfirmedInvoiceBenefitThenExecuteHandler(){

		// Configuração dos eventos
		var eventDispatcher = new CashbackInvoiceDispatcher();
		var confirmMovementWallet = new ConfirmWalletMovementHandler();
		var updateCardTimeline = new UpdateCardTimelineHandler();
		var notifyConsumer = new NotifyConsumerAppHandler();

		eventDispatcher.register(EventType.BENEFIT_INVOICE_REGISTERED, confirmMovementWallet);
		eventDispatcher.register(EventType.BENEFIT_INVOICE_REGISTERED, updateCardTimeline);
		eventDispatcher.register(EventType.BENEFIT_INVOICE_REGISTERED, notifyConsumer);

		//Evento ocorrendo
		var event = new BenefitRegisteredInvoice();
		var invoiceResponse = new InvoiceResponse("4578787","47445454","000154");
		event.registerEvent(new Gson().toJson(invoiceResponse));
		eventDispatcher.notify(event);
	}
}
