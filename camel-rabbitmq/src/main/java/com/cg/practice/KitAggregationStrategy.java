package com.cg.practice;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class KitAggregationStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) 
    {
    	 if (oldExchange == null) {
             // the first time we aggregate we only have the new exchange,
             // so we just return it
             return newExchange;
         }
  
         String orders = oldExchange.getIn().getBody(String.class);
         String newLine = newExchange.getIn().getBody(String.class);
  
        
  
         // put orders together separating by semi colon
         orders = orders + ";" + newLine;
         // put combined order back on old to preserve it
         oldExchange.getIn().setBody(orders);
  
         // return old as this is the one that has all the orders gathered until now
         return oldExchange;
        
    }
}
