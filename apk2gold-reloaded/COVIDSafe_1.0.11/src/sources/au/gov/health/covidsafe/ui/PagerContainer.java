package au.gov.health.covidsafe.ui;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0019\u0010\u0005\u001a\u00020\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0017\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H&J\u0017\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\b¨\u0006\u0011"}, d2 = {"Lau/gov/health/covidsafe/ui/PagerContainer;", "", "disableNextButton", "", "enableNextButton", "hideLoading", "stringRes", "", "(Ljava/lang/Integer;)V", "refreshButton", "updateButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout;", "setNavigationIcon", "navigationIcon", "showLoading", "updateProgressBar", "stepProgress", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PagerContainer.kt */
public interface PagerContainer {
    void disableNextButton();

    void enableNextButton();

    void hideLoading(Integer num);

    void refreshButton(UploadButtonLayout uploadButtonLayout);

    void setNavigationIcon(Integer num);

    void showLoading();

    void updateProgressBar(Integer num);
}
