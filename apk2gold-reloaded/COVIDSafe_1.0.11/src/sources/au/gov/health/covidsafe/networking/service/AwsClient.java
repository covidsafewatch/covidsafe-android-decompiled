package au.gov.health.covidsafe.networking.service;

import au.gov.health.covidsafe.networking.request.AuthChallengeRequest;
import au.gov.health.covidsafe.networking.request.OTPChallengeRequest;
import au.gov.health.covidsafe.networking.response.AuthChallengeResponse;
import au.gov.health.covidsafe.networking.response.BroadcastMessageResponse;
import au.gov.health.covidsafe.networking.response.InitiateUploadResponse;
import au.gov.health.covidsafe.networking.response.OTPChallengeResponse;
import au.gov.health.covidsafe.networking.response.UploadOTPResponse;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH'J\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H'J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u0006H'J\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H'J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\t\u001a\u00020\u0013H'¨\u0006\u0014"}, d2 = {"Lau/gov/health/covidsafe/networking/service/AwsClient;", "", "getTempId", "Lretrofit2/Call;", "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;", "jwtToken", "", "initiateAuth", "Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;", "body", "Lau/gov/health/covidsafe/networking/request/OTPChallengeRequest;", "initiateReUpload", "Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;", "initiateUpload", "pin", "requestUploadOtp", "Lau/gov/health/covidsafe/networking/response/UploadOTPResponse;", "respondToAuthChallenge", "Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;", "Lau/gov/health/covidsafe/networking/request/AuthChallengeRequest;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AwsClient.kt */
public interface AwsClient {
    @GET("/prod/getTempId")
    Call<BroadcastMessageResponse> getTempId(@Header("Authorization") String str);

    @POST("/prod/initiateAuth")
    Call<OTPChallengeResponse> initiateAuth(@Body OTPChallengeRequest oTPChallengeRequest);

    @GET("/prod/initiateDataUpload")
    Call<InitiateUploadResponse> initiateReUpload(@Header("Authorization") String str);

    @GET("/prod/initiateDataUpload")
    Call<InitiateUploadResponse> initiateUpload(@Header("Authorization") String str, @Header("pin") String str2);

    @GET("/prod/requestUploadOtp")
    Call<UploadOTPResponse> requestUploadOtp(@Header("Authorization") String str);

    @POST("/prod/respondToAuthChallenge")
    Call<AuthChallengeResponse> respondToAuthChallenge(@Body AuthChallengeRequest authChallengeRequest);
}
