package com.winter.app.transfer.main;

import com.winter.app.transfer.Bus;
import com.winter.app.transfer.Subway;
import com.winter.app.transfer.card.Card;

public class TransferMain {

	public static void main(String[] args) {
		Subway s = new Subway();
		Bus b = new Bus();
		Card card = new Card();
		
		//start
		card.checkCard();
		b.getBus();
		card.checkCard();
		
		card.checkCard();
		s.getSubway();
		card.checkCard();
		
		

	}

}
