package au.gov.health.covidsafe;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordStorage;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: PeekActivity.kt */
final class PeekActivity$newPeek$6 implements View.OnClickListener {
    final /* synthetic */ PeekActivity this$0;

    PeekActivity$newPeek$6(PeekActivity peekActivity) {
        this.this$0 = peekActivity;
    }

    public final void onClick(final View view) {
        Intrinsics.checkExpressionValueIsNotNull(view, "view");
        view.setEnabled(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0);
        builder.setTitle((CharSequence) "Are you sure?").setCancelable(false).setMessage((CharSequence) "Deleting the DB records is irreversible").setPositiveButton((CharSequence) "DELETE", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {
            final /* synthetic */ PeekActivity$newPeek$6 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(final DialogInterface dialogInterface, int i) {
                Observable.create(new ObservableOnSubscribe<T>(this) {
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void subscribe(ObservableEmitter<Boolean> observableEmitter) {
                        Intrinsics.checkParameterIsNotNull(observableEmitter, "it");
                        new StreetPassRecordStorage(this.this$0.this$0.this$0).nukeDb();
                        observableEmitter.onNext(true);
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<Boolean>(this) {
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void accept(Boolean bool) {
                        Toast.makeText(this.this$0.this$0.this$0, "Database nuked: " + bool, 0).show();
                        View view = view;
                        Intrinsics.checkExpressionValueIsNotNull(view, "view");
                        view.setEnabled(true);
                        dialogInterface.cancel();
                    }
                });
            }
        }).setNegativeButton((CharSequence) "DON'T DELETE", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                View view = view;
                Intrinsics.checkExpressionValueIsNotNull(view, "view");
                view.setEnabled(true);
                dialogInterface.cancel();
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "builder.create()");
        create.show();
    }
}
