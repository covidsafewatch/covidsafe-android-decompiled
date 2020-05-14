package au.gov.health.covidsafe.notifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import au.gov.health.covidsafe.HomeActivity;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lau/gov/health/covidsafe/notifications/NotificationTemplates;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: NotificationTemplates.kt */
public final class NotificationTemplates {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;", "", "()V", "getRunningNotification", "Landroid/app/Notification;", "context", "Landroid/content/Context;", "channel", "", "getUploadReminder", "lackingThingsNotification", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: NotificationTemplates.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Notification getRunningNotification(Context context, String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "channel");
            Notification build = new NotificationCompat.Builder(context, str).setOngoing(true).setPriority(-1).setSmallIcon(R.drawable.ic_notification_icon).setContentIntent(PendingIntent.getActivity(context, 5, new Intent(context, HomeActivity.class), 0)).setWhen(System.currentTimeMillis()).setSound((Uri) null).setVibrate((long[]) null).setColor(ContextCompat.getColor(context, R.color.notification_tint)).build();
            Intrinsics.checkExpressionValueIsNotNull(build, "builder.build()");
            return build;
        }

        public final Notification lackingThingsNotification(Context context, String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "channel");
            Intent intent = new Intent(context, HomeActivity.class);
            intent.putExtra("page", 3);
            PendingIntent activity = PendingIntent.getActivity(context, 10, intent, 0);
            Notification build = new NotificationCompat.Builder(context, str).setContentTitle(context.getText(R.string.service_not_ok_title)).setContentText(context.getText(R.string.service_not_ok_body)).setStyle(new NotificationCompat.BigTextStyle().bigText(context.getText(R.string.service_not_ok_body))).setOngoing(true).setPriority(-1).setSmallIcon(R.drawable.ic_notification_warning).setTicker(context.getText(R.string.service_not_ok_body)).addAction(R.drawable.ic_notification_setting, context.getText(R.string.service_not_ok_action), activity).setContentIntent(activity).setWhen(System.currentTimeMillis()).setSound((Uri) null).setVibrate((long[]) null).setColor(ContextCompat.getColor(context, R.color.notification_tint)).build();
            Intrinsics.checkExpressionValueIsNotNull(build, "builder.build()");
            return build;
        }

        public final Notification getUploadReminder(Context context, String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "channel");
            Intent intent = new Intent(context, HomeActivity.class);
            intent.putExtra("uploadNotification", true);
            PendingIntent activity = PendingIntent.getActivity(context, 13, intent, 134217728);
            Notification build = new NotificationCompat.Builder(context, str).setContentTitle(context.getText(R.string.upload_your_data_title)).setContentText(context.getText(R.string.upload_your_data_description)).setOngoing(false).setPriority(0).setSmallIcon(R.drawable.ic_notification_icon).setTicker(context.getText(R.string.upload_your_data_description)).setStyle(new NotificationCompat.BigTextStyle().bigText(context.getText(R.string.upload_your_data_description))).setAutoCancel(true).addAction(R.drawable.ic_notification_setting, context.getText(R.string.upload_data_action), activity).setContentIntent(activity).setWhen(System.currentTimeMillis()).setSound((Uri) null).setVibrate((long[]) null).setColor(ContextCompat.getColor(context, R.color.notification_tint)).build();
            Intrinsics.checkExpressionValueIsNotNull(build, "builder.build()");
            return build;
        }
    }
}
