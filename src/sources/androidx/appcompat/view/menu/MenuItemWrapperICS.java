package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
    static final String LOG_TAG = "MenuItemWrapper";
    private Method mSetExclusiveCheckableMethod;
    private final SupportMenuItem mWrappedObject;

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context);
        if (supportMenuItem != null) {
            this.mWrappedObject = supportMenuItem;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public int getItemId() {
        return this.mWrappedObject.getItemId();
    }

    public int getGroupId() {
        return this.mWrappedObject.getGroupId();
    }

    public int getOrder() {
        return this.mWrappedObject.getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.mWrappedObject.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        this.mWrappedObject.setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mWrappedObject.setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return this.mWrappedObject.getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        this.mWrappedObject.setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.mWrappedObject.setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return this.mWrappedObject.getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        this.mWrappedObject.setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return this.mWrappedObject.getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        this.mWrappedObject.setShortcut(c, c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.mWrappedObject.setShortcut(c, c2, i, i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.mWrappedObject.setNumericShortcut(c);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.mWrappedObject.setNumericShortcut(c, i);
        return this;
    }

    public char getNumericShortcut() {
        return this.mWrappedObject.getNumericShortcut();
    }

    public int getNumericModifiers() {
        return this.mWrappedObject.getNumericModifiers();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.mWrappedObject.setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.mWrappedObject.setAlphabeticShortcut(c, i);
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.mWrappedObject.getAlphabeticShortcut();
    }

    public int getAlphabeticModifiers() {
        return this.mWrappedObject.getAlphabeticModifiers();
    }

    public MenuItem setCheckable(boolean z) {
        this.mWrappedObject.setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return this.mWrappedObject.isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        this.mWrappedObject.setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return this.mWrappedObject.isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return this.mWrappedObject.setVisible(z);
    }

    public boolean isVisible() {
        return this.mWrappedObject.isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        this.mWrappedObject.setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return this.mWrappedObject.isEnabled();
    }

    public boolean hasSubMenu() {
        return this.mWrappedObject.hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return getSubMenuWrapper(this.mWrappedObject.getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mWrappedObject.setOnMenuItemClickListener(onMenuItemClickListener != null ? new OnMenuItemClickListenerWrapper(onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mWrappedObject.getMenuInfo();
    }

    public void setShowAsAction(int i) {
        this.mWrappedObject.setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        this.mWrappedObject.setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.mWrappedObject.setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        this.mWrappedObject.setActionView(i);
        View actionView = this.mWrappedObject.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.mWrappedObject.setActionView((View) new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = this.mWrappedObject.getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? ((CollapsibleActionViewWrapper) actionView).getWrappedView() : actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.core.view.ActionProvider actionProvider2;
        if (Build.VERSION.SDK_INT >= 16) {
            actionProvider2 = new ActionProviderWrapperJB(this.mContext, actionProvider);
        } else {
            actionProvider2 = new ActionProviderWrapper(this.mContext, actionProvider);
        }
        SupportMenuItem supportMenuItem = this.mWrappedObject;
        if (actionProvider == null) {
            actionProvider2 = null;
        }
        supportMenuItem.setSupportActionProvider(actionProvider2);
        return this;
    }

    public ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider supportActionProvider = this.mWrappedObject.getSupportActionProvider();
        if (supportActionProvider instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) supportActionProvider).mInner;
        }
        return null;
    }

    public boolean expandActionView() {
        return this.mWrappedObject.expandActionView();
    }

    public boolean collapseActionView() {
        return this.mWrappedObject.collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return this.mWrappedObject.isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.mWrappedObject.setOnActionExpandListener(onActionExpandListener != null ? new OnActionExpandListenerWrapper(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.mWrappedObject.setContentDescription(charSequence);
        return this;
    }

    public CharSequence getContentDescription() {
        return this.mWrappedObject.getContentDescription();
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.mWrappedObject.setTooltipText(charSequence);
        return this;
    }

    public CharSequence getTooltipText() {
        return this.mWrappedObject.getTooltipText();
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.mWrappedObject.setIconTintList(colorStateList);
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.mWrappedObject.getIconTintList();
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mWrappedObject.setIconTintMode(mode);
        return this;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.mWrappedObject.getIconTintMode();
    }

    public void setExclusiveCheckable(boolean z) {
        try {
            if (this.mSetExclusiveCheckableMethod == null) {
                this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e);
        }
    }

    private class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener mObject;

        OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.mObject = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.mObject.onMenuItemClick(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }
    }

    private class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener mObject;

        OnActionExpandListenerWrapper(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.mObject = onActionExpandListener;
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.mObject.onMenuItemActionExpand(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.mObject.onMenuItemActionCollapse(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }
    }

    private class ActionProviderWrapper extends androidx.core.view.ActionProvider {
        final ActionProvider mInner;

        ActionProviderWrapper(Context context, ActionProvider actionProvider) {
            super(context);
            this.mInner = actionProvider;
        }

        public View onCreateActionView() {
            return this.mInner.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.mInner.onPerformDefaultAction();
        }

        public boolean hasSubMenu() {
            return this.mInner.hasSubMenu();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.mInner.onPrepareSubMenu(MenuItemWrapperICS.this.getSubMenuWrapper(subMenu));
        }
    }

    private class ActionProviderWrapperJB extends ActionProviderWrapper implements ActionProvider.VisibilityListener {
        private ActionProvider.VisibilityListener mListener;

        ActionProviderWrapperJB(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public View onCreateActionView(MenuItem menuItem) {
            return this.mInner.onCreateActionView(menuItem);
        }

        public boolean overridesItemVisibility() {
            return this.mInner.overridesItemVisibility();
        }

        public boolean isVisible() {
            return this.mInner.isVisible();
        }

        public void refreshVisibility() {
            this.mInner.refreshVisibility();
        }

        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            this.mListener = visibilityListener;
            this.mInner.setVisibilityListener(visibilityListener != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            ActionProvider.VisibilityListener visibilityListener = this.mListener;
            if (visibilityListener != null) {
                visibilityListener.onActionProviderVisibilityChanged(z);
            }
        }
    }

    static class CollapsibleActionViewWrapper extends FrameLayout implements androidx.appcompat.view.CollapsibleActionView {
        final CollapsibleActionView mWrappedView;

        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.mWrappedView = (CollapsibleActionView) view;
            addView(view);
        }

        public void onActionViewExpanded() {
            this.mWrappedView.onActionViewExpanded();
        }

        public void onActionViewCollapsed() {
            this.mWrappedView.onActionViewCollapsed();
        }

        /* access modifiers changed from: package-private */
        public View getWrappedView() {
            return (View) this.mWrappedView;
        }
    }
}
