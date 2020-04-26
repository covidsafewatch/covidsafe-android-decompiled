.class public final Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;
.super Ljava/lang/Object;
.source "PersonalDetailsPresenter.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nPersonalDetailsPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersonalDetailsPresenter.kt\nau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter\n*L\n1#1,96:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\tH\u0002J$\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\t2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\tJ&\u0010\u0011\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\t2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0012\u001a\u00020\u000e2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0013\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0014\u001a\u00020\u000e2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\tH\u0002J\u0017\u0010\u0015\u001a\u00020\u000e2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\tH\u0000\u00a2\u0006\u0002\u0008\u0016J$\u0010\u0017\u001a\u00020\u000b2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\t2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\tR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;",
        "",
        "personalDetailsFragment",
        "Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;",
        "(Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;)V",
        "POST_CODE_REGEX",
        "Ljava/util/regex/Pattern;",
        "kotlin.jvm.PlatformType",
        "TAG",
        "",
        "isPostCodeValid",
        "",
        "postCode",
        "saveInfos",
        "",
        "name",
        "age",
        "showFieldsError",
        "updateAgeFieldError",
        "updateNameFieldError",
        "updatePostcodeFieldError",
        "validateInlinePostCode",
        "validateInlinePostCode$app_release",
        "validateInputsForButtonUpdate",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field private final POST_CODE_REGEX:Ljava/util/regex/Pattern;

.field private final TAG:Ljava/lang/String;

.field private final personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;)V
    .locals 1

    const-string v0, "personalDetailsFragment"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    .line 8
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object p1

    const-string v0, "this.javaClass.simpleName"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->TAG:Ljava/lang/String;

    const-string p1, "^(?:(?:[2-8]\\d|9[0-7]|0?[28]|0?9(?=09))(?:\\d{2}))$"

    .line 10
    invoke-static {p1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->POST_CODE_REGEX:Ljava/util/regex/Pattern;

    return-void
.end method

.method private final isPostCodeValid(Ljava/lang/String;)Z
    .locals 1

    .line 94
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->POST_CODE_REGEX:Ljava/util/regex/Pattern;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v0, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object p1

    invoke-virtual {p1}, Ljava/util/regex/Matcher;->matches()Z

    move-result p1

    return p1
.end method

.method private final showFieldsError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .line 49
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->updateNameFieldError(Ljava/lang/String;)V

    .line 50
    invoke-direct {p0, p3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->updateAgeFieldError(Ljava/lang/String;)V

    .line 51
    invoke-direct {p0, p2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->updatePostcodeFieldError(Ljava/lang/String;)V

    return-void
.end method

.method private final updateAgeFieldError(Ljava/lang/String;)V
    .locals 0

    .line 55
    check-cast p1, Ljava/lang/CharSequence;

    if-eqz p1, :cond_1

    invoke-static {p1}, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z

    move-result p1

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 p1, 0x1

    :goto_1
    if-eqz p1, :cond_2

    .line 56
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->showAgeError()V

    goto :goto_2

    .line 58
    :cond_2
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->hideAgeError()V

    :goto_2
    return-void
.end method

.method private final updateNameFieldError(Ljava/lang/String;)V
    .locals 0

    .line 63
    check-cast p1, Ljava/lang/CharSequence;

    if-eqz p1, :cond_1

    invoke-static {p1}, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z

    move-result p1

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 p1, 0x1

    :goto_1
    if-eqz p1, :cond_2

    .line 64
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->showNameError()V

    goto :goto_2

    .line 66
    :cond_2
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->hideNameError()V

    :goto_2
    return-void
.end method

.method private final updatePostcodeFieldError(Ljava/lang/String;)V
    .locals 0

    .line 71
    check-cast p1, Ljava/lang/CharSequence;

    if-eqz p1, :cond_1

    invoke-static {p1}, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z

    move-result p1

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 p1, 0x1

    :goto_1
    if-eqz p1, :cond_2

    .line 72
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->showPostcodeError()V

    goto :goto_2

    .line 74
    :cond_2
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->hidePostcodeError()V

    :goto_2
    return-void
.end method


# virtual methods
.method public final saveInfos(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7

    .line 13
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->showLoading()V

    .line 14
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_10

    if-eqz p3, :cond_0

    .line 15
    invoke-static {p3}, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 16
    :goto_0
    move-object v2, p1

    check-cast v2, Ljava/lang/CharSequence;

    const/4 v3, 0x1

    const/4 v4, 0x0

    if-eqz v2, :cond_2

    invoke-static {v2}, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    goto :goto_1

    :cond_1
    move v2, v4

    goto :goto_2

    :cond_2
    :goto_1
    move v2, v3

    :goto_2
    xor-int/2addr v2, v3

    .line 17
    move-object v5, p2

    check-cast v5, Ljava/lang/CharSequence;

    if-eqz v5, :cond_4

    invoke-static {v5}, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_3

    goto :goto_3

    :cond_3
    move v5, v4

    goto :goto_4

    :cond_4
    :goto_3
    move v5, v3

    :goto_4
    if-nez v5, :cond_5

    invoke-direct {p0, p2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->isPostCodeValid(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    move v5, v3

    goto :goto_5

    :cond_5
    move v5, v4

    .line 18
    :goto_5
    move-object v6, p3

    check-cast v6, Ljava/lang/CharSequence;

    if-eqz v6, :cond_7

    invoke-static {v6}, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_6

    goto :goto_6

    :cond_6
    move v6, v4

    goto :goto_7

    :cond_7
    :goto_6
    move v6, v3

    :goto_7
    xor-int/2addr v6, v3

    if-eqz v2, :cond_f

    if-eqz v5, :cond_f

    if-eqz v6, :cond_f

    const-string v2, "context"

    if-eqz p1, :cond_8

    .line 22
    sget-object v5, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v5, v0, p1}, Lau/gov/health/covidsafe/Preference;->putName(Landroid/content/Context;Ljava/lang/String;)Z

    move-result p1

    goto :goto_8

    :cond_8
    move p1, v4

    :goto_8
    if-eqz p1, :cond_b

    if-eqz p3, :cond_9

    .line 25
    sget-object p1, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1, v0, p3}, Lau/gov/health/covidsafe/Preference;->putAge(Landroid/content/Context;Ljava/lang/String;)Z

    move-result p1

    goto :goto_9

    :cond_9
    move p1, v4

    :goto_9
    if-eqz p1, :cond_b

    if-eqz p2, :cond_a

    .line 28
    sget-object p1, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1, v0, p2}, Lau/gov/health/covidsafe/Preference;->putPostCode(Landroid/content/Context;Ljava/lang/String;)Z

    move-result p1

    goto :goto_a

    :cond_a
    move p1, v4

    :goto_a
    if-eqz p1, :cond_b

    move p1, v3

    goto :goto_b

    :cond_b
    move p1, v4

    :goto_b
    if-eqz p1, :cond_e

    .line 32
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->hideLoading()V

    .line 33
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    if-eqz v1, :cond_d

    check-cast v1, Ljava/lang/Number;

    invoke-virtual {v1}, Ljava/lang/Number;->intValue()I

    move-result p2

    const/16 p3, 0x10

    if-ge p2, p3, :cond_c

    goto :goto_c

    :cond_c
    move v3, v4

    :goto_c
    move v4, v3

    :cond_d
    invoke-virtual {p1, v4}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->navigateToNextPage(Z)V

    goto :goto_d

    .line 35
    :cond_e
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->hideLoading()V

    .line 36
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->showGenericError()V

    goto :goto_d

    .line 39
    :cond_f
    invoke-direct {p0, p1, p2, p3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->showFieldsError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->hideLoading()V

    goto :goto_d

    .line 42
    :cond_10
    move-object p1, p0

    check-cast p1, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;

    .line 43
    iget-object p2, p1, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->hideLoading()V

    .line 44
    iget-object p1, p1, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->showGenericError()V

    :goto_d
    return-void
.end method

.method public final validateInlinePostCode$app_release(Ljava/lang/String;)V
    .locals 2

    .line 87
    move-object v0, p1

    check-cast v0, Ljava/lang/CharSequence;

    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    if-nez v0, :cond_2

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_2

    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->isPostCodeValid(Ljava/lang/String;)Z

    move-result p1

    if-nez p1, :cond_2

    .line 88
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->showPostcodeError()V

    goto :goto_2

    .line 90
    :cond_2
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->personalDetailsFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->hidePostcodeError()V

    :goto_2
    return-void
.end method

.method public final validateInputsForButtonUpdate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 3

    .line 79
    check-cast p1, Ljava/lang/CharSequence;

    const/4 v0, 0x0

    const/4 v1, 0x1

    if-eqz p1, :cond_1

    invoke-static {p1}, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z

    move-result p1

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    move p1, v0

    goto :goto_1

    :cond_1
    :goto_0
    move p1, v1

    :goto_1
    xor-int/2addr p1, v1

    .line 80
    move-object v2, p2

    check-cast v2, Ljava/lang/CharSequence;

    if-eqz v2, :cond_3

    invoke-static {v2}, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    goto :goto_2

    :cond_2
    move v2, v0

    goto :goto_3

    :cond_3
    :goto_2
    move v2, v1

    :goto_3
    if-nez v2, :cond_4

    invoke-direct {p0, p2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->isPostCodeValid(Ljava/lang/String;)Z

    move-result p2

    if-eqz p2, :cond_4

    move p2, v1

    goto :goto_4

    :cond_4
    move p2, v0

    .line 81
    :goto_4
    check-cast p3, Ljava/lang/CharSequence;

    if-eqz p3, :cond_6

    invoke-static {p3}, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z

    move-result p3

    if-eqz p3, :cond_5

    goto :goto_5

    :cond_5
    move p3, v0

    goto :goto_6

    :cond_6
    :goto_5
    move p3, v1

    :goto_6
    xor-int/2addr p3, v1

    if-eqz p1, :cond_7

    if-eqz p2, :cond_7

    if-eqz p3, :cond_7

    move v0, v1

    :cond_7
    return v0
.end method
