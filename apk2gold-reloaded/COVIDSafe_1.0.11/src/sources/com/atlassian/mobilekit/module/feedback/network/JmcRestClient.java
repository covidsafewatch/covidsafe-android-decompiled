package com.atlassian.mobilekit.module.feedback.network;

import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public final class JmcRestClient {
    private JmcApi jmcApi = null;

    public void init(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append("/");
        this.jmcApi = (JmcApi) new Builder().baseUrl(sb.toString()).addConverterFactory(GsonConverterFactory.create()).build().create(JmcApi.class);
    }

    public JmcApi getJmcApi() {
        return this.jmcApi;
    }
}
