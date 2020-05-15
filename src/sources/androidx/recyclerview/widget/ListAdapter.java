package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener = new AsyncListDiffer.ListListener<T>() {
        public void onCurrentListChanged(List<T> list, List<T> list2) {
            ListAdapter.this.onCurrentListChanged(list, list2);
        }
    };

    public void onCurrentListChanged(List<T> list, List<T> list2) {
    }

    protected ListAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).build());
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(this.mListener);
    }

    protected ListAdapter(AsyncDifferConfig<T> asyncDifferConfig) {
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(this.mListener);
    }

    public void submitList(List<T> list) {
        this.mDiffer.submitList(list);
    }

    public void submitList(List<T> list, Runnable runnable) {
        this.mDiffer.submitList(list, runnable);
    }

    /* access modifiers changed from: protected */
    public T getItem(int i) {
        return this.mDiffer.getCurrentList().get(i);
    }

    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }
}
