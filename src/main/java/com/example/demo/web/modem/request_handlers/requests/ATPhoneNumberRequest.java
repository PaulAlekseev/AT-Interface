package com.example.demo.web.modem.request_handlers.requests;

import com.example.demo.web.extra.ATPhoneNumberRequestMethod;
import com.example.demo.web.extra.DecidePhoneNumberMethod;
import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.containers.IMSIContainer;
import com.example.demo.web.modem.request_handlers.objs.IMSI;

public class ATPhoneNumberRequest implements ATRequest {

    @Override
    public String makeRequest(ATCommandExecutor executor) throws Exception {
        IMSI imsi = new IMSI();
        IMSIContainer imsiContainer = imsi.getIMSI(executor);
        ATPhoneNumberRequestMethod requestMethod = DecidePhoneNumberMethod.decideMethod(imsiContainer);
        return requestMethod.executeMethod(executor, imsiContainer);
    }

}
