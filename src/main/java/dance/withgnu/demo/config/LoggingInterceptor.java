package dance.withgnu.demo.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public @NonNull ClientHttpResponse intercept(
            @NonNull HttpRequest request,
            @NonNull byte[] body,
            @NonNull ClientHttpRequestExecution execution) throws IOException {

        // 요청 전 로그 출력
        logRequestDetails(request, body);

        // 요청을 수행하고 응답을 받음
        ClientHttpResponse response = execution.execute(request, body);

        // 응답 후 로그 출력
        logResponseDetails(response);

        return response;
    }

    private void logRequestDetails(HttpRequest request, byte[] body) {
        // 요청 정보 로깅
        System.out.println("URI: " + request.getURI());
        System.out.println("HTTP Method: " + request.getMethod());
        System.out.println("HTTP Headers: " + request.getHeaders());
        System.out.println("Request Body: " + new String(body));
    }

    private void logResponseDetails(ClientHttpResponse response) throws IOException {
        // 응답 정보 로깅
        System.out.println("HTTP Status Code: " + response.getStatusCode());
        System.out.println("Status Text: " + response.getStatusText());
        System.out.println("HTTP Headers: " + response.getHeaders());
    }
}
