.class public interface abstract Lcom/atlassian/mobilekit/module/feedback/network/JmcApi;
.super Ljava/lang/Object;
.source "JmcApi.java"


# virtual methods
.method public abstract createIssue(Ljava/util/Map;Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;Ljava/util/List;Ljava/util/List;)Lretrofit2/Call;
    .param p1    # Ljava/util/Map;
        .annotation runtime Lretrofit2/http/QueryMap;
        .end annotation
    .end param
    .param p2    # Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;
        .annotation runtime Lretrofit2/http/Part;
            value = "issue"
        .end annotation
    .end param
    .param p3    # Ljava/util/List;
        .annotation runtime Lretrofit2/http/Part;
        .end annotation
    .end param
    .param p4    # Ljava/util/List;
        .annotation runtime Lretrofit2/http/Part;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;",
            "Ljava/util/List<",
            "Lokhttp3/MultipartBody$Part;",
            ">;",
            "Ljava/util/List<",
            "Lokhttp3/MultipartBody$Part;",
            ">;)",
            "Lretrofit2/Call<",
            "Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;",
            ">;"
        }
    .end annotation

    .annotation runtime Lretrofit2/http/Multipart;
    .end annotation

    .annotation runtime Lretrofit2/http/POST;
        value = "rest/jconnect/latest/issue/create"
    .end annotation
.end method
