package com.atlassian.mobilekit.module.feedback.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class JmcRestClient {
    private JmcApi jmcApi = null;

    public void init(String str, String str2) {
        this.jmcApi = (JmcApi) new Retrofit.Builder().baseUrl(str + str2 + "/").addConverterFactory(GsonConverterFactory.create()).build().create(JmcApi.class);
    }

    public JmcApi getJmcApi() {
        return this.jmcApi;
    }
}
