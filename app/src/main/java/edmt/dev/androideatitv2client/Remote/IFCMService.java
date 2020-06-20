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
            "Authorization:key=AAAAPd4Sfz0:APA91bF62W0NJqYjYtCwbGOjH8k4EyQuj6ZCTtGHTR69p4VxBabWtzXZIsqNbRtCZR6PxXjBKGA70TK7pDqjvtEWRD4JP3ROlExf6frJIvHrodSYPe0teIvsEVYHrx4W7ZZuJt25QUYw"

    })
    @POST("fcm/send")
    Observable<FCMResponse> sendNotification(@Body FCMSendData body);
}
