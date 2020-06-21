package edmt.dev.androideatitv2client.Remote;

import edmt.dev.androideatitv2client.Model.FCMResponse;
import edmt.dev.androideatitv2client.Model.FCMSendData;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAA7HLPA4A:APA91bF3pQAJ3mBBmyJvufUEt4XAbC_MSBLizFmuAAIUpkqP-vO2udCEVxtwKhzpnMLZtw6elVnoWkVAWNMhXta7icsjA99QoHQ2UxgHXkmBJtw9kguvlArGayO6ynLs5ZjBMExzPjJr"

    })
    @POST("fcm/send")
    Observable<FCMResponse> sendNotification(@Body FCMSendData body);
}
