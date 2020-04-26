.class public Lcom/atlassian/mobilekit/module/core/FeedbackBaseActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "FeedbackBaseActivity.java"


# instance fields
.field private isPaused:Z

.field private pausedAt:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 6
    invoke-direct {p0}, Landroidx/appcompat/app/AppCompatActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected getPausedDuration()J
    .locals 4

    .line 30
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/atlassian/mobilekit/module/core/FeedbackBaseActivity;->pausedAt:J

    sub-long/2addr v0, v2

    return-wide v0
.end method

.method protected isPaused()Z
    .locals 1

    .line 26
    iget-boolean v0, p0, Lcom/atlassian/mobilekit/module/core/FeedbackBaseActivity;->isPaused:Z

    return v0
.end method

.method protected onPause()V
    .locals 2

    .line 13
    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onPause()V

    const/4 v0, 0x1

    .line 14
    iput-boolean v0, p0, Lcom/atlassian/mobilekit/module/core/FeedbackBaseActivity;->isPaused:Z

    .line 15
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/atlassian/mobilekit/module/core/FeedbackBaseActivity;->pausedAt:J

    return-void
.end method

.method protected onResume()V
    .locals 2

    .line 20
    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onResume()V

    const/4 v0, 0x0

    .line 21
    iput-boolean v0, p0, Lcom/atlassian/mobilekit/module/core/FeedbackBaseActivity;->isPaused:Z

    const-wide/16 v0, 0x0

    .line 22
    iput-wide v0, p0, Lcom/atlassian/mobilekit/module/core/FeedbackBaseActivity;->pausedAt:J

    return-void
.end method
