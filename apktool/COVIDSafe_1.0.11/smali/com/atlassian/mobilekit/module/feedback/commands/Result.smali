.class public final enum Lcom/atlassian/mobilekit/module/feedback/commands/Result;
.super Ljava/lang/Enum;
.source "Result.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lcom/atlassian/mobilekit/module/feedback/commands/Result;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/atlassian/mobilekit/module/feedback/commands/Result;

.field public static final enum FAIL:Lcom/atlassian/mobilekit/module/feedback/commands/Result;

.field public static final enum SUCCESS:Lcom/atlassian/mobilekit/module/feedback/commands/Result;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .line 5
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    const/4 v1, 0x0

    const-string v2, "SUCCESS"

    invoke-direct {v0, v2, v1}, Lcom/atlassian/mobilekit/module/feedback/commands/Result;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->SUCCESS:Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    const/4 v2, 0x1

    const-string v3, "FAIL"

    invoke-direct {v0, v3, v2}, Lcom/atlassian/mobilekit/module/feedback/commands/Result;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->FAIL:Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    const/4 v3, 0x2

    new-array v3, v3, [Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    .line 4
    sget-object v4, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->SUCCESS:Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    aput-object v4, v3, v1

    aput-object v0, v3, v2

    sput-object v3, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->$VALUES:[Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 4
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/commands/Result;
    .locals 1

    .line 4
    const-class v0, Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    return-object p0
.end method

.method public static values()[Lcom/atlassian/mobilekit/module/feedback/commands/Result;
    .locals 1

    .line 4
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->$VALUES:[Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    invoke-virtual {v0}, [Lcom/atlassian/mobilekit/module/feedback/commands/Result;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    return-object v0
.end method
