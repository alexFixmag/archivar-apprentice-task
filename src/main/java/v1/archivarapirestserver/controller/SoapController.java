package v1.archivarapirestserver.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.hostco.reguser.types.GetUserRequestType;
import ru.hostco.reguser.types.GetUserResponseType;
import ru.hostco.reguser.types.LoginStrictType;

@Endpoint
public class SoapController {

    /*The same as targetNamespace in types.xsd*/
    private static final String NAMESPACE_URL = "http://www.hostco.ru/reguser/getUser";

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getUserRequest")//!
    @ResponsePayload
    public GetUserResponseType getUser(@RequestPayload GetUserRequestType request){
        GetUserResponseType response = new GetUserResponseType();

        /*TEST*//*TEST*//*TEST*/
        LoginStrictType userData = new LoginStrictType();
        userData.setFirstname("Алексей");
        userData.setLastname("Хабин");
        userData.setMiddlename("Леондович");
        userData.setBirthDate(null);//XMLGregorianCalendar
        userData.setPhone("9634567654");
        userData.setGender(1);
        userData.setPolicyNumber("1151999010463162");

        response.setSNILS(request.getSNILS());
        response.setMcode("12131312");
        //response.setGender(1);
        response.setLogin(userData);
        /*TEST*//*TEST*//*TEST*/
        return response;
    }
}
