package com.atlassian.mobilekit.module.feedback.network;

import com.atlassian.mobilekit.module.feedback.model.CreateIssueRequest;
import com.atlassian.mobilekit.module.feedback.model.CreateIssueResponse;
import java.util.List;
import java.util.Map;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;

public interface JmcApi {
    @POST("rest/jconnect/latest/issue/create")
    @Multipart
    Call<CreateIssueResponse> createIssue(@QueryMap Map<String, String> map, @Part("issue") CreateIssueRequest createIssueRequest, @Part List<MultipartBody.Part> list, @Part List<MultipartBody.Part> list2);
}
