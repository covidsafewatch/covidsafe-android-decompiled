package androidx.navigation;

import androidx.navigation.NavArgument;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R,\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Landroidx/navigation/NavArgumentBuilder;", "", "()V", "_type", "Landroidx/navigation/NavType;", "builder", "Landroidx/navigation/NavArgument$Builder;", "value", "defaultValue", "getDefaultValue", "()Ljava/lang/Object;", "setDefaultValue", "(Ljava/lang/Object;)V", "", "nullable", "getNullable", "()Z", "setNullable", "(Z)V", "type", "getType", "()Landroidx/navigation/NavType;", "setType", "(Landroidx/navigation/NavType;)V", "build", "Landroidx/navigation/NavArgument;", "navigation-common-ktx_release"}, k = 1, mv = {1, 1, 15})
@NavDestinationDsl
/* compiled from: NavDestinationBuilder.kt */
public final class NavArgumentBuilder {
    private NavType<?> _type;
    private final NavArgument.Builder builder = new NavArgument.Builder();
    private Object defaultValue;
    private boolean nullable;

    public final void setType(NavType<?> navType) {
        Intrinsics.checkParameterIsNotNull(navType, "value");
        this._type = navType;
        this.builder.setType(navType);
    }

    public final NavType<?> getType() {
        NavType<?> navType = this._type;
        if (navType != null) {
            return navType;
        }
        throw new IllegalStateException("NavType has not been set on this builder.");
    }

    public final boolean getNullable() {
        return this.nullable;
    }

    public final void setNullable(boolean z) {
        this.nullable = z;
        this.builder.setIsNullable(z);
    }

    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    public final void setDefaultValue(Object obj) {
        this.defaultValue = obj;
        this.builder.setDefaultValue(obj);
    }

    public final NavArgument build() {
        NavArgument build = this.builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder.build()");
        return build;
    }
}
