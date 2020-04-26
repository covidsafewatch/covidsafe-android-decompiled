.class final Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;
.super Lkotlin/jvm/internal/Lambda;
.source "PlotActivity.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;->accept(Lau/gov/health/covidsafe/ui/upload/model/DebugData;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function1<",
        "Ljava/lang/String;",
        "Ljava/lang/CharSequence;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\u0008\u0004"
    }
    d2 = {
        "<anonymous>",
        "",
        "model",
        "",
        "invoke"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic $endTimeString:Ljava/lang/String;

.field final synthetic $sortedModelList:Ljava/util/List;

.field final synthetic $startTimeString:Ljava/lang/String;

.field final synthetic $top:I

.field final synthetic this$0:Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;->this$0:Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;

    iput-object p2, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;->$sortedModelList:Ljava/util/List;

    iput p3, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;->$top:I

    iput-object p4, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;->$startTimeString:Ljava/lang/String;

    iput-object p5, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;->$endTimeString:Ljava/lang/String;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/String;)Ljava/lang/CharSequence;
    .locals 2

    const-string v0, "model"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 208
    iget-object v0, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;->$sortedModelList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result p1

    add-int/lit8 p1, p1, 0x1

    .line 209
    iget v0, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;->$top:I

    if-ge p1, v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "\n                                              xaxis"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 210
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, ": {\n                                                type: \'date\',\n                                                tickformat: \'%H:%M:%S\',\n                                                range: [\'"

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 213
    iget-object p1, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;->$startTimeString:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, "\', \'"

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object p1, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;->$endTimeString:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, "\'],\n                                                dtick: "

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 214
    iget-object p1, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;->this$0:Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;

    iget p1, p1, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;->$displayTimePeriod:I

    mul-int/lit8 p1, p1, 0x5

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " * 60 * 1000\n                                              }\n                                    "

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 216
    invoke-static {p1}, Lkotlin/text/StringsKt;->trimIndent(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    :cond_0
    const-string p1, ""

    :goto_0
    check-cast p1, Ljava/lang/CharSequence;

    return-object p1
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 22
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;->invoke(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object p1

    return-object p1
.end method
