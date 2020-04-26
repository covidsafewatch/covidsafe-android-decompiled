package androidx.appcompat.view.menu;

import androidx.appcompat.view.menu.MenuPresenter.Callback;

interface MenuHelper {
    void dismiss();

    void setPresenterCallback(Callback callback);
}
