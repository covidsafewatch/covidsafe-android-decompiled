.class public final Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;
.super Ljava/lang/Object;
.source "JmcRestClient.java"


# instance fields
.field private jmcApi:Lcom/atlassian/mobilekit/module/feedback/network/JmcApi;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 9
    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;->jmcApi:Lcom/atlassian/mobilekit/module/feedback/network/JmcApi;

    return-void
.end method


# virtual methods
.method public getJmcApi()Lcom/atlassian/mobilekit/module/feedback/network/JmcApi;
    .locals 1

    .line 32
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;->jmcApi:Lcom/atlassian/mobilekit/module/feedback/network/JmcApi;

    return-object v0
.end method

.method public init(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .line 17
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 18
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 19
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, "/"

    .line 20
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 21
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 23
    new-instance p2, Lretrofit2/Retrofit$Builder;

    invoke-direct {p2}, Lretrofit2/Retrofit$Builder;-><init>()V

    .line 24
    invoke-virtual {p2, p1}, Lretrofit2/Retrofit$Builder;->baseUrl(Ljava/lang/String;)Lretrofit2/Retrofit$Builder;

    move-result-object p1

    .line 25
    invoke-static {}, Lretrofit2/converter/gson/GsonConverterFactory;->create()Lretrofit2/converter/gson/GsonConverterFactory;

    move-result-object p2

    invoke-virtual {p1, p2}, Lretrofit2/Retrofit$Builder;->addConverterFactory(Lretrofit2/Converter$Factory;)Lretrofit2/Retrofit$Builder;

    move-result-object p1

    .line 26
    invoke-virtual {p1}, Lretrofit2/Retrofit$Builder;->build()Lretrofit2/Retrofit;

    move-result-object p1

    .line 28
    const-class p2, Lcom/atlassian/mobilekit/module/feedback/network/JmcApi;

    invoke-virtual {p1, p2}, Lretrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/atlassian/mobilekit/module/feedback/network/JmcApi;

    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;->jmcApi:Lcom/atlassian/mobilekit/module/feedback/network/JmcApi;

    return-void
.end method
