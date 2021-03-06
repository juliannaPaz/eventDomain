package com.event.domain.eventdispatcher;

import com.event.domain.eventdispatcher.entity.Benefit;
import com.event.domain.eventdispatcher.entity.InvoiceResponse;
import com.event.domain.eventdispatcher.events.BenefitRegistered;
import com.event.domain.eventdispatcher.events.BenefitInvoiceRegistered;
import com.event.domain.eventdispatcher.events.EventType;
import com.event.domain.eventdispatcher.events.dispatcher.CashbackInvoiceDispatcher;
import com.event.domain.eventdispatcher.events.handles.ConfirmWalletMovementHandler;
import com.event.domain.eventdispatcher.events.handles.NotifyConsumerAppHandler;
import com.event.domain.eventdispatcher.events.handles.RequestCashbackInvoiceHandler;
import com.event.domain.eventdispatcher.events.handles.RequestWalletMovementHandler;
import com.event.domain.eventdispatcher.events.handles.UpdateCardTimelineHandler;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
class EventDispatcherApplicationTests {

	private static CashbackInvoiceDispatcher eventDispatcher;

	@BeforeAll
	static void init(){
		eventDispatcher = new CashbackInvoiceDispatcher();
		eventDispatcher.register(EventType.BENEFIT_REGISTERED, new RequestWalletMovementHandler());
		eventDispatcher.register(EventType.BENEFIT_REGISTERED, new RequestCashbackInvoiceHandler());

		eventDispatcher.register(EventType.BENEFIT_INVOICE_REGISTERED, new ConfirmWalletMovementHandler());
		eventDispatcher.register(EventType.BENEFIT_INVOICE_REGISTERED, new UpdateCardTimelineHandler());
		eventDispatcher.register(EventType.BENEFIT_INVOICE_REGISTERED, new NotifyConsumerAppHandler());
	}

	@Test
	@DisplayName("Quando o benefício for registrado na base, Então execute os eventos de movimento agrupado e requisição de inclusão na fatura ")
	void whenRegisteredBenefitThenExecuteHandler(){
		//Evento ocorrendo
		var event = new BenefitRegistered();
		var benefit = new Benefit(UUID.randomUUID(), "Volta Grana", new BigDecimal(2.50));
		event.registerEvent(new Gson().toJson(benefit));
		eventDispatcher.notify(event);
	}

	@Test
	@DisplayName("Quando o invoice registrar o pedido de inclusão cashback, Então execute os eventos de confirmar movimento agrupado e atualizar timeline" +
		"e enviar notificação ")
	void whenConfirmedInvoiceBenefitThenExecuteHandler(){
		var event = new BenefitInvoiceRegistered();
		var invoiceResponse = new InvoiceResponse("4578787","47445454","000154");
		event.registerEvent(new Gson().toJson(invoiceResponse));
		eventDispatcher.notify(event);
	}
}
