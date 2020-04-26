package com.atlassian.mobilekit.module.core;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class ActivityTracker implements ActivityLifecycleCallbacks, UiInfo {
    private WeakReference<Activity> activityRef = new WeakReference<>(null);
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
        this.activityRef = new WeakReference<>(null);
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
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((UiInfoListener) it.next()).onAppVisible();
        }
    }

    private void notifyAppNotVisible() {
        this.isAppVisible = false;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((UiInfoListener) it.next()).onAppNotVisible();
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
            this.activityRef = new WeakReference<>(null);
            notifyAppNotVisible();
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.activityRef.get() == activity) {
            this.activityRef = new WeakReference<>(null);
        }
    }
}
