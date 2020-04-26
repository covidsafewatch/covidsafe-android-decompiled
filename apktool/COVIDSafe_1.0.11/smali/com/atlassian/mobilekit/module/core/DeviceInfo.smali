.class public final Lcom/atlassian/mobilekit/module/core/DeviceInfo;
.super Ljava/lang/Object;
.source "DeviceInfo.java"


# static fields
.field private static final ANDROID_OS:Ljava/lang/String; = "Android OS"

.field private static final NAMESPACE:Ljava/lang/String; = "com.atlassian.mobilekit.module.core"

.field private static final STORE_NAME:Ljava/lang/String; = "com.atlassian.mobilekit.module.core.preferences"

.field private static final UUID_KEY:Ljava/lang/String; = "com.atlassian.mobilekit.module.core.UUID"


# instance fields
.field private appVersionCode:I

.field private appVersionName:Ljava/lang/String;

.field private final ctx:Landroid/content/Context;

.field private final store:Landroid/content/SharedPreferences;

.field private udid:Ljava/lang/String;

.field private uuid:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    .line 31
    iput v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->appVersionCode:I

    .line 34
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->ctx:Landroid/content/Context;

    const-string v0, "com.atlassian.mobilekit.module.core.preferences"

    const/4 v1, 0x0

    .line 35
    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object p1

    iput-object p1, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->store:Landroid/content/SharedPreferences;

    return-void
.end method

.method private getPackageInfo()Landroid/content/pm/PackageInfo;
    .locals 3

    .line 139
    :try_start_0
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    .line 141
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private declared-synchronized initUdid()Ljava/lang/String;
    .locals 2

    monitor-enter p0

    .line 39
    :try_start_0
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "android_id"

    invoke-static {v0, v1}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 43
    monitor-exit p0

    return-object v0

    .line 41
    :cond_0
    :try_start_1
    new-instance v0, Ljava/lang/AssertionError;

    const-string v1, "ANDROID_ID setting was null"

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized initUuid()Ljava/lang/String;
    .locals 3

    monitor-enter p0

    .line 47
    :try_start_0
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->store:Landroid/content/SharedPreferences;

    const-string v1, "com.atlassian.mobilekit.module.core.UUID"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    .line 49
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 50
    iget-object v1, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->store:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "com.atlassian.mobilekit.module.core.UUID"

    .line 51
    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 52
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 54
    :cond_0
    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public getAppName()Ljava/lang/String;
    .locals 2

    .line 78
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->ctx:Landroid/content/Context;

    .line 79
    invoke-virtual {v1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v0

    .line 80
    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAppPkgName()Ljava/lang/String;
    .locals 1

    .line 74
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAppVersionCode()I
    .locals 2

    .line 93
    iget v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->appVersionCode:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 94
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getPackageInfo()Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 95
    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I

    iput v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->appVersionCode:I

    .line 98
    :cond_0
    iget v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->appVersionCode:I

    return v0
.end method

.method public getAppVersionName()Ljava/lang/String;
    .locals 1

    .line 84
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->appVersionName:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 85
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getPackageInfo()Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 86
    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->appVersionName:Ljava/lang/String;

    .line 89
    :cond_0
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->appVersionName:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceName()Ljava/lang/String;
    .locals 1

    .line 110
    sget-object v0, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    return-object v0
.end method

.method public getLanguage()Ljava/lang/String;
    .locals 1

    .line 118
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Locale;->getDisplayLanguage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getLocale()Ljava/lang/String;
    .locals 3

    .line 122
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    .line 123
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getModel()Ljava/lang/String;
    .locals 1

    .line 114
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    return-object v0
.end method

.method public getSystemName()Ljava/lang/String;
    .locals 1

    const-string v0, "Android OS"

    return-object v0
.end method

.method public getSystemVersion()Ljava/lang/String;
    .locals 1

    .line 102
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    return-object v0
.end method

.method public getUdid()Ljava/lang/String;
    .locals 1

    .line 66
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->udid:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 67
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->initUdid()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->udid:Ljava/lang/String;

    .line 70
    :cond_0
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->udid:Ljava/lang/String;

    return-object v0
.end method

.method public getUuid()Ljava/lang/String;
    .locals 1

    .line 58
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->uuid:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 59
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->initUuid()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->uuid:Ljava/lang/String;

    .line 62
    :cond_0
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->uuid:Ljava/lang/String;

    return-object v0
.end method

.method public hasConnectivity()Z
    .locals 2

    .line 127
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->ctx:Landroid/content/Context;

    const-string v1, "connectivity"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    return v1

    .line 132
    :cond_0
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 133
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v1, 0x1

    :cond_1
    return v1
.end method
