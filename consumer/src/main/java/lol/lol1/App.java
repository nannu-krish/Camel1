package lol.lol1;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;




/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {

      
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {

            public void configure() throws Exception {
                
            
        		
        		from("rabbitmq://localhost:5672/MyExchange?username=guest&password=guest&autoDelete=false&routingKey=key&queue=Que")
                        .to("ftp://localhost:32781/home?username=kittu&password=kittu&disconnect=true");
        		
        	//	from("file:D:\\output").to("file:D:\\outbox");

            }
        });
        context.start();
       // Thread.sleep(4000);
       // context.stop();
      
    }
    
    
}
