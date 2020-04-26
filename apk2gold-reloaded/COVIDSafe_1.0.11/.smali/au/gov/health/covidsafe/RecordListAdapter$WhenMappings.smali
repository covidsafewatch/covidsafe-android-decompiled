.class public final synthetic Lau/gov/health/covidsafe/RecordListAdapter$WhenMappings;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field public static final synthetic $EnumSwitchMapping$0:[I


# direct methods
.method static synthetic constructor <clinit>()V
    .locals 3

    invoke-static {}, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->values()[Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lau/gov/health/covidsafe/RecordListAdapter$WhenMappings;->$EnumSwitchMapping$0:[I

    sget-object v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->COLLAPSE:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1

    sget-object v0, Lau/gov/health/covidsafe/RecordListAdapter$WhenMappings;->$EnumSwitchMapping$0:[I

    sget-object v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->ALL:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1

    sget-object v0, Lau/gov/health/covidsafe/RecordListAdapter$WhenMappings;->$EnumSwitchMapping$0:[I

    sget-object v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->MODEL_P:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1

    sget-object v0, Lau/gov/health/covidsafe/RecordListAdapter$WhenMappings;->$EnumSwitchMapping$0:[I

    sget-object v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->MODEL_C:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1

    return-void
.end method
