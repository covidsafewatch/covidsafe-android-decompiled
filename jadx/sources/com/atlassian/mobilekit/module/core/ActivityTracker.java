package com.atlassian.mobilekit.module.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class ActivityTracker implements Application.ActivityLifecycleCallbacks, UiInfo {
    private WeakReference<Activity> activityRef = new WeakReference<>((Object) null);
    private boolean isAppVisible = false;
    private final CopyOnWriteArraySet<UiInfoListener> listeners = new CopyOnWriteArraySet<>();

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public ActivityTracker(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public Activity getCurrentActivity() {
        Activity activity = (Activity) this.activityRef.get();
        if (activity == null) {
            return activity;
        }
        if (!activity.isFinishing() && !activity.isChangingConfigurations()) {
            return activity;
        }
        this.activityRef = new WeakReference<>((Object) null);
        return null;
    }

    public boolean isAppVisible() {
        return this.isAppVisible;
    }

    public void registerListener(UiInfoListener uiInfoListener) {
        this.listeners.add(uiInfoListener);
    }

    public void unregisterListener(UiInfoListener uiInfoListener) {
        this.listeners.remove(uiInfoListener);
    }

    private void notifyAppVisible() {
        this.isAppVisible = true;
        Iterator<UiInfoListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAppVisible();
        }
    }

    private void notifyAppNotVisible() {
        this.isAppVisible = false;
        Iterator<UiInfoListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAppNotVisible();
        }
    }

    public void onActivityResumed(Activity activity) {
        boolean z = this.activityRef.get() == null;
        this.activityRef = new WeakReference<>(activity);
        if (z) {
            notifyAppVisible();
        }
    }

    public void onActivityStopped(Activity activity) {
        if (this.activityRef.get() == activity) {
            this.activityRef = new WeakReference<>((Object) null);
            notifyAppNotVisible();
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.activityRef.get() == activity) {
            this.activityRef = new WeakReference<>((Object) null);
        }
    }
}
