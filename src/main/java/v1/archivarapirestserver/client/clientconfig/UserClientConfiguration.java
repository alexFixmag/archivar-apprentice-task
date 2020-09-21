package v1.archivarapirestserver.client.clientconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import v1.archivarapirestserver.client.UserClient;

@Configuration
public class UserClientConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        /*contextPath corresponds to created classes from WSDL*/
        marshaller.setContextPath("ru.hostco.reguser");
        return marshaller;
    }

    @Bean
    public UserClient userClient(Jaxb2Marshaller marshaller){
        UserClient client = new UserClient();
        client.setDefaultUri("http://localhost:8080/api/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
