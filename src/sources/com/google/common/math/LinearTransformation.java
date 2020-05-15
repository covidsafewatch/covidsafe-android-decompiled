package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

public abstract class LinearTransformation {
    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d);

    public static LinearTransformationBuilder mapping(double d, double d2) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d) && DoubleUtils.isFinite(d2));
        return new LinearTransformationBuilder(d, d2);
    }

    public static final class LinearTransformationBuilder {
        private final double x1;
        private final double y1;

        private LinearTransformationBuilder(double d, double d2) {
            this.x1 = d;
            this.y1 = d2;
        }

        public LinearTransformation and(double d, double d2) {
            boolean z = true;
            Preconditions.checkArgument(DoubleUtils.isFinite(d) && DoubleUtils.isFinite(d2));
            double d3 = this.x1;
            if (d != d3) {
                return withSlope((d2 - this.y1) / (d - d3));
            }
            if (d2 == this.y1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            return new VerticalLinearTransformation(this.x1);
        }

        public LinearTransformation withSlope(double d) {
            Preconditions.checkArgument(!Double.isNaN(d));
            if (DoubleUtils.isFinite(d)) {
                return new RegularLinearTransformation(d, this.y1 - (this.x1 * d));
            }
            return new VerticalLinearTransformation(this.x1);
        }
    }

    public static LinearTransformation vertical(double d) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d));
        return new VerticalLinearTransformation(d);
    }

    public static LinearTransformation horizontal(double d) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d));
        return new RegularLinearTransformation(0.0d, d);
    }

    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.INSTANCE;
    }

    private static final class RegularLinearTransformation extends LinearTransformation {
        @LazyInit
        LinearTransformation inverse;
        final double slope;
        final double yIntercept;

        public boolean isVertical() {
            return false;
        }

        RegularLinearTransformation(double d, double d2) {
            this.slope = d;
            this.yIntercept = d2;
            this.inverse = null;
        }

        RegularLinearTransformation(double d, double d2, LinearTransformation linearTransformation) {
            this.slope = d;
            this.yIntercept = d2;
            this.inverse = linearTransformation;
        }

        public boolean isHorizontal() {
            return this.slope == 0.0d;
        }

        public double slope() {
            return this.slope;
        }

        public double transform(double d) {
            return (d * this.slope) + this.yIntercept;
        }

        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        public String toString() {
            return String.format("y = %g * x + %g", new Object[]{Double.valueOf(this.slope), Double.valueOf(this.yIntercept)});
        }

        private LinearTransformation createInverse() {
            double d = this.slope;
            if (d != 0.0d) {
                return new RegularLinearTransformation(1.0d / d, (this.yIntercept * -1.0d) / d, this);
            }
            return new VerticalLinearTransformation(this.yIntercept, this);
        }
    }

    private static final class VerticalLinearTransformation extends LinearTransformation {
        @LazyInit
        LinearTransformation inverse;
        final double x;

        public boolean isHorizontal() {
            return false;
        }

        public boolean isVertical() {
            return true;
        }

        VerticalLinearTransformation(double d) {
            this.x = d;
            this.inverse = null;
        }

        VerticalLinearTransformation(double d, LinearTransformation linearTransformation) {
            this.x = d;
            this.inverse = linearTransformation;
        }

        public double slope() {
            throw new IllegalStateException();
        }

        public double transform(double d) {
            throw new IllegalStateException();
        }

        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        public String toString() {
            return String.format("x = %g", new Object[]{Double.valueOf(this.x)});
        }

        private LinearTransformation createInverse() {
            return new RegularLinearTransformation(0.0d, this.x, this);
        }
    }

    private static final class NaNLinearTransformation extends LinearTransformation {
        static final NaNLinearTransformation INSTANCE = new NaNLinearTransformation();

        public LinearTransformation inverse() {
            return this;
        }

        public boolean isHorizontal() {
            return false;
        }

        public boolean isVertical() {
            return false;
        }

        public double slope() {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }

        public double transform(double d) {
            return Double.NaN;
        }

        private NaNLinearTransformation() {
        }
    }
}
