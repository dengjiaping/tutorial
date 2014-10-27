package com.nonotests.automation.webservice.nonobank.${packagename};

import com.common.webservice.client.RestTemplateClient;
import com.nonotests.automation.Environment;
import com.nonotests.automation.webservice.IWebService;
import com.nonotests.automation.webservice.NonobankServiceForPHP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class ${service.servicename} extends NonobankServiceForPHP implements IWebService {
private static final Logger logger = LogManager.getLogger(.class.getName());
private static final String URL = Environment.getNonoBankTestSite()+"${service.baseUri}";

private String {$parameters};
private String requestUrl;
private MultiValueMap<String,String> parameters = new LinkedMultiValueMap<String,String>();

public FinancePlanDoPaymentPageService(String paymentId,RestTemplateClient client) {
this.paymentId = paymentId;
buildRequest();
super.setClient(client);
}

@Override
public ResponseEntity call() {
ResponseEntity response = super.getClient()
.setContentType(MediaType.APPLICATION_FORM_URLENCODED).call(${service.method}, String.class,requestUrl);
logger.info("response={}",response);
setResponse(response);
return response;
}

@Override
public void buildRequest() {
requestUrl = URL.replace("${PYAMENTID}",paymentId);
}
}

