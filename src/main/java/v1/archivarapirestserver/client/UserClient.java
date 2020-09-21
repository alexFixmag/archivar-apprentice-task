package v1.archivarapirestserver.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import ru.hostco.reguser.types.GetUserRequestType;
import ru.hostco.reguser.types.GetUserResponseType;

public class UserClient extends WebServiceGatewaySupport {

    public GetUserResponseType getUser(String snilsid, String accessToken){
        GetUserRequestType request = new GetUserRequestType();
        request.setToken(accessToken);
        request.setSNILS(snilsid);

        GetUserResponseType response = (GetUserResponseType) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/api/ws/user", request);
        return response;
    }
}
